# CashedRowSet
java JDBC API 일부, ResultSet 데이터를 메모리에 캐시하는 기능을 제공
DB와 연결이 끊긴 상태에도 데이터를 처리할 수 있도록 설계된 API

## populate
```java
ResultSet rs = new ResultSet();

~~~

CashedRowSet crs = new CashedRowSet(); 
crs.pupulate(rs);
```
ResultSet객체의 데이터를 CashedRowSet데이터로 변환 시켜준다.