# CachedRowSet 
java JDBC API 일부, ResultSet 데이터를 메모리에 캐시하는 기능을 제공
DB와 연결이 끊긴 상태에도 데이터를 처리할 수 있도록 설계된 API


## RowSetProvider
RowSetFactory의 인스턴스를 생성하는 정적 메서드인 `newFactory()`를 제공
해당 메서드는 `RowSetFactory`객체를 반환한다.

## CreateCachedRowSet()
`CachedRowSet`인스턴스를 생성한다.

## populate
```java
ResultSet rs = new ResultSet();

~~~

CachedRowSet  crs = new CachedRowSet (); 
crs.pupulate(rs);
```
ResultSet객체의 데이터를 CachedRowSet 데이터로 변환 시켜준다.