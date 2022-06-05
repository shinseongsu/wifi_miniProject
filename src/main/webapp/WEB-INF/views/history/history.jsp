<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../base/top.jsp" />
<jsp:include page="../base/header.jsp" />

<main>
    <section>
        <article>
            <table class="w-full border border-collapse border-slate-400">
                <thead>
                <tr>
                    <th class="border border-slate-300 text-white bg-green-700">ID</th>
                    <th class="border border-slate-300 text-white bg-green-700">X 좌표</th>
                    <th class="border border-slate-300 text-white bg-green-700">Y 좌표</th>
                    <th class="border border-slate-300 text-white bg-green-700">조회일자</th>
                    <th class="border border-slate-300 text-white bg-green-700">비교</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="history" items="${historyList}">
                    <tr class="odd:bg-slate-200">
                        <td class="text-center border border-slate-300 py-2">${history.id}</td>
                        <td class="text-center border border-slate-300 py-2">${history.latitude}</td>
                        <td class="text-center border border-slate-300 py-2">${history.longitude}</td>
                        <td class="text-center border border-slate-300 py-2">${history.searchDate}</td>
                        <td class="text-center border border-slate-300 py-2">
                            <input id="removeButton" data-id="${history.id}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 border border-blue-700 rounded" type="button" value="삭제" />
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </article>
    </section>
</main>

<script type="text/javascript">
    const history_buttons = document.querySelectorAll("#removeButton");

    history_buttons.forEach(history_button => {
        history_button.addEventListener("click",() => {
            const historyId = history_button.getAttribute("data-id");

            fetch("/history", {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    id: historyId
                }),
            }).then(response => response.json())
                .then(response => {
                    if(response.code == '0000') {
                        alert('삭제 성공하였습니다.');
                        history_button.parentNode.parentNode.remove();
                    } else {
                        alert('삭제 실패하였습니다.');
                    }
                });
        });
    });
</script>
<jsp:include page="../base/footer.jsp" />