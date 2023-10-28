<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
<script>
	function list() {
		let url = "list";
		url += "?nowPage=${param.nowPage}";
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		location.href = url;
	}

	function update() {
		let url = "update";
		url += "?nowPage=${param.nowPage}";
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&teamno=${dto.teamno}";
		location.href = url;
	}

	function del() {
		if(confirm("삭제하시겠습니까?")){
			
		let url = "delete";
		url += "?nowPage=${param.nowPage}";
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&teamno=${dto.teamno}";
		location.href = url;
		}
	}
</script>

</head>
<body>
	<div class="container mt-3">
		<h2>조회</h2>
		<ul class="list-group">
			<li class="list-group-item">이름: ${dto.tname}</li>
			<li class="list-group-item">전공: ${dto.skills}</li>
			<li class="list-group-item">전화번호: ${dto.phone}</li>
			<li class="list-group-item">주소: ${dto.address}</li>
			<li class="list-group-item">우편번호: ${dto.zipcode}</li>
			<li class="list-group-item">성별: ${dto.gender}</li>
		</ul>
		<br>
		<button type="button" class="btn btn-outline-info" onclick="location='create'">등록</button>
		<button type="button" class="btn btn-outline-info" onclick="update()">수정</button>
		<button type="button" class="btn btn-outline-info" onclick="del()">삭제</button>
		<button type="button" class="btn btn-outline-info" onclick="list()">목록</button>
		<br> <br>
	</div>
</body>
</html>