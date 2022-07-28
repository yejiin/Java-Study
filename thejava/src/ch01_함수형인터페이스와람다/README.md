#### [Java 가 기본으로 제공하는 함수형 인터페이스](#Java-가-기본으로-제공하는-함수형-인터페이스)
#### [메서드 레퍼런스](#메서드-레퍼런스)

<br>

---

## Java 가 기본으로 제공하는 함수형 인터페이스

### Function<T, R>
- T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
  - `R apply(T t)`
- 함수 조합용 메서드
  - andThen
  - compose

<br>

### BiFunction<T, U, R>
- 두 개의 값(T, U) 를 받아서 R 타입을 리턴하는 함수 인터페이스
  - R `apply(T t, U u)`

<br>

### Consumer<T>
- T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
  - `void Accept(T t)`
- 함수 조합용 메서드
  - andThen

<br>

### Supplier<T>
- T 타입의 값을 제공하는 함수 인터페이스 
  - `T get()`
<br>

### Predicate<T>
- T 타입을 받어서 boolean 을 리턴하는 함수 인터페이스
  - boolean test(T t)
- 함수 조합용 메서드
  - And
  - Or
  - Negate

<br>

### UnaryOperator<T>
- Function<T, R> 의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스

<br>

### BinaryOperator<T>
- BiFunction<T, U, R) 의 특수한 형태로, 동일한 타입의 입력값 두 개를 받아 리턴하는 인터페이스


<br>
<br>

## 메서드 레퍼런스
- 스태틱 메서드 참조 `타입::스태틱 메서드`
- 특정 객체의 인스턴스 메서드 참조 `객체 레퍼런스::인스턴스 메서드`
- 임의 객체의 인스턴스 메서드 참조 `타입::인스턴스 메서드`
- 생성자 참조 `타입::new`
