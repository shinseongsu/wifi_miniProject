<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>와이파이 정보 구하기</title>
        <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    </head>

    <body>
        <main>
            <header class="pb-1">
                <h1 class="text-xl font-bold text-center ">Zero <span class="text-red-600">WIFI</span></h1>
            </header>
            <section>
                <article>
                    <div class="w-full text-center mb-5">
                        <a class="px-3 py-1 hover:text-cyan-600" href="/">🏠 홈</a>
                        <a class="px-3 py-1 hover:text-cyan-600" href="/history">📈 위치 히스토리 목록</a>
                        <a class="px-3 py-1 hover:text-cyan-600" href="/wifiRequeest">🤩 Open API 와이파이 정보 가져오기</a>
                    </div>
                </article>

                <article>
                    <div class="flex justify-center align-middle items-center mb-5">
                        LAT:<input class="mt-1 mx-2 px-3 py-2 bg-white border shadow-sm border-slate-300 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block rounded-md sm:text-sm focus:ring-1 lat" type="text" />
                        LNT:<input class="mt-1 mx-2 px-3 py-2 bg-white border shadow-sm border-slate-300 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block rounded-md sm:text-sm focus:ring-1 lnt" type="text" />

                        <input id="myLocation" class="mx-2 px-3 py-2 rounded-lg font-semibold text-sm bg-sky-500 text-white shadow-sm cursor-pointer" type="button" value="내 위치 가져오기" />
                        <input id="around" class="mx-2 px-3 py-2 rounded-lg font-semibold text-sm bg-red-500 text-white shadow-sm cursor-pointer" type="button" value="근처 WPI 가져오기" />
                    </div>
                </article>

                <article>
                    <table class="w-full border border-collapse border-slate-400">
                        <thead>
                        <tr>
                            <th class="border border-slate-300 text-white bg-green-700">거리(km)</th>
                            <th class="border border-slate-300 text-white bg-green-700">관리번호</th>
                            <th class="border border-slate-300 text-white bg-green-700">자치구</th>
                            <th class="border border-slate-300 text-white bg-green-700">와이파이명</th>
                            <th class="border border-slate-300 text-white bg-green-700">도로명주소</th>
                            <th class="border border-slate-300 text-white bg-green-700">상세주소</th>
                            <th class="border border-slate-300 text-white bg-green-700">설치위치(층)</th>
                            <th class="border border-slate-300 text-white bg-green-700">설치유형</th>
                            <th class="border border-slate-300 text-white bg-green-700">설치기관</th>
                            <th class="border border-slate-300 text-white bg-green-700">서비스구분</th>
                            <th class="border border-slate-300 text-white bg-green-700">망종류</th>
                            <th class="border border-slate-300 text-white bg-green-700">설치년도</th>
                            <th class="border border-slate-300 text-white bg-green-700">실내외구분</th>
                            <th class="border border-slate-300 text-white bg-green-700">WIFI접속환경</th>
                            <th class="border border-slate-300 text-white bg-green-700">x 좌표</th>
                            <th class="border border-slate-300 text-white bg-green-700">y 좌표</th>
                            <th class="border border-slate-300 text-white bg-green-700">작업일자</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td colspan="17" class="text-center py-3">위치 정보를 입력한 후에 조회해 주세요.</td>
                            </tr>
                        </tbody>
                    </table>
                </article>
            </section>
        </main>

        <script type="text/javascript">
            const around = document.getElementById("around");
            const locationButton = document.getElementById("myLocation");

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
            });

            around.addEventListener("click", () => {
                fetch("/around", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({
                        title: "Test",
                        body: "I am testing!",
                        userId: 1,
                    }),
                }).then(response => response.json())
                    .then((response) => console.log(response));
            });

        </script>
    </body>
</html>