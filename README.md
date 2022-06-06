# 프로젝트 설명

- 공공데이터를 이용한 서울시 Wifi 위치 데이터 가져오기

- 사용 라이브러리

<div>
    <img src="https://img.shields.io/badge/java-007396?style=flat-square&logo=java&logoColor=white"/>
    <img src="https://img.shields.io/badge/hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white"/>
    <img src="https://img.shields.io/badge/OpenAPI Initiative-6BA539?style=flat-square&logo=OpenAPI Initiative&logoColor=white"/>
    <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/>
    <img src="https://img.shields.io/badge/SQLite-003B57?style=flat-square&logo=SQLite&logoColor=white"/>
    <img src="https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=JUnit5&logoColor=white"/>
    <img src="https://img.shields.io/badge/Naver-03C75A?style=flat-square&logo=Naver&logoColor=white"/>
</div>

## 메인화면

![main](./resource/main.png)


## 기능

### open API 가져오기

공공데이터를 DB에 저장합니다.
하이버네이트가 작동하는 output 화면 입니다.

![save](./resource/save.png)

![result](./resource/openApiResult.png)


### 주변 와이파이 조회

가장 가까운 거리의 20개 와이파이를 조회 합니다.

![Around](./resource/around.png)

### history 목록

주변 와이파이 조회 했던 히스토리를 불러옵니다.
물론 삭제기능 까지 추가 하였습니다.

![history](./resource/history.png)


### map으로 주변 목록 보기

네이버 맵을 이용하여 주변의 와이파이를 검색합니다.

![map](./resource/map.png)


## ERD 

![ERD](./resource/ERD.png)



# 문제 해결

- tomcat 돌아가지 않는 문제

![tomcatError](./resource/tomcat_error.png)

```shell
chmod a+x /{tomcat 위치}/bin/catalina.sh
```

권한을 부여해줘야 제대로 작동합니다.


- mac에서는 위치 권한을 부여해줘야 한다.

![크롬](./resource/chrome.png)
![환경설정](./resource/security.png)


- sqlite 위치 조정

```resources/META-INF/persistence.xml```에서 
```<property name="javax.persistence.jdbc.url" value="jdbc:sqlite:/Users/mac/Desktop/TIL/제로베이스/miniProject/wifi.db" />``` 위치를 사용자 위치로 수정해서 사용해주세요 
