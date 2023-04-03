# 오늘 막혔던거

## 상세조회 시 맴버코드와 맴버이름이 서로 일치 하지 않음

dispatch로 두 API 호출 

우선 기존에 있던 결재 디테일 api를 호출하고 그다음에 호출한 값을 파라미터로 받아 회원 디테일 api를 호출해야함 그리고 그 값을 useSelector에서 data를 가져와 memberName을 가져옴

문제1. apicall컴포넌트들은 비동기로 가져오기 때문에 memberName이 undefined가 될 때 에러 발생함

→

`memberName && <label> memberName </label>` 으로 memberName이 undefined가 아닐때만 나타나게 구성했으나 오류 발생

---

→ 

APIcall 컴포넌트들을 순서 있게 실행

```jsx
useEffect(() => {
  const fetchData = async () => {
    try {
      await dispatch(callApprovalDetailAPI({ appCode: paramAppCode.appCode }));
      // memberCode와 memberName이 달라 작성자가 달라지는 문제 해결을 위한 API
      await dispatch(callMemberDetailAPI({ memberCode: memberCode }));
    } catch (error) {
      console.error("Error while calling APIs: ", error);
    }
  };

  fetchData();
  // eslint-disable-next-line
}, []);
```

await로 callApprovalDetailAPI가 실행 될 때 callMemberDetailAPI는 대기 하는 형식으로 코드 구성했으나 똑같은 오류 발생

---

→

똑같은 오류라 완전히 실행되고 다음 apicall컴포넌트가 실행 되도록 변경

```jsx
useEffect(() => {
    const fetchData = async () => {
        try {
            await dispatch(callApprovalDetailAPI({ appCode: paramAppCode.appCode }));
        } catch (error) {
            console.error("Error while calling callApprovalDetailAPI: ", error);
        }
    };

    fetchData();
    //eslint-disable-next-line
}, []);

useEffect(() => {
    const fetchMemberData = async () => {
        try {
            if (memberCode) {
                await dispatch(callMemberDetailAPI({ memberCode: memberCode }));
            }
        } catch (error) {
            console.error("Error while calling callMemberDetailAPI: ", error);
        }
    };

    fetchMemberData();
    //eslint-disable-next-line
}, [memberCode]);
```

문제 해결

### async와 await에 대한 이해도 부족

---

**async** : 함수 앞에 사용하고 해당 함수가 비동기로 작동하게 만든다 항상 Promise를 반환하고 일반적으론 await키워드와 같이 사용한다.

**await:** async 함수 내에서 사용 Promise가 해결될 때 까지 코드를 일시 중지 await는 Promise를 처리하고 Promise가 해결되면 결과 값을 반환한다.