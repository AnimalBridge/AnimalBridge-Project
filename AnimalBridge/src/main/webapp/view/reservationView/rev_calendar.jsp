<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
	background-color: white;
	width:100px;
	}
</style>
</head>
<body>
	<% 
	
		String result ="";
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1); // set 첫 날짜를 1일로 설정함
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 월의 마지막 날 
		
/* 		year = 2019;
		month = (11)-1; 
		week = cal.get(Calendar.DAY_OF_WEEK);
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
*/	
		
		
		
		
		
		cal.set(year, month, 1); 
		for(int i=0; i<week-1; i++){
		    result = result+"<td>"+"X"+"</td>";
		}
		
		for(int i=1; i<=lastDay; i++){
		    if(i<10){
		        result = result+"<td>"+"0"+i+"</td>";
		    }else{
		        result = result+"<td>"+i+"</td>";
		    }
		    cal.set(year, month, i);
		    if(cal.get(Calendar.DAY_OF_WEEK) % 7 == 0){
		        result =  result+ "</tr><tr>";
		   }
		}
		
		String ym =  year+"."+(month+1);
		String calen = result;
		
	
	%>
	

<table width ="700" align ="center" border ="1" cellpadding="5" cellspacing="0">
	<tr>
<!-- 이전달 버튼 -->
 		<th>
		<input type="button" value="이전 달" onclick="location.href='?year=<%=year%>&month=<%=month-1%>'">
		</th> 
		
<!-- 제목 만들기 -->
		<th id = "title" colspan = "5">
		<%=year%>년  <%=month%>월
		</th>
		
<!-- 다음달 버튼 -->
 		<th>
		<input type="button" value="다음 달" onclick="location.href='?year=<%=year%>&month=<%=month+1%>'">
		</th> 
	</tr>
	<tr>
		<td class = "sunday">일</td>
		<td class = "etcday">월</td>
		<td class = "etcday">화</td>
		<td class = "etcday">수</td>
		<td class = "etcday">목</td>
		<td class = "etcday">금</td>
		<td class = "saturday">토</td>
	</tr>
	<tr>
 	<c:forEach var="i" begin="0" end="<%=week-2%>" step="1">
​	<td><%-- ${i} --%>X</td>
	</c:forEach> 
	<c:forEach var="i" begin="1" end="<%=lastDay%>" step="1">
		 <c:if test="조건문">
		 </c:if>
	</c:forEach> 
	
	
	
	
<%-- 	 <%=calen %>  --%>
	</tr>
	
</table>

</body>
</html>