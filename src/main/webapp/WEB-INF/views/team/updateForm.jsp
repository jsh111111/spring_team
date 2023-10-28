<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
		<h2>팀원 정보 수정</h2>
		<form action="update" enctype="multipart/form-data" method="post">
			<input type="hidden" name='teamno' value="${dto.teamno}"> <input
				type="hidden" name='nowPage' value="${param.nowPage}"> <input
				type="hidden" name='col' value="${param.col}"> <input
				type="hidden" name='word' value="${param.word}">
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" id="tname"
					placeholder="Enter name" name="tname"> <label for="tname">Name</label>
			</div>
			<div class="mb-3 mt-3">
				<label for="skills">Skills : &nbsp</label>
				<input type="checkbox" id="java" name="skills" value="java" /> java &nbsp
				<input type="checkbox" id="jsp" name="skills" value="jsp" /> jsp &nbsp
				<input type="checkbox" id="spring" name="skills" value="spring" /> spring
				<c:forTokens var="list" items="${dto.skills}" delims=",">
					<script>
						document.getElementById('${list}').checked = true;
					</script>
				</c:forTokens>
			</div>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" id="phone"
					placeholder="Enter phone" name="phone"> <label for="phone">Phone</label>
			</div>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" id="address"
					placeholder="Enter address" name="address"> <label
					for="address">Address</label>
			</div>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" id="zipcode"
					placeholder="Enter zipcode" name="zipcode"> <label
					for="zipcode">Zipcode</label>
			</div>
			<div class="form-floating">
				<select class="form-select" id="gender" name="gender">
					<option>남</option>
					<option>여</option>
				</select> <label for="gender" class="form-label">Select gender(select
					one):</label>
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>