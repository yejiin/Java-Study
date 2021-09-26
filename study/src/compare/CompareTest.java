package compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareTest {

	public static void main(String[] args) {
		// primitive Type 정렬 : Arrays.sort()
		int[] num = { 5, 6, 2, 9, 3, 1, 8, 7, 4 };
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));

		Integer[] num2 = { 5, 6, 2, 9, 3, 1, 8, 7, 4 };
		List<Integer> list = Arrays.asList(num2);
		System.out.println("1. list : " + list);
		Collections.reverse(list);
		System.out.println("1-1. reverse(내림차순) : " + list);
		Collections.sort(list);
		System.out.println("2. 정렬(오름차순) : " + list);
		Collections.reverse(list);
		System.out.println("3. reverse(내림차순) : " + list);

		List<Integer> list2 = Arrays.asList(num2);
		System.out.println(list2);
		Collections.sort(list2, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
//				return i1.intValue() - i2.intValue(); //  앞에서 뒤 빼면 오름차순
				return i2.intValue() - i1.intValue(); // 뒤에서 앞 빼면 내림차순
			}

		});
		System.out.println("5. 정렬 후 : " + list);
	}
}
