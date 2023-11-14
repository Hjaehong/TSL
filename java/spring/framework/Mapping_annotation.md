# Mapping

### @RequestMapping

클래스 or 메서드에서 사용 HTTP 요청을 특정 핸들러 메서드에 매핑하는 가장 기본적인 방법을 제공 

- 모든 HTTP메서드에 사용될 수 있다 (GET, POST, PUT, DELETE)
- method 속성을 통해 특정 HTTP메서드에 대한 매핑을 제한 할 수 있다.

```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
public String getUsers() {
    // 사용자 목록을 가져오는 코드
}

@RequestMapping(value = "/users", method = RequestMethod.POST)
public String addUser() {
    // 사용자를 추가하는 코드
}
```

**@GetMapping**

@RequestMapping의 특수한 형태 **오직 HTTP GET요청에 대해서만 메서드를 맵핑**한다.

```java
@GetMapping("/users")
public String getUsers() {
    // 사용자 목록을 가져오는 코드
}
```

**@PostMapping**

@RequestMapping의 특수한 형태 **오직 HTTP POST요청에 대해서만 메서드를 맵핑**한다.

```java
@PostMapping("/users")
public String addUser() {
    // 사용자를 추가하는 코드
}
```