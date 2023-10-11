# 1. 스프링 부트(Spring Boot) 개요

## 1-1. 스프링 부트란?

- 필요한 환경 설정을 최소화하고 개발자가 비즈니스 로직에 집중할 수 있도록 도와줘 생산성을 크게 향상시킬 수 있도록 스프링의 단점을 보완하여 만든 프로젝트이다.
- 스프링 부트는 틀림없이 자바에서 REST 기반 마이크로서비스 웹 애플리케이션을 개발하는 가장 빠른 방법 중 하나로 도커 컨테이너 배포 및 빠른 프로토타이핑에도 매우 적합하다.
- 간혹 스프링부트를 스프링 프레임워크와 전혀 다른 것으로 오해하지만 스프링부트는 스프링프레임워크라는 큰 틀 속에 속하는 도구일 뿐이다. 

<p align="center">
    <img src="../../images/1_spring-boot/1_intro/spring-boot-logo.png" height="300px">
</p>




> Spring Boot를 사용하면 "그냥 실행할 수 있는" 독립 실행형  *production-grade* Spring 기반 애플리케이션을 쉽게 생성할 수 있다.
>
> 우리는 당신이 최소한의 고민으로 시작할 수 있도록 Spring 플랫폼과 *third-party libraries*에 대한 견해를 가지고 있다. 대부분의 Spring Boot 애플리케이션은 최소한의 Spring 구성으로 동작시킬 수 있다.
>
> [^production-grade]: 집중적인 비즈니스 및 기업 컴퓨팅 환경을 위해 설계된 보다 강력하고 견고한 하드웨어 및 소프트웨어를 설명하는 데 사용되는 문구(Production 수준으로 해석할 수 있다.)
> [^third-party libraries]: 프로그래밍을 도와주는 plug_in 이나 library 등을 만드는 회사의 라이브러리들
>
> 출처 : [스프링 공식 홈](https://spring.io/projects/spring-boot)



## 1-2. 스프링 부트 역사

- 2012년 10월 Mike Youngstrom는 Spring 프레임워크에서 컨테이너 없는 웹 애플리케이션 아키텍처에 대한 지원을 요청하는 기능 요청했다. main 메소드에서 부트스트랩된 스프링 컨테이너 내에서 웹 컨테이너 서비스를 구성하는 것에 대해 말했는데 다음은 '이슈' 기반의 프로젝트 관리 도구 jira 요청에서 발췌한 내용이다.

> Spring 컴포넌트와 설정 모델을 위에서 아래로 활용하는 도구와 참조 아키텍처를 제공한다면 Spring의 웹 애플리케이션 아키텍처는 상당히 단순화될 수 있다고 생각한다. 간단한 main() 메소드에서 부트스트랩된 Spring Container 내에 이러한 공통 웹 컨테이너 서비스의 구성을 포함하고 통합한다.

- Mike Youngstrom의 요청으로 인해 2013년 초에 시작되는 스프링 부트 프로젝트 개발이 시작되었고 2014년 4월에 스프링 부트 1.0.0이 릴리즈 되었다. 그 이후로 많은 스프링 부트 마이너 버전이 나왔다.
  [스프링부트 버전별 차이(Spring Boot Release Notes)](https://github.com/spring-projects/spring-boot/wiki)

 

## 1-3. 스프링 부트의 특징

- 임베디드 톰캣(Embed Tomcat), 제티, 언더토우를 사용하여 독립 실행이 가능한 스프링 애플리케이션 개발
- 통합 스타터를 제공하여 메이븐/그레이들 구성 간소화
- 스타터를 통한 자동화된 스프링 설정 제공
- 번거로운 XML 설정을 요구하지 않음
- JAR 를 사용하여 자바 옵션만으로 배포 가능
- 애플리케이션의 모니터링과 관리를 위한 스프링 액츄에이터(Spring Actuator) 제공



## 1-4. 스프링 부트의 사용 이유

### 1-4-1. 스프링 부트의 장점
- 각각의 의존성 버젼을 쉽게 올리는 것이 가능하다. (수동으로 설정하던 기존의 방식에 비해 안정된 버젼 제공을 보장받을 수 있음)
- 간단한 어노테이션/프로퍼티 설정으로 원하는 기능을 빠르게 적용할 수 있다.
- 별도의 외장 톰캣을 설치할 필요가 없고 톰캣 버젼도 편리하게 관리할 수 있다.
- 특정 라이브러리에 버그가 있더라도 이후에 스프링팀에서 버그를 수정하면 수정된 버젼을 받기에 편리하다.

### 1-4-2. 스프링 부트의 단점

- 설정을 커스터마이징 해야 하는 경우 기존 스프링프레임워크를 사용하는 것과 같은 어려움을 겪을 수 있다.
- 설정을 변경하고 싶은 경우 정확한 동작 원리와 내부 코드를 살펴봐야 하는 불편함이 있다.




## 1-5. 스프링 부트의 핵심 요소

### 1-5-1. 스프링 부트의 핵심 요소의 종류

<table>
    <tr>
    	<th align="center">요소</th>
        <th align="center">기능</th>
    </tr>
    <tr>
    	<td align="center">스타터(Starter)</td>
        <td>스프링의 특정 모듈을 사용할 수 있도록 관련된 라이브러리 의존성을 해결</td>
    </tr>
    <tr>
        <td align="center">자동설정(AutoConfiguration)</td>
        <td>Starter로 추가한 모듈을 사용할 수 있도록 빈 설정을 자동으로 관리
        </td>
    </tr>
    <tr>
        <td align="center">액추에이터(Actuator)</td>
        <td>스프링부트로 개발된 시스템을 모니터링할 수 있는 기능들을 제공</td>
    </tr>
</table>




## 1-6. 스타터(Starter)

### 1-6-1. 스타터란?

- 의존성과 설정을 자동화 해주는 모듈을 뜻하며 필요한 라이브러리들을 관련있는 것들을 묶어서 제공한다.
-  라이브러리간의 의존관계를 파악하고 pom.xml에서 dependency들의 상속관계를 통해 작성되어 필요한 라이브러리를 다운로드 받아준다.

### 1-6-2. 스프링 부트 스타터 명명 규칙

- spring-boot-starter-*
- 스프링부트의 기본 스타터 종류

<table>
    <tr>
    	<th align="center">스타터명</th>
        <th align="center">설명</th>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter</td>
		<td>스프링 부트의 코어 (auto-configuration, logging, yaml 등을 제공)</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-aop</td>
		<td>AOP(Aspect Oriented Programming)를 위한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-batch</td>
		<td>Spring Batch를 사용하기 위한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-jpa</td>
		<td>Spring Data JPA와 Hibernate를 위한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-data-redis</td>
		<td>Redis와 Jedis 사용에 필요한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-data-rest</td>
		<td>스프링 부트의 코어 (auto-configuration, logging, yaml 등을 제공)</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-thymleaf</td>
		<td>Thymeleaf 템플릿 엔진 사용에 필요한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-jdbc</td>
		<td>JDBC Connection Pool 사용에 필요한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-security</td>
		<td>Sprint Security 사용에 필요한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-oauth2</td>
		<td align="center">OAuth2 인증 사용에 필요한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-validation</td>
		<td>Java Bean Validation 사용에 필요한 스타터</td>
    </tr>
    <tr>
    	<td align="center">spring-boot-starter-web</td>
		<td>웹 개발을 위해 필요한 스타터(Spring MVC, REST, Embed Tomcat, 기타 라이브러리 등)</td>
    </tr>
</table>


### 1-6-3. 스프링부트 스타터 의존성 확인

- 공식 홈페이지에서 확인할 수 있다.

  [스프링부트 스타터 의존성 확인(Starters)](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.build-systems.starters)
