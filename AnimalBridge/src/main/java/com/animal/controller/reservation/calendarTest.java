package com.animal.controller.reservation;

import java.util.Calendar;
import java.util.Scanner;

public class calendarTest {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR) + "년"); // 2019
		System.out.println(cal.get(Calendar.MONTH) + 1 + "월"); // 5 (6월이라는 뜻)
		System.out.println(cal.get(Calendar.DAY_OF_MONTH) + "일"); // 20일
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 5 (일요일1 ~ 목요일5 ~)

		// 이번달 1일이 무슨요일일까?
		cal.set(Calendar.DAY_OF_MONTH, 1); // set 날짜를 1일로 설정함
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 1 cal 날짜가 1로 설정되었다는것 확인
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 7토요일

		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 월의 마지막 날
		System.out.println(lastDay); // 30

		// 2019년 6월 달력을 만들어보자
		System.out.println("==========6월==========");
		cal.set(Calendar.DAY_OF_MONTH, 1);
		for (int j = 0; j < cal.get(Calendar.DAY_OF_WEEK); j++)
			System.out.printf("　　");
		for (int i = 1; i <= lastDay; i++) {
			cal.set(2019, 5, i); // 6월은 5를 입력해야함!!!!
			System.out.printf("%3d", cal.get(Calendar.DAY_OF_MONTH));
			if (cal.get(Calendar.DAY_OF_WEEK) % 7 == 0)
				System.out.println();
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~");
		
		
		bbbb();

	} // end of main

	// main이 static이므로 main에서 접근하려는 메소드도 static이어야한다
	public static void bbbb() {
		// 연도, 월을 입력하면 해당 월의 달력 출력하기!
		Calendar cal = Calendar.getInstance();
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		cal.set(year, month - 1, 1); // 입력받은 년, 월로 날짜 설정
		
		// 달력 출력~~~
		System.out.printf("========%d년 %d월=======\n", year, month);
		System.out.println(" 일  월  화  수  목  금  토");
		for (int j = 1; j < cal.get(Calendar.DAY_OF_WEEK); j++)
			System.out.printf("　 　");
		for(int i = 1; i <= cal.getMaximum(Calendar.DAY_OF_MONTH); i++) {
			cal.set(year, month - 1, i);
			System.out.printf("%3d", cal.get(Calendar.DAY_OF_MONTH));
			if (cal.get(Calendar.DAY_OF_WEEK) % 7 == 0)
				System.out.println();
		}
	} // end of bbb

	public static void aaa() {
		Calendar cal = Calendar.getInstance();
		// 2019년 1월부터 12월까지 달력 만들기
		for (int month = 0; month < 12; month++) { // 1월(0) ~ 12월(11)
			System.out.printf("==========%d월==========\n", month + 1);
			System.out.println(" 일  월  화  수  목  금  토");
			cal.set(2019, month, 1); // cal 날짜를 해달 월 1일로 설정
			int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 월 마지막 날짜 구하기
			for (int j = 1; j < cal.get(Calendar.DAY_OF_WEEK); j++)
				System.out.printf("　 　"); // 첫쨋날 월~토요일이면 그만큼 앞에 공백 넣기
			for (int i = 1; i <= lastday; i++) {
				cal.set(2019, month, i);
				System.out.printf("%3d", cal.get(Calendar.DAY_OF_MONTH));
				if (cal.get(Calendar.DAY_OF_WEEK) % 7 == 0)
					System.out.println(); // 토요일되면 한 줄 띄우기
			} // 달력 출력
			System.out.println();
		}
	} // end of aaa


	
	
	/* 테이블 적용 전 버전
	
	<% 
	
	String result ="";
	
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.DAY_OF_MONTH, 1); // set 첫 날짜를 1일로 설정함
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int week = cal.get(Calendar.DAY_OF_WEEK);
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 월의 마지막 날 
	
	year = 2019;
	month = (12)-1;
	cal.set(year, month, 1); 
	week = cal.get(Calendar.DAY_OF_WEEK);
	lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	for(int i=0; i<week-1; i++){
	    result = result+"X ";
	}
	
	for(int i=1; i<=lastDay; i++){
	    if(i<10){
	        result = result+"0"+i+" ";
	    }else{
	        result = result+i+" ";
	    }
	    cal.set(year, month, i);
	    if(cal.get(Calendar.DAY_OF_WEEK) % 7 == 0){
	        result =  result+ "<br>";
	   }
	}
	
	String ym =  year+"."+(month+1);
	String calen = result;
	

%>

			
			<p><%=ym %></p>
			<p>일  월  화  수  목  금  토</p>
			<p><%=calen %></p>

	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 
	
	<body>
	<p id="yyyymm">년월</p>
    <p>일  월  화  수  목  금  토</p>
    <p id="cal">실제달력</p>
	
	</body>
	
	
	<script>
	script로 DATE를 이용하는 방법     
    var result = "";
    var date = new Date();
    var lastday = new Date(date.getFullYear(), date.getMonth()+1,0).getDate();  
    var week = new Date(date.getFullYear(), date.getMonth(),1).getDay();
    
    for(var i=0; i<week; i++){
        result = result+"XX ";
    }
    
    for(var i=1; i<=lastday; i++){
        if(i<10){
            result = result+"0"+i+" ";
        }else{
            result = result+i+" ";
        }
        if(new Date(date.getFullYear(), date.getMonth(),i).getDay()==6){
            result =  result+ "<br>";
       }
    
    }
         
    document.getElementById("yyyymm").innerHTML = date.getFullYear()+"."+(date.getMonth()+1);
    document.getElementById("cal").innerHTML =result;
     
    </script>
     
     
     */
	
    /* script를 jsp로 옮긴것

    String result ="";
    Date date = new Date(); 
    int lastday = new Date(date.getYear(), date.getMonth()+1,0).getDate();  
    int week = new Date(date.getYear(), date.getMonth(),1).getDay();


    for(int i=0; i<week; i++){
        result = result+"XX ";
    }

    for(int i=1; i<=lastday; i++){
        if(i<10){
            result = result+"0"+i+" ";
        }else{
            result = result+i+" ";
        }
        if(new Date(date.getYear(), date.getMonth(),i).getDay()==6){
            result =  result+ "<br>";
       }

    }

    String ym =  date.getYear()+"."+(date.getMonth()+1);
    String cal = result;


    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int year  = localDate.getYear();
    int month = localDate.getMonthValue();
    int day   = localDate.getDayOfMonth(); 
    */ 
	
}
