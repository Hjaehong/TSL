SELECT
    MEMBER_ID
  , MEMBER_NAME
  , GENDER
  , DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
  FROM MEMBER_PROFILE
 WHERE NOT TLNO = '' AND EXTRACT(MONTH FROM DATE_OF_BIRTH) = 3 AND GENDER = 'W'
 ORDER BY MEMBER_ID ASC;

 --MEMBER_PROFILE 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요. 
 --이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으로 오름차순 정렬해주세요.

-- user_id와 product_id로 묶어서 동일한 게 (count가 2이상)인 user_id를 추출
 SELECT
    user_id
  , product_id
  , COUNT(*)
  FROM ONLINE_SALE
 GROUP BY user_id, product_id
 HAVING COUNT(*) > 1;

 --> 해당 결과를 서브쿼리로 해서 하면 될거 같다

 SELECT
    user_id
  , product_id
  , COUNT(*)
  FROM ONLINE_SALE
 WHERE IN (SELECT
    user_id
  , product_id
  , COUNT(*)
  FROM ONLINE_SALE
 GROUP BY user_id, product_id
 HAVING COUNT(*) > 1)
 ORDER BY user_id ASC,
          product_id DESC;

-- 조건절을 걸었으나 in절을 사용할 땐 서브쿼리가 하나여야 한다는 조건을 채우지 못해서
-- from절에 서브 쿼리 추가

SELECT
    user_id
  , product_id
  FROM 
  ( SELECT
        user_id
      , product_id
      , COUNT(*) AS purchase_count
      FROM ONLINE_SALE
     GROUP BY user_id, product_id
  ) AS purchase_count
  where purchase_count > 1
  order by
    user_id asc
  , product_id desc;
  
SELECT
    user_id
  , product_id
  FROM 
  ( SELECT
        user_id
      , product_id
      , COUNT(*) AS purchase_count
      FROM ONLINE_SALE
     GROUP BY user_id, product_id
     HAVING COUNT(*) > 1
  ) AS purchase_count
  order by
    user_id asc
  , product_id desc;