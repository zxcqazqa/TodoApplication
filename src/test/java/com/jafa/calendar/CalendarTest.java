package com.jafa.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println("기본 : " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String formatDate = sdf.format(date);
		System.out.println("포맷 후 : " + formatDate);
		
		Calendar calendar = Calendar.getInstance();
		//System.out.println(calendar);
		Date time = calendar.getTime();
		System.out.println(time);
		
		System.out.println(Calendar.DATE);
		System.out.println("오늘 날짜 : " + calendar.get(5)); // 오늘 날짜
		System.out.println(calendar.get(Calendar.YEAR)+"년");
		System.out.println(calendar.get(Calendar.MONTH)+1+"월"); // 0은 1월 -> +1한다.
		System.out.println(calendar.get(Calendar.DATE)+"일"); // 오늘 날짜
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 1이 일요일
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2022, Calendar.JANUARY, 21);
		calendar2.add(Calendar.DATE, 5);
		calendar2.add(Calendar.DATE, -2);
		System.out.println(calendar2.getTime());
	}
}
