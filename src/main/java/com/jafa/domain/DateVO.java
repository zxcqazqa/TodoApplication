package com.jafa.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateVO {
	
	private int year; // 년
	private int month; // 월
	private int dayOfMonth; // 일
	private int dayOfWeek; // 요일
	private List<ToDoVO> toDoList; // 할 일 
	
	// 예시) yyyyMMdd -> 20230701로 표시되도록
	@Override
	public String toString() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, dayOfMonth);
		// 날짜 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(cal.getTime());
	}
	
	public void setToDoList(ToDoVO toDoVO) {
		if(this.toDoList==null) {
			this.toDoList = new ArrayList<ToDoVO>();
		}
		this.toDoList.add(toDoVO);
	}
	

}
