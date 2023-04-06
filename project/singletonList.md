singletonList 사용

singletonList() 메서드는 주어진 객체(클라이언트에서 배열로 받은 memberCode)를 고정 크기의 리스트로 반환한다.

→ 각 멤버코드를 가진 단일 요소 리스트를 생성 할 수 있다

```java
for(Integer memberCode : messengerDTO.getMemberCode()) {
                MessengerDTO addMessengerDTO = new MessengerDTO();
                addMessengerDTO.setRoomNum(messengerDTO.getRoomNum());
                addMessengerDTO.setMemberCode(Collections.singletonList(memberCode));
                addMessengerDTO.setRoomNum(messengerDTO.getRoomNum());
                
                int arrayResult = messengerMapper.messengerRegister(addMessengerDTO);

                if(result == 0){
                    throw new Exception("생성 실패!");
                }

                result += arrayResult;
            }
```

result += arrayResult 는 여러번의 

Required request parameter 'messengerRequestDTO' for method parameter type MessengerRequestDTO is not present
오류 발생 @RequestBody로 요청값을 DTO에 전달해줘야하는데 @ReqeuestParams으로 실수