# 객체 지향 설계 원칙 (SOLID)
- **단일 책임의 원칙 (Single responsibility principle, SRP)**
  - 한 클래스는 하나의 책임만 가져야 한다.
- **개방 폐쇄 원칙 (Open/closed principle, OCP)**
  - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫쳐 있어야 한다.
- **리스코프 치환 원칙 (Liskov substitution principle, LSP)**
  - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- **인터페이스 분리의 원칙 (Interface segregation principle, ISP)**
  - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
- **의존 관계 역전의 원칙 (Dependency inversion principle, DIP)**
  - 추상화에 의존해야지, 구체화에 의존하면 안된다.

<br>
<br>

# 생성 패턴
생성 패턴은 객체 간 강력한 결합 관계를 느슨한 결합으로 변경하는 설계 기법이다. 객체의 확장을 보다 유연하게 하고 유지 보수를 편리하게 한다.

## 1. [싱글톤 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_01_singleton)
## 2. [팩토리 매서드 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_02_factory_method)
## 3. [추상 팩토리 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_03_abstract_factory)
## 4. [빌더 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_04_builder)
## 5. [프로토타입 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_05_prototype)

<br>

# 구조 패턴

## 1. 어댑터 패턴
## 2. 브릿지 패턴
## 3. 컴포짓 패턴
## 4. [데코레이터 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_02_structural_patterns/_09_decorator)
## 5. 퍼사드 패턴
## 6. [플라이웨이트 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_02_structural_patterns/_11_flyweight)
## 7. 프록시 패턴

<br>

# 행동 패턴

## 1. [책임 연쇄 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_03_behavior_patterns/_13_chain_of_responsibilities)
## 2. 커맨드 패턴
## 3. [인터프리터 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_03_behavior_patterns/_15_interpreter)
## 4. 이터레이터 패턴
## 5. [중재자 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_03_behavior_patterns/_17_mediator)
## 6. [메멘토 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_03_behavior_patterns/_18_memento)
## 7. [옵저버 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_03_behavior_patterns/_19_observer)
## 8. 상태 패턴
## 9. [전략 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_03_behavior_patterns/_21_strategy)
## 10. 템플릿 메소드 패턴
## 11. [비지터 패턴](https://github.com/yejiin/Java-Study/tree/master/design-patterns/src/main/java/com/example/designpatterns/_03_behavior_patterns/_23_visitor)
