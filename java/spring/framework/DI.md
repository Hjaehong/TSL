- Dependency Injection
- 외부에서 두 객체 간 관계를  결정하는 디자인 패턴?
-
- 기존 코드들은 인터페이스와 그 구현체에 의존했다.
- ```java
  // 인터페이스					구현체
  MybatisService mySer = new MybatisServiceImpl();
  
  public void method1(){
    ....
  }
  ```
- 하지만 해당 디자인 패턴을 이용하면 위 클래스는 인터페이스에만 의존하고 구현체에는 의존 안할 수 있다.
- -> 구현체 부분을 config라는 클래스로 분리하여 외부에서 해당 인터페이스를 어떤 구현체에게 구현 시킬지 정할 수 있기 때문이다.
-
- 이러한 패턴을 spring에선 IoP(제어의 역전)이 라고도 한다.