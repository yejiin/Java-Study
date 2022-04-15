## [Java Collections - Time Complexity](http://infotechgems.blogspot.com/2011/11/java-collections-performance-time.html)

>### List
||add()|remove()|get()|contains()|
|------|---|---|---|---|
|**ArrayList**|O(1)|O(n)|O(1)|O(n)|
|**LinkedList**|O(1)|O(1)|O(n)|O(n)|

<br>

>### Set
||add()|contains()|next()|
|------|---|---|---|
|**HashSet**|O(1)|O(1)|O(h/n)|
|**LinkedHashSet**|O(1)|O(1)|O(1)|

<br>

>### Queue
||offer()|peak()|poll()|size()|
|------|---|---|---|---|
|**PriorityQueue**|O(log n)|O(1)|O(log n)|O(1)|
|**LinkedList**|O(1)|O(1)|O(1)|O(1)|
|**ArrayDequeue**|O(1)|O(1)|O(log n)|O(1)|

<br>

>### Map
||get()|containsKey()|next()|
|------|---|---|---|
|**HashMap**|O(1)|O(1)|O(h/n)|
|**LinkedHashMap**|O(1)|O(1)|O(1)|
|**TreeMap**|O(log n)|O(log n)|O(log n)|
