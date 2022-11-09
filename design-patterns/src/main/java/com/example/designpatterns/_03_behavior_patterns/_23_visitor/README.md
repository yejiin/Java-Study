# 비지터 패턴
기존 코드를 변경하지 않고 새로운 기능을 추가하는 방법

- 다양한 객체에 새로운 기능을 추가해야 하는데 캡슐화가 별로 중요하지 않는다면 비지터 패턴을 사용할 수 있다.

![](https://user-images.githubusercontent.com/63090006/193794095-13f41fa0-17ed-4319-abf4-a461563c9b10.png)

## 장점
- 기존 코드를 변경하지 않고 새로운 코드를 추가할 수 잇다.
- visitor 가 수행하는 기능과 관련된 코드를 한 곳에 모아 둘 수 있다.

## 단점
- 복잡하다.
- 새로운 Element 를 추가하거나 제거할 때 모든 Visitor 코드를 변경해야 한다.