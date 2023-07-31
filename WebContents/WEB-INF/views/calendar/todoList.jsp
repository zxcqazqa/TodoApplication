<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<div>
		<h1>일정</h1>
	</div>
	<div class="row">
		<div class="col-8">
			<div class="text-center">
				<a href="${contextPath}/todoList/${formatData.substring(0, 4)}/${formatData.substring(4, 6)-1}">&lt;</a>
				<span>${formatData.substring(0, 4)}년 ${formatData.substring(4, 6)}월</span>
				<a href="${contextPath}/todoList/${formatData.substring(0, 4)}/${formatData.substring(4, 6)+1}">&gt;</a>
			</div>
			<div>
				<table class="table table-bordered calendar">
					<tr>
						<th style="color: red">일</th>
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th style="color: blue">토</th>
					</tr>
					<c:forEach items="${dateList}" var="date">
						<!-- 일요일이면 tr열기-->
						<c:if test="${date.dayOfWeek == 1}">
							<tr>
						</c:if>
						
						<!-- 해당월이면 -->
						<c:if test="${date.month eq month}">
							<td>
								<a id="${date}" href="#" class="openList">${date.dayOfMonth}</a>
								<c:if test="${not empty date.toDoList}"><span>일정있음</span></c:if>
							</td>
						</c:if>
						
						<!-- 해당월이 아니면 -->
						<c:if test="${date.month ne month}">
							<td></td>
						</c:if>
						
						<!-- 토요일이면 tr닫기-->
						<c:if test="${date.dayOfWeek == 7}">
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="col-4 toDoList">
			<c:forEach items="${dateList}" var="date">
				<div class="${date}">
					<table class="table table-bordered">
						<tr>
							<th>날짜</th>
							<th>메모</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
						<c:forEach items="${date.toDoList}" var="todo">
							<tr>
								<td>${date}</td>
								<td>${todo.memo}</td>
								<td><a id="${date}" href="${todo.memo}" class="modBtn">수정</a></td>
								<td><a id="${date}" href="${todo.memo}" class="delBtn">삭제</a></td>
							</tr>
						</c:forEach>	
					</table>
					<button id="${date}" type="button" class="btn btn-primary addBtn">일정추가</button>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<!-- 일정 추가 -->
<div class="modal" id="writeToDoForm">
	<div class="modal-dialog">
		<form action="${contextPath}/todoList/toDoWrite" method="post">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
				  	<h4 class="modal-title">Modal Heading</h4>
				  	<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<input type="hidden" name="toDoDate" class="toDoDate">
						<input type="text" name="memo" class="form-control memo">
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button class="btn btn-info">추가하기</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
				</div>
   			</div>
		</form>
	</div>
</div>

<!-- 일정 수정 -->
<div class="modal" id="modifyToDoForm">
	<div class="modal-dialog">
		<form action="${contextPath}/todoList/toDoUpdate" method="post">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
				  	<h4 class="modal-title"></h4>
				  	<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<input type="hidden" name="toDoDate" class="toDoDate">
						<input type="hidden" name="memo" class="form-control originMemo">
						<input type="text" name="newMemo" class="form-control newMemo">
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button class="btn btn-success">수정하기</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
				</div>
   			</div>
   		</form>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>