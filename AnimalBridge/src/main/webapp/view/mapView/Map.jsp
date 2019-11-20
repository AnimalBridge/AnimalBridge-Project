<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="map.css">
    <title>Animal Bridge Map</title>
</head>

<body>
    <div id="map" style="width:100%; height:350px;"></div>
    <p><em>지도를 클릭해주세요!</em></p>
    <p id="result"></p>
    <form action="SaveMap.do" method="get">
        경도 <input type="text" name="x" id="x" readonly><br>
        위도 <input type="text" name="y" id="y" readonly><br>
        종류 <input type="text" name="title" id="title"><br>
       특징 <input type="text" name="special" id="special"> <br>
        주소 <input type="text" name="address" id="address" readonly><br>
        <input type="submit">
    </form>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=34d8d65e2aab71c5883a60b3c3d28c77&libraries=services,clusterer,drawing"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=34d8d65e2aab71c5883a60b3c3d28c77"></script>
        

    <script>
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
            mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
        
    	 // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new kakao.maps.services.Geocoder();
		
        var json = ${ requestScope.json };
        console.log("받은 json : " + json);
        console.log("받은 title : " + json[0].title);
        console.log("받은 x : " + json[0].x);

        var jsonToPosition = [];

        function positionMaker(arr) {
            var res = [];

            for (var i = 0; i < arr.length; i++) {
                var obj = {};
                obj.title = arr[i].title;
                obj.latlng = new kakao.maps.LatLng(Number(arr[i].y), Number(arr[i].x))
                res.push(obj);
            }
            return res;
            console.log(res);
        }


        var positions = positionMaker(json);
        console.log("positions title : " + positions[0].title);
        console.log("position : " + positions[0].latlng);
        

        // 마커 이미지의 이미지 주소입니다
        var imageSrc = '/AnimalBridge/view/mapView/mark1.png';

        for (var i = 0; i < positions.length; i++) {

            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(64, 69),
                markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption), // 마커 이미지를 생성합니다    
                imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
                title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                image: markerImage // 마커 이미지 
            });
        }
		
        // Click Marker
        var imageSrc2 = '/AnimalBridge/view/mapView/mark2.png';
        var imageSize2 = new kakao.maps.Size(64, 69),
            markerImage2 = new kakao.maps.MarkerImage(imageSrc2, imageSize2); // 마커 이미지를 생성합니다    

        var marker2 = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            image: markerImage2 // 마커 이미지 
        }), infowindow = new kakao.maps.InfoWindow({zindex:1});;
        //지도에 클릭 이벤트를 등록합니다
        
        //지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
        kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        	
        	searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
                if (status === kakao.maps.services.Status.OK) {
                    var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
                    detailAddr += '<div id="addressInfo">' + result[0].address.address_name + '</div>';
                    
                    var content = '<div class="bAddr">' +
                                    '<span class="title"> 주소정보</span>' + 
                                    detailAddr + 
                                '</div>';
					           
                     // 클릭한 위도, 경도 정보를 가져옵니다 
                     var latlng = mouseEvent.latLng;
                    // 마커를 클릭한 위치에 표시합니다 
                    marker2.setPosition(mouseEvent.latLng);
                    
                 // 마커 위치를 클릭한 위치로 옮깁니다
                    marker2.setPosition(latlng);
                    
                    // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                    infowindow.setContent(content);
                    infowindow.open(map, marker2);


                    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
                    message += '경도는 ' + latlng.getLng() + ' 입니다';

                    var x = document.getElementById("x");
                    x.value = latlng.getLng();
                    var y = document.getElementById("y");
                    y.value = latlng.getLat();
                    var resultDiv = document.getElementById('result');
                    resultDiv.innerHTML = message;
                    var address = document.getElementById("address");
                    var addressInfo = document.getElementById("addressInfo");
                    address.value = addressInfo.innerHTML;
                }   
            });
        });
        
        
        function searchAddrFromCoords(coords, callback) {
            // 좌표로 행정동 주소 정보를 요청합니다
            geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
        }

        function searchDetailAddrFromCoords(coords, callback) {
            // 좌표로 법정동 상세 주소 정보를 요청합니다
            geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
        }

    </script>
</body>

</html>