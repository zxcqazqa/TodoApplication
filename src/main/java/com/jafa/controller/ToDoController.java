package com.jafa.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.domain.DateVO;
import com.jafa.domain.ToDoDTO;
import com.jafa.domain.ToDoVO;
import com.jafa.domain.Today;
import com.jafa.repository.ToDoRepository;
import com.jafa.util.CalendarUtil;

@Controller
@RequestMapping("/todoList")
public class ToDoController {

	@Autowired
	ToDoRepository toDoRepository;
	
	// 일정페이지
	@GetMapping("/{year}/{month}")
	public String home(Model model, @PathVariable Integer month, @PathVariable Integer year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		List<DateVO> dateList = CalendarUtil.getDate(year, month-1);
		List<ToDoVO> todoList = toDoRepository.selectAllByMonth(sdf.format(cal.getTime()));
		
		for(ToDoVO toDo : todoList) {
			String toDoDate = sdf.format(toDo.getToDoDate());
			for(DateVO vo : dateList) {
				if(toDoDate.equals(vo.toString())) {
					vo.setToDoList(toDo);
				}
			}
		}
		String formatData = sdf.format(cal.getTime());
		model.addAttribute("formatData", formatData);
		model.addAttribute("dateList", dateList);
		return "calendar/todoList";
	}
	
	// 일정 추가
	@PostMapping("/toDoWrite")
	public String toDoWrite(ToDoDTO toDoDto) {
		toDoRepository.saveToDo(toDoDto);
		
		String year = toDoDto.getToDoDate().substring(0, 4);
		String month = toDoDto.getToDoDate().substring(4, 6);
		return "redirect:/todoList/"+year+"/"+month;
	}
	
	// 삭제
	@PostMapping("/toDoDelete")
	public String toDoDelete(ToDoDTO toDoDto) {
		List<ToDoVO> info = toDoRepository.findId(toDoDto);
		toDoRepository.delToDo(info.get(0).getId());
		
		String year = toDoDto.getToDoDate().substring(0, 4);
		String month = toDoDto.getToDoDate().substring(4, 6);
		return "redirect:/todoList/"+year+"/"+month;
	}
	
	// 수정
	@PostMapping("/toDoUpdate")
	public String toDoUpdate(ToDoDTO toDoDto) {
		List<ToDoVO> info = toDoRepository.findId(toDoDto);
		toDoDto.setId(info.get(0).getId());
		toDoRepository.updateToDo(toDoDto);
		
		String year = toDoDto.getToDoDate().substring(0, 4);
		String month = toDoDto.getToDoDate().substring(4, 6);
		return "redirect:/todoList/"+year+"/"+month;
	}

}
