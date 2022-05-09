# [Network] 웹서버와 WAS의 차이점

<br>

- 웹의 동작 원리
![image](https://user-images.githubusercontent.com/60870438/167300519-c1cc5666-726c-4840-8de3-04320aedfafd.png)
```
1, 2. 사용자가 웹 브라우저를 통해 찾고 싶은 웹 페이지의 주소 입력
3. 사용자가 입력한 URL 주소 중에서 도메인 네임(domain name) 부분을 DNS 서버에 검색한다.
4. DNS 서버에서 해당 도메인 네임에 해당하는 IP 주소를 찾아 사용자가 입력한 URL 정보와 함께 프로토콜의 정보를 함께 전달한다
5, 6. 웹 페이지 URL 정보와 전달받은 IP 주소는 HTTP 요청 메시지를 생성한다.
7.
```
