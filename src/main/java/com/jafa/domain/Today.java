package com.jafa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Today {
	private int year; // 연
	private int month; //월
	private int day; //일
	private int today; // 오늘날짜
	
	public Today() {
	}
}


