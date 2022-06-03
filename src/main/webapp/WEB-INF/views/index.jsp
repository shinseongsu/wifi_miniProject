<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>와이파이 정보 구하기</title>
    </head>

    <body>
        <main>
            <header>
                <h1>와이파이 정보 구하기</h1>
            </header>
            <section>
                <article>
                    <a href="/">홈</a>
                    <a href="/history">위치 히스토리 목록</a>
                    <a href="/wifiRequeest">Open API 와이파이 정보 가져오기</a>
                </article>

                <article>
                    LAT : <input class="lat" type="text" />
                    LNT : <input class="lnt" type="text" />
                    <input id="myLocation" type="button" value="내 위치 가져오기" />
                    <input id="wifiRequest" type="button" value="근처 WPI 가져오기" />
                </article>

                <article>
                    <table>
                        <thead>
                            <tr>
                                <th>거리(km)</th>
                                <th>관리번호</th>
                                <th>자치구</th>
                                <th>와이파이명</th>
                                <th>도로명주소</th>
                                <th>상세주소</th>
                                <th>설치위치(층)</th>
                                <th>설치유형</th>
                                <th>설치기관</th>
                                <th>서비스구분</th>
                                <th>망종류</th>
                                <th>설치년도</th>
                                <th>실내외구분</th>
                                <th>WIFI접속환경</th>
                                <th>x 좌표</th>
                                <th>y 좌표</th>
                                <th>작업일자</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </article>
            </section>
        </main>

        <script type="text/javascript">
            const wifiButton = document.getElementById("wifiRequest");
            const locationButton = document.getElementById("myLocation");

            wifiButton.addEventListener("click", () => {
                location.href = "/wifiRequeest";
            });

            locationButton.addEventListener("click", () => {
                const lat = document.querySelector(".lat");
                const lnt = document.querySelector(".lnt");

                if ("geolocation" in navigator) {
                    navigator.geolocation.getCurrentPosition((position => {
                        lat.value = position.coords.latitude;
                        lnt.value = position.coords.longitude;
                    }));
                } else {
                    lat.setAttribute("disabled", true);
                    lnt.setAttribute("disabled", true);
                }


            })

        </script>

    </body>

</html>