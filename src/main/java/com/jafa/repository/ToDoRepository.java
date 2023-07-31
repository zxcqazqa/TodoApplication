package com.jafa.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jafa.domain.ToDoDTO;
import com.jafa.domain.ToDoVO;

public interface ToDoRepository {
	
	// 날짜 불러오기
	Date getCurrentDate();

	// 달전체 일정
	List<ToDoVO> selectAllByMonth(String date);
	
	// 하루 일정
	List<ToDoVO> selectOne(String date);
	
	// 일정 추가
	void saveToDo(ToDoDTO toDoDto);
	
	// id찾기
	List<ToDoVO> findId(ToDoDTO toDoDto);
	
	// 일정 삭제
	void delToDo(Long id);
	
	//일정 수정
	void updateToDo(ToDoDTO toDoDto);
}
