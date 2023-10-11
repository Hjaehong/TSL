## String

- String은 불변적이다
    
    그럼 이걸 변경가능하도록 하는 방법 **StringBuilder** 와 **StringBuffer** 가 있다 둘 다 문자열의 수정,삭제, 추가 시 별로의 객체를 만들지 않는 공통점이 있고, 대량의 문자열을 조작시 효율성을 크게 상승 시킬 수 있다.
    
    하지만 이둘의 차이점은 **동기화** 이다.
    
    - **StringBuilder
    동기화가 되지 않는다.** 
    한 번에 하나의 스레드만이 **StringBuilder** 객체를 변경할 수 있다. 즉, 단일 스레드 환경에서 문자열을 조작해야 하는 경우 적합하다 **StringBuffer** 에 비해 빠르기 때문에, 멀티 스레드 환경이 아닐 경우 왠만하면 사용한다.
    
    ```java
    StringBuilder builder = new StringBuilder();
    
    builder.append("Hello");
    builder.append(" ");
    builder.append("friend");
    
    System.out.println(builder.toString());  // 출력: Hello friend
    ```
    
    - **StringBuffer
    동기화가 된다.** 
    여러 스레드에서 동시에 접근하더라도 안전하게 동작한다.
    동기화는 오버헤드를 발생시키므로, 단일 스레드 환경에서는 일반적으로 **StringBuilder**를 사용하는 것이 좋다.
    
    ```java
    StringBuffer buffer = new StringBuffer();
    
    buffer.append("Hello");
    buffer.append(" ");
    buffer.append("friend");
    
    System.out.println(buffer.toString());  // 출력: Hello friend
    ```
    
- 숫자 자료형의 변환은 ‘+’ 연산자를 사용한다. ( java9이후)
    
    java9이전의 String은 + 연산자로 결합을 할 때 컴파일러가 **StringBuilder**의 **append()** 메서드를 사용하는 코드로 변환을 시켰지만 지금은 **StringConcatFactory** 라는 새로운 클래스를 도입하여 **invokeddynamic** 바이트코드 명령어를 사용하여 더 효율적인 문자열 결합을 제공한다
    **그럼 왜 + 연산자는 처리성능이 낮았을까?**
    위에서 처럼 **StringBuilder**클래스의 메서드를 컴파일러가 호출했기 때문에 번번한 +연산자사용은 **StringBuilder**객체를 호출하기 때문이다
    
- 글자를 나눌 땐 split 메서드를 사용한다.