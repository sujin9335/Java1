package com.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateController {

	public static void main(String[] args) {
		//날짜를 처리하는 클래스
		//java.util.Date클래스 -> 일반자바에서 사용
		//java.sql.Data클래스 -> DB와 연결해서 사용 날짜타입
		//calendar, GregodianCalendar클래스 이용
		//8버전이상 java
		//LocalDate, LoacalTime, LocalDateTime클래스 이용
		//현재날짜 출력하기
		
		Date today=new Date();
		System.out.println(today);
		today=new Date(2022,12,10);
		today=new Date(7123123441465L);
		System.out.println(today);
		
		//Calendar클래스 이용하기
		//Calendar클래스는 추상클래스로 자체생성이 불가능함
		//Calendar클래스를 이용하려면 calendar클래스를 생성해주는 메소드를 이용
		//Calendar.getInstance()메소드를 이용
		Calendar c=Calendar.getInstance(); //현재날짜 값을 가져옴
		System.out.println(c);
		//날짜를 출력할때는 Calendar의 값에 접근해서 출력
		//get()메소드 이용
		//get(Calendar가 제공하는 field를 불러와 출력)
		System.out.println("년 : "+c.get(Calendar.YEAR));
		//월 표시는 0부터 시작함 월을 불러왔을때 +1을 해줘야함
		//1월 -> 0
		//2월 -> 1
		System.out.println("월 : "+(c.get(Calendar.MONTH)+1));
		System.out.println("일 : "+c.get(Calendar.DATE));
		System.out.println("시 : "+c.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : "+c.get(Calendar.MINUTE));
		System.out.println("초 : "+c.get(Calendar.SECOND));
		
		//Calendar에 원하는 날짜 저정하기
		//set(필드값, 설정값);
		Calendar birthDay=Calendar.getInstance();
		birthDay.set(Calendar.YEAR,1992);
		birthDay.set(Calendar.MONTH,3-1);
		birthDay.set(Calendar.DATE,2);
		int year=birthDay.get(Calendar.YEAR);
		int month=birthDay.get(Calendar.MONTH)+1;
		int date=birthDay.get(Calendar.DATE);
		System.out.println("수진씨의 탄신일 : "+year+"년 "+month+"월 "+date+"일");
		
		//GregorianCalendar이용하기
		GregorianCalendar gc=new GregorianCalendar();
		System.out.println(gc);
		//get메소드를 이용해서 날짜를 출력
		year=gc.get(Calendar.YEAR);
		month=gc.get(Calendar.MONTH)+1;
		System.out.println(year+"년"+month+"월");
		gc.set(Calendar.YEAR, 2002);
		gc.set(Calendar.MONTH, 8-1);
		year=gc.get(Calendar.YEAR);
		month=gc.get(Calendar.MONTH)+1;
		System.out.println(year+"년"+month+"월");
		
		//생성과 동시에 날짜를 설정할 수 있음
		gc=new GregorianCalendar(1998,2-1,26);
		year=gc.get(Calendar.YEAR);
		month=gc.get(Calendar.MONTH)+1;
		System.out.println(year+"년"+month+"월");
		
		//날짜형 데이터를 원하는 형식의 문자열로 변경해주는 클래스도 있음
		//SimpleDateFormat클래스
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		String result=sdf.format(today);
		System.out.println(result);
		//GregorianCalendar를 Date클래스로 변환하기
		//new Date(long) -> GregorianCalendar long으로 변환해주는 메소드 이용
		Date changeDate=new Date(gc.getTimeInMillis());
		result=sdf.format(changeDate);
		System.out.println(result);
		
		//web(페이지(html))에서 날짜를 전달하게 되면 문자열로 전송이 됨.
		//문자열 형식 : 년-월-일  예)2022-12-10
		String d="2022-12-10";
		String[] dayData=d.split("-");
		System.out.println(dayData[0]);
		System.out.println(dayData[1]);
		System.out.println(dayData[2]);
		GregorianCalendar webDate=new GregorianCalendar(
			Integer.parseInt(dayData[0]),	
			Integer.parseInt(dayData[1])-1,	
			Integer.parseInt(dayData[2]));	
		result=sdf.format(new Date(webDate.getTimeInMillis()));
		System.out.println(result);
				
				
		//simpleDateFormat에서 제공하는 메소드를 이용할 수 있음
		//parse()메소드
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		try {
			today=sdf2.parse(d);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		System.out.println(sdf.format(today));
		
		
		
		//8버전 이후에 날짜를 처리하는 클래스
		//LocalDate, LocalTime, LocalDateTime
		//생성하기 
		LocalDate ld=LocalDate.now();//현재날짜를 불러옴
		System.out.println(ld);
		//원하는 날짜를 세팅하기
		ld=LocalDate.of(2002, 8, 25);
		System.out.println(ld);
		//각 데이터를 따로 출력하려면? get000메소드를 제공함
		System.out.println("년: "+ld.getYear());
		System.out.println("월: "+ld.getMonthValue());
		System.out.println("일: "+ld.getDayOfMonth());
		
		LocalTime lt=LocalTime.now();
		System.out.println(lt);
		lt=LocalTime.of(12, 50, 30);
		System.out.println(lt);
		System.out.println("시간: "+lt.getHour());
		System.out.println("분: "+lt.getMinute());
		System.out.println("초: "+lt.getSecond());
		
		//날짜와 시간을 둘다 관리하는 클래스
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		
		ldt=LocalDateTime.of(ld, lt);
		System.out.println(ldt);
		ldt=LocalDateTime.of(1990,2,14,11,20,55);
		System.out.println(ldt);
		
		System.out.println(ldt.getYear());		
		System.out.println(ldt.getHour());		
		
		ld=LocalDate.parse("1998-03-05");
		System.out.println(ld);
		
		//날짜사이 기간을 계산해주주는 메소드 제공
		//ChronoUnit클래스에서 제공
		long between=ChronoUnit.DAYS.between(LocalDate.of(2022, 12, 1), LocalDateTime.now());
		System.out.println(between);
		between=ChronoUnit.MONTHS.between(LocalDate.of(2022,1,1), LocalDate.now());
		System.out.println(between+"개월");
		
		//LocalDateTime을 Date로 변환하기
		java.sql.Date temp=java.sql.Date.valueOf(LocalDate.now());
		System.out.println(temp);
		java.sql.Timestamp temp2=java.sql.Timestamp.valueOf(ldt);
		System.out.println(temp2);
		
		//Date를 LocalDate, LocalDateTime으로 변경
		LocalDate ld2=new java.sql.Date(temp.getTime()).toLocalDate();
		LocalDateTime ldt2=new java.sql.Timestamp(temp2.getTime()).toLocalDateTime();
		System.out.println(ld2);
		System.out.println(ldt2);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
