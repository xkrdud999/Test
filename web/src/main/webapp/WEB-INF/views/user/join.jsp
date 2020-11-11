<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h2>회원가입 페이지</h2><br>

<form action="/main/user/join" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId">
			<button id="check">중복 검사</button></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw"></td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName"></td>
		</tr>
		
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="userTel"></td>
		</tr>
		<tr>
			<td>프로필사진</td>
			<td><input type=file name="file"></td>
		</tr>
		
		
		<tr>
		<td><input type="submit" value="회원가입" id="submit"></td>
		</tr>
		
	</table>
</form>

<script>
	$(function(){
		var ck = false;
		$("#check").on("click",function(){
			if($("userId").val()){
				$.ajax({
					url : "/web2/user/check",
					type : "post",
					data : $("#userId").val(),
					dataType : "text",
					success : function(check){
						if(check){
							alert("사용할 수 있습니다.");
							$("#check").remove();
							$("#userId").attr("readonly",true);
							ck = !ck;
						}else{
							alert("중복 입니다.");
						}
						return false;
					},
					error : function(){
						alert("ajax에 문제가 있습니다.");
						return false;
						
					}
					
				});
				$("#submit").on("click",function(){
					if(ck){
					}else{
						alert("중복검사가 먼저 진행되어야 합니다.");
						return false;
					}
				});
			}
			
		});
		
	});
</script>
</body>
</html>