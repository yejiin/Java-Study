# 싱글톤 (Singleton) 패턴

인스턴스를 오직 **한 개**만 제공하는 클래스     

시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개일 때 문제가 생길 수 있는 경우가 있다.
    
    ⇒ 인스턴스를 오직 한 개만 만들어 제공하는 클래스가 필요하다.
    
    
 ## 구현 방법
 1. [private 생성자에 static 메서드](https://github.com/yejiin/Java-Study/blob/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_01_singleton/Settings1.java) 
    1. 생성자를 private 으로 만든 이유?    
    ⇒ 새로운 객체를 생성하지 못하게 하기 위해
    2. getInstance() 메서드를 static 으로 선언한 이유?     
    ⇒ 인스턴스를 생성하지 않고 만들어진 하나의 인스턴스를 어디에서든지 사용하기 위해
    3. getInstance() 가 멀티쓰레스 환경에서 안전하지 않은 이유?    
    ⇒ A, B 쓰레드가 있다고 가정했을 때, A 쓰레드가 먼저 getInstance 메서드에 접근하고 객체가 완전히 생성하기 전 B 쓰레드가 getInstance()를 호출했을 때 서로 다른 객체가 생성될 수 있다.
 2. [동기화(synchronized)를 사용해 멀티쓰레드 환경에 안전하게 만드는 방법](https://github.com/yejiin/Java-Study/blob/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_01_singleton/Settings2.java)
 3. [이른 초기화(eager initialization)을 사용하는 방법](https://github.com/yejiin/Java-Study/blob/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_01_singleton/Settings3.java)
 4. [double checked locking으로 효율적인 동기화 블럭 만들기](https://github.com/yejiin/Java-Study/blob/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_01_singleton/Settings4.java)
 5. [static inner 클래스를 사용하는 방법](https://github.com/yejiin/Java-Study/blob/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_01_singleton/Settings5.java)
 6. [enum을 사용하는 방법](https://github.com/yejiin/Java-Study/blob/master/design-patterns/src/main/java/com/example/designpatterns/_01_creational_patterns/_01_singleton/Settings6.java)
