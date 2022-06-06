<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../base/top.jsp" />
<jsp:include page="../base/header.jsp" />

<main>
    <section>
        <article class="w-full">
            <div id="current" class="hidden">현재 위치</div>
            <div id="map" class="w-full" style="height: 80vh;"></div>
        </article>
    </section>
</main>

<script type="text/javascript">
    var map = null;
    let lat;
    let lng;
    let currentUse = true;
    let markerList = [];
    let infowindowList = [];
    const current = document.getElementById("current");

    current.addEventListener("click", () => {
        if ("geolocation" in navigator) {
          navigator.geolocation.getCurrentPosition(function (position) {
            lat = position.coords.latitude;
            lng = position.coords.longitude;
            const latlng = new naver.maps.LatLng(lat, lng);
            if (currentUse) {
              new naver.maps.Marker({
                map: map,
                position: latlng,
                icon: {
                  content:
                    '<img class="pulse" draggable="false" unselectable="on" src="https://myfirstmap.s3.ap-northeast-2.amazonaws.com/circle.png" />',
                  anchor: new naver.maps.Point(11, 11),
                },
              });
              currentUse = false;
            }
            map.setZoom(14, false);
            map.panTo(latlng);

            aroundApi();
          });
        } else {
          alert("위치정보 사용 불가능");
        }
    });

    const mapInit = () => {
        let options = {
            center: new naver.maps.LatLng(37.3595704, 127.105399),
            zoom: 10,
        }

        map = new naver.maps.Map("map", options);
        current.click();
    }
    mapInit();

    const aroundApi = () => {
        fetch("/around", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                latitude: lat,
                longitude: lng
            }),
        }).then(response => response.json())
            .then(data => {
            
            for (var i in data) {
                var target = data[i];
                var latlng = new naver.maps.LatLng(target.latitude, target.longitude);
                marker = new naver.maps.Marker({
                map: map,
                position: latlng,
                icon: {
                    content: "<div class='marker'></div>",
                    anchor: new naver.maps.Point(12, 12),
                },
                });

                var content  = "<div class='infowindow_wrap'>";
                    content += "<div class='infowindow_title'>"+target.name+"</div>";
                    content += "<div class='infowindow_content'>"+target.distance+"km</div>";
                    content += "</div>";
                var infowindow = new naver.maps.InfoWindow({
                    content: content,
                    backgroundColor: "#00ff0000",
                    borderColor: "#00ff0000",
                    anchorSize: new naver.maps.Size(0, 0),
                });
                markerList.push(marker);
                infowindowList.push(infowindow);
            }

            for (var i = 0, ii = markerList.length; i < ii; i++) {
                naver.maps.Event.addListener(map, "click", ClickMap(i));
                naver.maps.Event.addListener(
                    markerList[i],
                    "click",
                    getClickHandler(i)
                );
            }
        });
    }

    function ClickMap(i) {
        return function () {
          var infowindow = infowindowList[i];
          infowindow.close();
        };
    }
    
    function getClickHandler(i) {
        return function () {
          var marker = markerList[i];
          var infowindow = infowindowList[i];
          if (infowindow.getMap()) {
            infowindow.close();
          } else {
            infowindow.open(map, marker);
          }
        };
    }
</script>

<jsp:include page="../base/footer.jsp" />