<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="base/top.jsp" />
<jsp:include page="base/header.jsp" />

<main>
    <section>
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
    const lat = document.querySelector(".lat");
    const lnt = document.querySelector(".lnt");
    const tbody = document.querySelector("tbody");

    locationButton.addEventListener("click", () => {
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
        if(!lat.value || !lnt.value) {
            alert("위치 정보를 가져와 주세요");
            return;
        }

        fetch("/around", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                latitude: lat.value,
                longitude: lnt.value
            }),
        }).then(response => response.json())
            .then((response) => {
                let html = '';

                for(let json of response) {

                    html += '<tr class="odd:bg-slate-200">';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.distance+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.mgrNo+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.borough+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.name+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.address1+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.address2+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.floor+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.installType+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.installationAgency+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.serviceClassification+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.typeOfNet+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.yearOfInstallation+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.doorDivision+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.environment+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.latitude+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.longitude+'</td>';
                    html += '<td class="text-center border border-slate-300 py-2">'+json.workDate+'</td>';
                    html += '</tr>';
                }

                tbody.innerHTML = html;
            });
    });

</script>
<jsp:include page="base/footer.jsp" />