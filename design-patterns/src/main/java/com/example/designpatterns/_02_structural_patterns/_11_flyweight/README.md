# 플라이웨이트 패턴
객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
- 자주 변하는 속성(또는 외적인 속성, extrinsic)과 변하지 않는 속성(또는 내적인 속성, intrinsic)을 분리하고 재사용하여 메모리 사용을 줄일 수 있다.

![](https://user-images.githubusercontent.com/63090006/193758113-71b8882a-7702-431c-abbc-1b80150ff923.png)

## 장점
- 실행 시에 객체 인스턴스의 개수를 줄여서 메모리를 절약할 수  있다.
- 여러 '가상' 객체의 상태를 한곳에 모아 둘 수 있다.

## 단점
- 특정 인스턴스만 다른 인스턴스와 다르게 행동할 수 없다.

## 사용법
- 어떤 클래스의 인스턴스가 아주 많이 필요하지만 모두 똑같은 방식으로 제어해야 할 때 유용하게 사용된다.
