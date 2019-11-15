<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    buffer="8kb"
    autoFlush="true"
    errorPage="errorView/jspErrorHandler.jsp"
    
    info="Title화면 입니다(web.xml - welcome file)"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Dancing+Script|Pacifico|Satisfy&display=swap" rel="stylesheet"> 
    <title>AnimalBridge</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            user-select: none;
        }
        body{
            width: 100%;
            height: 100%;
            background-image: url(mainView/black.jpg);
            background-repeat: no-repeat;
            background-size: cover;
        }
        #wrap1{
            width:100%;
            height: 100%;
            position: absolute;
            top:0;
            left:0;
            overflow: hidden;
        }   
        #toplogo{
        	width:400px;
        	height:300px;
        	margin: 0px auto;
        	font-size: 70px;
        	line-height:300px;
        	text-align: center;
        	position: relative;
        	z-index:2;    	
            font-family: 'Satisfy', cursive; 
            font-weight: bold;
            color: #ffffff;
            text-shadow: 2px 2px 0.1px dimgray;
        }
        
        #sideBar {
            background-color: rgba(0, 0, 0, 0.3);
            width:250px;
            height: 100%;
            position: absolute;
            font-family: 'Jua', sans-serif;
            font-size: 30px;
            top: 0;
            left: -250px;
        }
        #sideBar ul {
            list-style: none;
            color: white;
        }
        #sideBar ul li {
            margin: 10px;
            padding: 10px;
        }
        #sideBar ul li:hover {
            color: wheat;
            background-color: rgba(0, 0, 0, 0.5);
            cursor: pointer;
        }
        #container{
            text-align: center;
            margin-top: 50px;
            font-size: 30px;
            font-family: 'Jua', sans-serif; 
            line-height: 10px;
        }

        #wrap2{
            width:100%;
            height: 50%;
            position: absolute;
            bottom:0;
            display: flex;
            justify-content: space-around;
            overflow: visible;
        }
    
        .person{
            width:400px;
            height: 750px;
            display: block;
            cursor: pointer;
        }
        .parson_menuO {
        	height:150px;
        	line-height: 100px;
            text-align: center;
            color: white;
            font-size: 50px;
            opacity: 1;
            letter-spacing: 4px;
            text-shadow: 3px 3px 0.1px dimgray;
        }
        .person_menuI {
        	height:200px;
        	line-height: 200px;
        	background-color: rgb(230, 60, 63);
        	text-align: center;
            color: white;
            font-size: 70px;
            border-radius: 0 0  50px 50px;
        }
        .person_img img{
        	width : 400px;
        	height: 400px;
        }
       
        #person1{
            position: absolute;
            bottom: -350px;
            left: 6%;
        }
        #person2{
            position: absolute;
            bottom: -350px;
            left: 29%;
        }
        #person3{
            position: absolute;
            bottom: -350px;
            left: 52%;
        }
        #person4{
            position: absolute;
            bottom: -350px;
            left: 75%;
        }

         #side_menu {
            background-color: rgba(0, 0, 0, 0.3);
            width: 75px;
            height: 175px;
            position: absolute;
            color: white;
            left: 250px;
            top: 75px;
            display: inline-block;
            cursor: pointer;
        }
        #side_menu p {
            text-align: center;
            font-size: 50px;
            margin: -20px;
        }

    </style>
</head>
<body>
<div id="wrap1">
    <div id="sideBar">
        <i class="fas fa-paw" style="font-size: 60px; color: white; position: absolute;top: 0px; left: 250px; background-color: rgba(0, 0, 0, 0.3); width: 75px; height: 75px; padding: 10px; cursor: pointer"></i>
        <div id="side_menu">
            <p style="margin-top: -10px;">M</p>
            <p>E</p>
            <p>N</p>
            <p>U</p>
        </div>
        <ul>
        	<c:choose>
        		<c:when test="${empty memberLogIn}">
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogIn.jsp'">로그인</li>
        			<li onclick="location.href='memberView/memberJoin.jsp'">회원가입</li>
        		</c:when>
        		
        		<c:otherwise>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberJoin.jsp'">마이페이지</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogOut.do'">로그아웃</li>
        			<li onclick="location.href='memberView/memberLeave.jsp'">탈퇴</li>
        		</c:otherwise>
        	</c:choose>
            
            <li>사이트 소개</li>
        </ul>
    </div>
    <div id="toplogo">Animal Bridge
    </div>
    <div id="container">
        <div id="wrap2">
            <div class="person" id="person1">
                    <div class="parson_menuO">저 행복해요</div>
                    <div class="person_img"><img src="mainView/showIcon.png"></div>
                    <div class="person_menuI">저 행복해요</div>
            </div>
            <div class="person" id="person2">
                     <div class="parson_menuO">입양예약</div>
                     <div class="person_img"><img src="mainView/reservationIcon.png"></div>
                     <div class="person_menuI">입양예약</div>
            </div>
            <div class="person" id="person3">
                    <div class="parson_menuO">자원봉사</div>
                    <div class="person_img"><img src="mainView/volunteerIcon.png"></div>
                    <div class="person_menuI">자원봉사</div>
            </div>
            <div class="person" id="person4">
                    <div class="parson_menuO">유기동물신고</div>
                    <div class="person_img"><img src="mainView/mapIcon.png"></div>
                    <div class="person_menuI">유기동물신고</div>
            </div>
        </div>
    </div>
  </div>  
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js">
    </script>
    <script>
        
            $(function() {
                
                $("#person1").mouseenter(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "0"
                        
                    }, 500);
                    $("#person1 .parson_menuO").stop().animate({

                        opacity: "0"

                    }, 500);

                });
                
                $("#person1").mouseleave(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "-350px"
                        
                    }, 500);
           
                    $("#person1 .parson_menuO").stop().animate({

                        opacity: "1"

                    }, 500);

                });
                
                $("#person2").mouseenter(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "0"
                        
                    }, 500);
                    
                    $("#person2 .parson_menuO").stop().animate({

                        opacity: "0"

                    }, 500);

                });
                
                $("#person2").mouseleave(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "-350px"
                        
                    }, 500);
                    

                    $("#person2 .parson_menuO").stop().animate({

                        opacity: "1"

                    }, 500);

                });
                
                $("#person3").mouseenter(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "0"
                        
                    }, 500);
                
                    $("#person3 .parson_menuO").stop().animate({

                        opacity: "0"

                    }, 500);

                });
                
                $("#person3").mouseleave(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "-350px"
                        
                    }, 500);
                
                    $("#person3 .parson_menuO").stop().animate({

                        opacity: "1"

                    }, 500);

                });
                
                $("#person4").mouseenter(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "0"
                        
                    }, 500);
                
                    $("#person4 .parson_menuO").stop().animate({

                        opacity: "0"

                    }, 500);

                });
                
                $("#person4").mouseleave(function() {
                
                    $(this).stop().animate({
                        
                        bottom: "-350px"
                        
                    }, 500);
                

                    $("#person4 .parson_menuO").stop().animate({

                        opacity: "1"

                    }, 500);

                });
                
                $("#sideBar").mouseenter(function() {
               
                    $(this).stop().animate({

                        left: "0px"

                    }, 500);
                
                });
                
                $("#sideBar").mouseleave(function() {
               
                    $(this).stop().animate({

                        left: "-250px"

                    }, 500);
                
                });
                
                
            });
        
    </script>
</body>
</html>