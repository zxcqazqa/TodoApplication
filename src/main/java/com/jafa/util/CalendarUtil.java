package com.jafa.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jafa.domain.DateVO;

public class CalendarUtil {
	
	/*
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 오늘 날짜
		//cal.set(Calendar.YEAR, 2023); // 2023년
		//cal.set(Calendar.MONTH, 7-1); // 7은 8월달 -> -1 해줘야 됨.
		
		System.out.println("오늘 날짜 : " + cal.getTime());
		System.out.println("오늘 요일 : " + cal.get(Calendar.DAY_OF_WEEK));
		
		cal.set(2023, 7-1, 1); // 2023년 7월 1일로 설정
		int firstDay = cal.get(Calendar.DAY_OF_WEEK); // 해당월 시작하는 요일?
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); // getActualMaximum 해당월 마지막 날짜 ex) 6월은 30일, 7월달은 31일
		
		System.out.println("해당월 시작요일 : " + firstDay);
		System.out.println("해당월 마지막일 : " + lastDayOfMonth);
		
		// 이전달 7월1일에서 1일 감소
		//cal.set(Calendar.MONTH, 7-2);
		//cal.set(2023, 7-2, 1);
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime()); // 7월1일에서 -1 -> 6월 30일 금요일
	}
	*/
	
	public static List<DateVO> getDate(int year, int month) {
		List<DateVO> dateList = new ArrayList<DateVO>();
		Calendar cal = Calendar.getInstance(); // 오늘 날짜
		cal.set(year, month, 1); // (2023, 7, 1) 7월 1일
		int firstDay = cal.get(Calendar.DAY_OF_WEEK); // 7월달 첫번째 날짜, 일요일:1 ~ 토요일:7

		// 이전달, 6월달
		for (int i = 0; i < firstDay - 1; i++) { // 7월 firstDay ==7 토요일
			cal.add(Calendar.DATE, -1); // 일월화수목금 까지는 6월달 꺼
			System.out.println(cal.getTime());
			DateVO vo = DateVO.builder().year(cal.get(Calendar.YEAR)).month(cal.get(Calendar.MONTH) + 1)
					.dayOfMonth(cal.get(Calendar.DATE)).dayOfWeek(cal.get(Calendar.DAY_OF_WEEK)).build(); // month 다시 +1하고
			dateList.add(vo);
		}
		// 양수이면 오름차순, 음수이면 내림차순 , 람다식에 (Date vo1,Date vo2) 생략한거
		dateList.sort((vo1, vo2) -> vo1.getDayOfMonth() - vo2.getDayOfMonth());
																				

//	// 이전달
//	cal.add(Calendar.MONTH, -1);
//	System.out.println("이전달 : "+cal.getTime());

		// 이번달, 7월
		cal = Calendar.getInstance();
		cal.set(year, month, 1);
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); // 31일
		for (int i = 1; i <= lastDayOfMonth; i++) {
			cal.set(year, month, i);
			DateVO vo = DateVO.builder().year(cal.get(Calendar.YEAR)).month(cal.get(Calendar.MONTH) + 1)
					.dayOfMonth(cal.get(Calendar.DATE)).dayOfWeek(cal.get(Calendar.DAY_OF_WEEK)).build();
			dateList.add(vo);
		}

		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		int repeat = 7 - cal.get(Calendar.DAY_OF_WEEK);
//	System.out.println("이번달 마지막 : "+cal.getTime());
		for (int i = 0; i < repeat; i++) {
			cal.add(Calendar.DATE, 1);
			DateVO vo = DateVO.builder().year(cal.get(Calendar.YEAR)).month(cal.get(Calendar.MONTH) + 1)
					.dayOfMonth(cal.get(Calendar.DATE)).dayOfWeek(cal.get(Calendar.DAY_OF_WEEK)).build();
			dateList.add(vo);
		}
		
		return dateList;
	}
	
	

}
