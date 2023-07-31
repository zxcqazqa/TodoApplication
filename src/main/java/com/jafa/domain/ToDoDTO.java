package com.jafa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDTO {
	
	private Long id;
	private String memo;
	private String newMemo;
	private String toDoDate;

}
