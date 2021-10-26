# SpringPrinciple

# Spring 핵심 원리

# Spring

![Untitled](Spring%20%E1%84%92%E1%85%A2%E1%86%A8%E1%84%89%E1%85%B5%E1%86%B7%20%E1%84%8B%E1%85%AF%E1%86%AB%E1%84%85%E1%85%B5%20cd369210ea40477ab5312f9f6b356b0a/Untitled.png)

## Spring framwork

- 핵심 기술 : 스프링 DI 컨테이너, AOP, 이벤트, 기타
- 웹 기술 : 스프링 MVC, 스프링 WebFlux
- 데이터 접근 기술 : 트랜잭션, JDBC, ORM지원, XML지원
- 기술 통합 : 캐시, 이메일, 원격 접근, 스케줄링
- 테스트 : 스프링 기반 테스트 지원
- 언어 : 코틀린 , 그루비
- 최근에는 스프링 부트를 통해서 스프링 프레임워크의 기술들을 편리하게 사용

## Spring boot

- **스프링을 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용**
- 단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성
- Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨
- 손쉬운 빌드 구성을 위한 starter 종속성 제공
- 스프링과 3rd parth(외부) 라이브러리 자동 구성
- 메트릭, 상태 확인, 외부 궁성 같은 프로덕션 준비 기능 제공
- 관례에 의한 간결한 설정

## 보통 말하는 Spring 단어의 뜻

- 스프링이라는 단어는 문맥에 따라 다르게 사용된다.
    - 스프링 DI 컨테이너 기술
    - 스프링 프레임워크
    - 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계

## Spring의 진짜 핵심

- 스프링은 자바 언어 기반의 프레임워크
- 자바 언어의 가장 큰 특징 - **객체 지향 언어**
- 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크'
- 스프링은 **좋은 객체 지향** 애플리케이션을 개발할 수 있게 도와주는 프레임워크

- **Tip. 객체 지향 특징**
    - 추상화
    - 캡슐화
    - 상속
    - **다형성**
    

## 다형성

![Untitled](Spring%20%E1%84%92%E1%85%A2%E1%86%A8%E1%84%89%E1%85%B5%E1%86%B7%20%E1%84%8B%E1%85%AF%E1%86%AB%E1%84%85%E1%85%B5%20cd369210ea40477ab5312f9f6b356b0a/Untitled%201.png)

![Untitled](Spring%20%E1%84%92%E1%85%A2%E1%86%A8%E1%84%89%E1%85%B5%E1%86%B7%20%E1%84%8B%E1%85%AF%E1%86%AB%E1%84%85%E1%85%B5%20cd369210ea40477ab5312f9f6b356b0a/Untitled%202.png)

## 역할과 구현을 분리

- 역할과 구현으로 구분하면 세사이 단순해지고, 유연해지며 변경도 편리해진다.
- 장점
    - **클라이언트**는 대상의 역할(인터페이스)만 알면 된다.
    - **클라이언트**는 구현 대상의 **내부 구로를 몰라도** 된다.
    - **클라이언트**는 구현 대상의 **내부 구조가 변경**되어도 영향을 받지 않는다.
    - **클라이언트**는 구현 **대상 자체를 변경**해도 영향을 받지 않는다.

### 자바언어

- 자바 언어의 다형성을 활용
    - 역할 = 인터페이스
    - 구현 인터페이스를 구현한 클래스, 구현 객체
- 객체를 설계할 때 **역할**과 **구현**을 명확히 분리
- 객체 설계시 역할(인터페이스)을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기

## 객체의 협력이라는 관계부터 생각

- 혼자 있는 객체는 없다.
- 클라이언트 : **요청**, 서버: **응답**
- 수 많은 객체 클라이언트 와 객체 서버는 서로 협력 관계를  가진다.

### 자바 언어의 다형성

- **오버라이딩**을 떠올리자
- 오버라이딩은 자바 기본 문법
- 오버라이딩 된 메서드가 실행
- 다형성으로 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.
- 물론 클래스 상속 관계도 다형성, 오버라이딩 적용가능

![Untitled](Spring%20%E1%84%92%E1%85%A2%E1%86%A8%E1%84%89%E1%85%B5%E1%86%B7%20%E1%84%8B%E1%85%AF%E1%86%AB%E1%84%85%E1%85%B5%20cd369210ea40477ab5312f9f6b356b0a/Untitled%203.png)

### 다형성의 본질

- 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.
- 다형성의 본질을 이해하려면 **협력**이라는 객체사이의 관계에서 시작해야함
- **클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.**

### 역할과 구현을 분리 ※정리

- 실세계의 역할과 구현이라는 편리한 컨셉을 다형성을 통해 객체 세상으로 가져올 수 있음
- 유여한고, 변경이 용이
- 확장 가능한 설계
- 클라이언트에 영향을 주지 않는 변경 가능
- 인테페이스를 안정적으로 잘 설계하는 것이 중요

## 역할과 구현을 분리 ※한계

- 역할(인터페이스) 자체가 변하면, 클라이언트, 서버 모두에 큰 변경이 발생한다.
- 자동차를 비행기로 변경해야 한다면?
- 대본 자체가 변경된다면?
- USB 인터페이스가 변경된다면?
- 인터페이스를 안정적으로 잘 설계하는 것이 중요

### 스프링과 객체 지향

- 다형성이 가장 중요하다.
- 스프링은 다향성을 극대화해서 이용할 수 있게 도와준다.
- 스프링에서 이야기하는 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다.
- 스프링을 사용하면 마치 레고 블럭 조립하듯이 ! 공연 무대의 배우를 선택하듯이! 구현을 편리하게 변경할 수 있다.
