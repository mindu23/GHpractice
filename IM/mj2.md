# [Network] 웹서버와 WAS의 차이점

<br>

- 웹의 동작 원리

![image](https://user-images.githubusercontent.com/60870438/167300519-c1cc5666-726c-4840-8de3-04320aedfafd.png)

```
1/2. 사용자가 웹 브라우저를 통해 찾고 싶은 웹 페이지의 주소 입력

3. 사용자가 입력한 URL 주소 중에서 도메인 네임(domain name) 부분을 DNS 서버에 검색한다.

4. DNS 서버에서 해당 도메인 네임에 해당하는 IP 주소를 찾아 사용자가 입력한 URL 정보와 함께 프로토콜의 정보를 함께 전달한다.

5/6. 웹 페이지 URL 정보와 전달받은 IP 주소는 HTTP 프로토콜을 사용하여 HTTP 요청 메시지를 생성한다.
이렇게 생성된 HTTP 요청 메서드는 TCP 프로토콜을 사용하여 인터넷을 거쳐 해당 IP 주소의 컴퓨터로 전송된다.

7. 도착한 HTTP 요청 메시지는 HTTP 프로토콜을 사용하여 웹 페이지 URL 정보로 변환된다.

8. 웹 서버는 도착한 웹 페이지 URL 정보에 해당하는 데이터를 검색한다.

9/10. 검색된 웹 페이지 데이터는 또 다시 HTTP 프로토콜을 사용하여 HTTP 응답 메시지를 생성한다.
이렇게 생성된 HTTP 응답 메시지는 TCP 프로토콜을 사용하여 인터넷을 거쳐 원래 컴퓨터로 전송된다.

11. 도착한 HTTP 응답 메시지는 HTTP 프로토콜을 사용하여 웹 페이지 데이터로 변환된다.

12. 변환된 웹 페이지 데이터는 웹 브라우저에 의해 출력되어 사용자가 볼 수 있게 된다.
```

- 웹 서버와 웹 어플리케이션 서버의 차이

![image](https://user-images.githubusercontent.com/60870438/167389280-1047bba0-2484-42f9-93e7-98410ea3480c.png)

클라이언트가 서버에 요청을 보내면 서버는 해당 요청에 대해 응답한다.

### WebServer
- HTTP 프로토콜을 기반으로 웹 브라우저의 요청을 서비스하는 기능
- 정적인 컨텐츠(.html, .png, .jpg, .css)를 제공할 때에는 WAS를 거치지 않고 바로 제공
- 동적인 컨텐츠(Apache Server, Nginx, IIS) 요청이 들어왔을 때 WAS에 보내고 처리한 결과는 WAS가 전달
```
1. 구분
  - 하드웨어: Web 서버가 설치된 컴퓨터
  - 소프트웨어: 웹 브라우저 클라이언트로부터 HTTP 요청을 받아 정적인 컨텐츠를 제공하는 프로그램
  
2. 기능/역할
  1)
    - 정적 컨텐츠 제공
    - WAS 거치지 않고 바로 자원 제공
  2) 
    - 동적 컨텐츠 제공을 위한 요청 전달 -> WAS
    - 클라이언트의 요청(request)를 WAS에 보내고, WAS가 처리한 결과를 클라이언트에게 전달(response)
    
3. 종류
  Apache Server, Nginx, IIS(Windows 전용 webserver)
  
4. 단점
  - JSP나 PHP같은 응용 프로그래밍 언어를 해석할 수 없음.
  - 그래서 Java 기반 서버 사이드 언어를 처리할 수 있는 엔진 개발 -> 그것이 WAS인 Tomcat 탄색
```
<br>

### WAS(Web Application Server)

![image](https://user-images.githubusercontent.com/60870438/167397821-69da9ad0-8c2e-4d71-aba6-9e92fc1c3938.png)

- DB 조회나 다양한 로직 처리를 요구하는 동적인 컨텐츠를 HTTP 통신을 통해 제공하는 기능
- HTTP를 통해 컴퓨터나 장치에 애플리케이션을 수행해주는 미들웨어(소프트웨어 엔진)
- 웹 컨테이너(Web Container) 혹은 서블릿 컨테이너(Servlet Container) 라고도 불리며 JSP, Servlet 구동 환경을 제공하는 서버 *컨테이너란 JSP, Servlet을 실행시킬 수 있는 소프트웨어*
  즉, WAS는 JSP, Serlvet 구동 환경을 제공한다.
- 분산 트랜잭션, 보안, 메시징, 스레드 처리 등의 기능을 처리하는 분산 환경에서 사용된다.
```
1. 동작 프로세스
  1) Web Server의 클라이언트의 요청에 맞는 Servlet을 메모리에 올린다.
  
  2) web.xml을 참조해 해당 Servlet에 대한 Thread를 생성한다.
  
  3) HttpServletRequest와 HttpServletResponse 객체를 생성하고 그에 맞는 doGet 또는 doPost 메소드를 호출, 생성된 동적 페이지를 Response 객체에 담아 WAS에 전달한다.
  
  4) WAS는 HttpResponse 형태로 바꾸어 WebServer에 전달하고 생성된 스레드와 HttpServletRequest, HttpServletResponse 객체를 제거한다,
  
2. 기능/역할
  - WAS = Web Server + Web Container
  - Web Server의 기능을 구조적으로 분리하여 처리하는 목적 -> 분산 환경
  - 주로 DB 서버와 같이 사용
  
3. 종류
  - Tomcat, JBoss, Jeus, Web Sphere
```

#### Tomcat
- 동적인 데이터를 처리, DB와 연결되어 데이터를 주고 받거나 프로그램으로 데이터 조작이 필요한 경우에 사용.
- Apache Tomcat은 JSP 페이지의 실행 환경을 제공하는 WAS

![image](https://user-images.githubusercontent.com/60870438/167398442-e2e4111e-ba86-4a97-a3eb-89716f1c5d72.png)

```
- 톰캣==WAS, 자바 코드를 이용해 HTML 페이지를 동적으로 생성해주는 프로그램

- WAS는 웹서버와 웹 컨테이너의 결합으로 다양한 역할을 수행하는 서버

- 요청을 내부의 프로그램을 통해 결과를 만들고 다시 클라이언트에 전달해주는 것이 웹 컨테이너

- 아파치와 톰캣은 컨테이너 기능이 가능하냐 하지 않느냐의 차이

- 톰캣 6버전 이상은 웹 서버의 기능이 추가되어 어느정도 웹서버 역할 가능

- 보통 JSP를 사용하는 웹 프로그래머는 아파치 + 톰캣을 병행. 현재는 정적 데이터의 경우 아파치의 성능이 더 좋다.

- 아파치는 사용이 불가피. JSP와 PHP 개발자가 있을 때 톰캣만 사용하면 PHP 개발자는 할 게 없다. 
하지만 아파치 + 톰캣을 사용한다면 php를 설치하고 아파치에 연결하면 여러 서버 사이드 언어로 작성이 가능하다.

```

```
EX) 레스토랑
조리실 안으로 들어오는 주문을 확인하고 역할을 분배하는 메인 셰프는 WebServer. 그 아래에 실제 요리를 담당하는 요리사는 WAS.

WAS는 WebServer의 일을 돕는 조력자.

클라이언트 -> 서버(요청된 페이지의 로직 혹은 DB 연동을 위해 WAS에 처리 요청) -> WAS(요청을 받아 동적 페이지 처리를 담당하고 DB에서 데이터를 받아 처리후 생성된 파일을 서버에 반환) 
```

### 정적 페이지 & 동적 페이지

![image](https://user-images.githubusercontent.com/60870438/167396427-e4fddbf4-80af-472d-9968-b9c3d913943b.png)

```
# 정적 페이지 (Static Page)

- 웹서버는 파일 경로 이름을 받아 경로와 일치하는 file contents를 반환

- 항상 동일한 페이지를 반환

- ex) image, html, css, js 파일과 같이 컴퓨터에 저장된 파일
```
<br>

![image](https://user-images.githubusercontent.com/60870438/167396784-c5c1503f-3340-435d-a049-168306e99498.png)

```
# 동적 페이지 (Dynamic Page)

- 요청된 값에 맞게 동적인 contents를 반환

- 즉, 웹 서버에 의해서 실행되는 프로그램을 통해 만들어진 결과. Servlet: WAS 위에서 돌아가는 Java Program

- 개발자는 Servlet에 doGet() 구현
```

# [Network] 웹서버와 WAS를 구분하는 이유

#### Web Server가 필요한 이유
```
클라이언트가 이미지(정적 컨텐츠)를 보는 과정은 모든 정적 파일들이 웹문서(HTML 문서)가 클라이언트에게 보내질 때 함께 가는 것이 아니라,

클라이언트는 HTML 문서를 먼저 받고 그에 필요한 이미지(정적) 파일을 다시 서버에 요청해 그때 이미지 파일을 받아온다.

Web Server가 있으면 WAS까지 가지 않고 빠르게 보내줄 수 있다.

정적 컨텐츠만을 처리하도록 기능을 분배해 서버의 부담을 줄일 수 있다.
```

#### WAS가 필요한 이유
```
웹 페이지는 정적, 동적 컨텐츠가 모두 존재한다. 사용자의 요청에 맞게 적정하게 만들어 제공해야 한다.

이때, Web Server 만을 이용한다면 사용자가 원하는 요청에 대한 결과값을 모두 미리 만들어 놓고 서비스해야 한다. 하지만 이것은 불가능

따라서 WAS를 통해 요청에 맞는 데이터를 DB에서 가져와 비즈니스 로직에 맞게 그때 그때 결과를 만들어 제공해야 자원을 효율적으로 사용할 수 있다.
```

#### WAS가 Web Server의 기능을 모두 수행하지 않는 이유
```
  1) 기능 분리를 통한 서버 부하 방지
  
    - WAS는 DB 조회나 다양한 로직을 처리한다. 단순 정적 컨텐츠는 web server에서 빠르게 제공하는 것이 좋다.
    
    - WAS는 기본적으로 동적 컨텐츠를 제공하기 위해 존재하는 서버. 만약 정적 컨텐츠까지 맡게 된다면 부하가 커지고 동적 컨텐츠의 처리가 지연되어 수행 속도가 느려진다.
    
  2) 물리적으로 분리하여 보안 강화
  
    - SSL에 대한 암복호화 처리에 Web Server를 이용
  
  3) 여러대의 WAS 연결 가능
    
    - Load Balancing을 위해 Web Server 사용
    
    - fail over(장애 극복), fail back 처리에 유리
    
    - 특히 대용량 웹 어플리케이션의 경우(여러 서버 사용) Web Server와 WAS를 분리해 무중단 운영을 위한 장애 극복에 쉽게 대응한다.
      - ex) 앞 단의 Web Server에서 오류가 발생한 WAS를 이용하지 못하도록 한 후, WAS를 재시작 함으로써 사용자는 오류를 느끼지 못한다.
      
   4) 여러 웹 어플리케이션 서비스 가능
    
    - 하나의 서버에서 PHP app과 Java app을 함께 사용할 수 있다.
```
🎈 즉, 자원 이용의 효율성 및 장애 극복, 배포 및 유지보수의 편의성을 위해 Web Server와 WAS를 분리한다.
🎈 Web Server를 WAS 앞에 두고 필요한 WAS를 플러그인 형태로 설정하면 더욱 효율적인 분산 처리가 가능하다.

#### 왜 Web Server가 WAS보다 앞에 설치할까?

![image](https://user-images.githubusercontent.com/60870438/167402445-d2652cb8-4469-4fac-9492-86800058175c.png)

```
- WAS 자체로 Web Server의 역할을 수행하기 때문에 무조건적인 것은 아니다.
- 그러나 일반적으로 WAS의 부담을 줄이기 위해 Web Server에서는 정적인 문서만, 동적 문서는 WAS에게 애플리케이션의 로직만 수행하도록 기능을 분배해 서버의 부담을 줄이기 위한다.
- Web Server에 플러그인 형태로 WAS를 연결해 일 처리를 나눈다.
- 또한 WAS의 환경설정 파일을 외부에 노출시키지 않게 하기 위한다.
  - 클라이언트와 연결하는 포트가 직접 WAS에 연결이 된다면 중요한 설정 파일이 노출될 수 있기 때문에 WAS 설정 파일을 외부에 노출하지 않기 위해 Web Server를 앞단에 배치
  - 웹 서버와 WAS에 접근하는 포트가 다르기 때문에 WAS에 들어오는 포트에 방화벽을 쳐서 보안 강화
```
<br>
[참고] <br>
[[AWS] 웹의 구동 원리, Web server& Web Application Server 차이](https://velog.io/@shinyejin0212/AWS-%EC%9B%B9%EC%9D%98-%EA%B5%AC%EB%8F%99-%EC%9B%90%EB%A6%AC)
[[AWS] Web Server(웹서버, 아파치) 와 WAS(톰캣) 이해하기](https://mi-nya.tistory.com/237)
[Web Server 와 WAS 를 구분하는 이유](https://mi-nya.tistory.com/239?category=823761)
