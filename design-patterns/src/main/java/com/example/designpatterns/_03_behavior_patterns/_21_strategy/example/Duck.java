package com.example.designpatterns._03_behavior_patterns._21_strategy.example;

public abstract class Duck {

    // 행동 인터페이스 형식의 레퍼런스 변수 2개를 선언
    // 같은 패키지에 속하는 모든 서브클래스에서 이 변수를 상속받음
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void performFly() {
        this.flyBehavior.fly();  // 행동 클래스에 위임
    }

    public void performQuack() {
        this.quackBehavior.quack();  // 행동 클래스에 위임
    }

    public void swim() {
        System.out.println("모든 오리는 물에 뜹니다.");
    }
}
