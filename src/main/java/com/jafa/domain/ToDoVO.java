package com.jafa.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ToDoVO {
	
	private Long id;
	private String memo; // 내용
	private Date toDoDate; // 날짜
	private Date regDate; // 등록일

}
