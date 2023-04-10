STOMP는 프레임 기반 프로토콜로, HTTP를 모델로 한 프레임을 사용합니다. 프레임은 명령, 선택적 헤더 세트, 선택적 본문으로 구성됩니다. STOMP는 텍스트 기반이지만 바이너리 메시지 전송도 허용합니다. STOMP의 기본 인코딩은 UTF-8이지만 메시지 본문에 대한 대체 인코딩 사양을 지원합니다.

내가 격었던 오류들 

1. `configuration.setAllowCredentials(true);` 를 추가 안해줘서 생긴 오류
2. `.setAllowedOrigins("http://localhost:3000")` 외부 주소 허락 안 해줌
3. `@SendTo` 어노테이션 사용시 `registry.enableSimpleBroker("/topic");` 구독 주소까지 url에 포함 시켜야 했는데 포함 안시켜서 메세지가 전달 안됨 