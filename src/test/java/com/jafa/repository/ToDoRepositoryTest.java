package com.jafa.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;

public class ToDoRepositoryTest extends AppTest{
	
	@Autowired
	ToDoRepository toDoRepository;
	
	@Test
	public void test() {
		System.out.println(toDoRepository.getCurrentDate());
	}

}
