<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="pb-1">
    <h1 class="text-xl font-bold text-center ">Zero <span class="text-red-600">WIFI</span></h1>

    <div class="w-full text-center mb-5">
        <a class="px-3 py-1 hover:text-cyan-600" href="/">🏠 홈</a>
        <a class="px-3 py-1 hover:text-cyan-600" href="/history">📈 위치 히스토리 목록</a>
        <a class="px-3 py-1 hover:text-cyan-600" href="/wifiRequeest">🤩 Open API 와이파이 정보 가져오기</a>
    </div>

    <div class="flex justify-center align-middle items-center mb-5">
        <c:if test="${headerVisit == 'true'}">
        LAT:<input class="mt-1 mx-2 px-3 py-2 bg-white border shadow-sm border-slate-300 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block rounded-md sm:text-sm focus:ring-1 lat" type="text" />
        LNT:<input class="mt-1 mx-2 px-3 py-2 bg-white border shadow-sm border-slate-300 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block rounded-md sm:text-sm focus:ring-1 lnt" type="text" />

        <input id="myLocation" class="mx-2 px-3 py-2 rounded-lg font-semibold text-sm bg-sky-500 text-white shadow-sm cursor-pointer" type="button" value="내 위치 가져오기" />
        <input id="around" class="mx-2 px-3 py-2 rounded-lg font-semibold text-sm bg-red-500 text-white shadow-sm cursor-pointer" type="button" value="근처 WPI 가져오기" />
        </c:if>
    </div>

</header>