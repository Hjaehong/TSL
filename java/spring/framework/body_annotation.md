# @body

### @RequestBody

HTTP  요청 본문의 내용을 자바 객체로 매핑하도록 지시

→ view단의 요청을 원하는 자바 객체에 대입

```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    // user 객체를 사용하여 사용자를 생성하는 로직
    return userService.createUser(user);
}
```

### @ResponseBody

클라이언트에게 전송되는 응답 데이터

```java
@GetMapping("/users/{id}")
@ResponseBody
public User getUser(@PathVariable String id) {
    // ID를 기반으로 사용자 정보를 조회하는 로직
    return userService.getUserById(id);
}
```

### 공통점

HTTP 요청 본문을 해당 자바 객체로 변환하기 위해 혹은 HTTP 응답 본문으로 변환하기 위해 `HttpMessageConverter` 인터페이스를 사용한다.