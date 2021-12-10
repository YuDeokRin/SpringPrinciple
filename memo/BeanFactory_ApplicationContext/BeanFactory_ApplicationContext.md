# BeanFactory와 ApplicationContext

![Untitled](https://user-images.githubusercontent.com/56623911/145540864-2c40c35c-f27a-4ccb-a446-87e519ea7a28.png)

## BeanFactory

- 스프링 컨테이너의 최상위 인터페이스
- 스프링 빈을 관리하고 조회하는 역할을 담당한다.
- getBean( )을 제공

## ApplicationContext

- BeanFactory 기능을 모두 상속받아서 제공
- 빈을 관리하고 검색하는 기능을 BeanFactory가 제공 그렇다면  둘의 차이는?
- 애플리케이션을 개발할 때는 빈은 관리하고 조회하는 기능은 물론이고, 수 많은 부가기능이 필요하다.

ApplicationContext가 제공하는 부가기능

![Untitled 1](https://user-images.githubusercontent.com/56623911/145540912-9a952af8-bae2-4c16-932c-548ad4bc6c0f.png)



- 메시지소스를 활용한 국제화 기능
    - 예를 들어서 한국에서 들어오면 한국어로, 영어권에서 들어오면 영어로 출력
- 환경변수
    - 로컬, 개발, 운영등을 구분해서 처리
- 애플리케이션 이벤트
    - 이벤트를 발행하고 구독하는 모델을 편리하게 지원
- 편리한 리소스 조회
    - 파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회

BeanFactory 와 ApplicationContext차이

![Untitled 2](https://user-images.githubusercontent.com/56623911/145540926-4bf90c4e-89c7-443d-ae95-df6559101c38.png)

