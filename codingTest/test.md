## 서로 다른 두 문자열을 번갈아가면서 출력하는 문제

1. 두 문자열을 합치고 합친 문자열의 길이 만큼 반복문을 돌린뒤 charAt메서드로 하나씩 뽑아서 answer 문자열에 대입
→ str1의 문자열의 길이가 5이고 str2 문자열의 길이가 5일때 sumStr은 10이 되고 그럼 10번을 반복하는건데 str1은 길이가 5밖에 안돼서 index error 발생
2. 두 문자열이 같다는 조건을 못봐서 그냥 str1의 문자열만큼 반복하고 charAt메서드로 하나씩 뽑아서 answer에 대입
3. `answer += str1 + str2` 를 했지만 문자열이 아닌 숫자가 나와서 따로 따로 answer에 저장

### 다른 사람의 풀이

```java
int len = str1.length();

String[] charArr1 = str1.spilt("");
String[] charArr2 = str2.spilt("");

for(int i = 0; i < len; i++) {
	answer += charArr1[i] + charArr2[i];
}

return answer;
```

---
