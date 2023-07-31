console.log('todoList.js');

$(function(){
	// 일요일, 토요일 색 바꾸기
	$('.calendar').find('tr').each(function(index, item){
		$(this).find('td:eq(0) a').attr('style', 'color: red');
		$(this).find('td:eq(6) a').attr('style', 'color: blue');
	});
	
	// 오늘 날짜에 빨간색 테두리 넣기
	$('.calendar').find('a').each(function(index, item){
	    if ($(item).attr('id') == today.today) { 
	        $(item).closest('td').attr('class', 'day_on');
	    }
	});
	
	$('.toDoList').find('div').hide();
	// 날짜 클릭
	$('.openList').click(function(e){
		e.preventDefault();
		let toDoDate = $(this).attr('id');
		$('.toDoList').find('div').hide();
		$('.toDoList').find('div').each(function(index, item){
			if($(item).attr('class') == toDoDate) {
				$(item).show();
			}
		});
	});
	
	// 일정 추가
	$('.addBtn').click(function(e){
		e.preventDefault();
		let toDoDate = $(this).attr('id');
		$('#writeToDoForm .modal-title').html(toDoDate);
		$('#writeToDoForm .toDoDate').val(toDoDate);
		$('#writeToDoForm .memo').val('');
		$('#writeToDoForm').modal();
	});
	
	// 일정 삭제
	$('.delBtn').click(function(e){
		e.preventDefault();
		let toDoDate = $(this).attr('id');
		let memo = $(this).attr('href');
		let form = $('<form/>');
		form.attr('action',`${contextPath}/todoList/toDoDelete?memo=${memo}&toDoDate=${toDoDate}`)
			.attr('method','post')
			.appendTo('body')
			.submit();
	});
	
	// 수정폼
	$('.modBtn').click(function(e){
		e.preventDefault();
		let toDoDate = $(this).attr('id'); // 날짜
		let originMemo = $(this).attr('href'); // 메모
		$('#modifyToDoForm .modal-title').html(toDoDate);
		$('#modifyToDoForm .toDoDate').val(toDoDate);
		$('#modifyToDoForm .originMemo').val(originMemo);
		$('#modifyToDoForm .newMemo').val(originMemo);
		$('#modifyToDoForm').modal();
	});

});
