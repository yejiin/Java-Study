# 이터레이터 패턴
집합 객체 내부 구조를 노출시키지 않고 순회하는 방법을 제공하는 패턴
- 집합 객체를 순회하는 클라이언트 코드를 변경하지 않고 다양한 순회 방법을 제공할 수 있다.
<img width="574" alt="image" src="https://user-images.githubusercontent.com/63090006/215327299-9654ec91-1220-41da-8b72-0152aadd3ee9.png">

## 장점
- 집합 객체가 가지고 있는 객체들에 손쉽게 접근할 수 있다.
- 일관된 인터페이스를 사용해 여러 형태의 집합 구조를 순회할 수 있다.

## 단점
- 클래스가 늘어나고 복잡도가 증가한다.
