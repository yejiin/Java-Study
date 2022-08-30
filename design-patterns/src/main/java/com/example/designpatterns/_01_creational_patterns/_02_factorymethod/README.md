# 팩토리 메서드 (Factory method) 패턴

부모(상위) 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴이며, 자식(하위) 클래스가 어떤 객체를 생성할지 결정한다.

    -> 부모(상위) 클래스 코드에 구체 클래스 이름을 감추기 위한 방법이다.
    -> 다양한 구현체 (Product) 가 있고, 그중에서 특정한 구현체를 만들 수 있는 다양한 팩토리 (Creator)를 제공할 수 있다.

<img width="317" alt="image" src="https://user-images.githubusercontent.com/63090006/188814843-d84a2278-eb31-40ca-bb67-5ec41b8ca3a1.png">