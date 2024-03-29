# 프로토타입 패턴
기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법
- 복제 기능을 갖추고 있는 기존 인스턴스를 프로토타입으로 사용해 새 인스턴스를 만들 수 있다.

![](https://user-images.githubusercontent.com/63090006/193747157-8479b781-1435-4a78-b34a-4a411e937dd1.png)

## 장점
- 복잡한 객체를 만드는 과정을 숨길 수 있다.
- 기존 객체를 복제하는 과정이 새 인스턴스를 만드는 것보다 비용(시간 또는 메모리)적인면에서 효율적일 수도 있다.
- 클라이언트는 구체적인 형식을 몰다도 객체를 생성할 수 있다.

## 단점
- 객체의 복사본을 만드는 과정 자체가 복잡할 수 있다.