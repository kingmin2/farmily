<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Farmily</title>
<link href="css/kmj/main.css" rel="stylesheet" type="text/css">
<link href="css/hjh/profile.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
/* 	function loginCheck() {
 		let id = $('#id').val();
		let passwd = $('#passwd').val();
		/*let Member = $('form').serialize();*/
	 	$.ajax(
			{
				type : 'POST',
				url : '/loginCheck',
				data : {id : id, passwd : passwd},
				
			
				/* success : function(result) {
					location.href = "main"; */
				}
			}		
		)
	} */
</script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="/WEB-INF/views/main/header.jsp"></jsp:include>
		<div class="container signFrame">
		<!-- 여기 하단으로 -->
			<div class="signInFrame">
				<div class="titleFrame">
					<h1 class="signInTitle">FARMily</h1>
				</div>
				<form action="loginCheck" method="post" class="signInData">
					<div>
						<label class="form-label" for="id">ID</label>
						<input id="id" class="ember-text-field ember-view form-control" name="id" type="text">
					</div>
					<div>
						<label class="form-label" for="passwd">비밀번호</label>
						<input id="passwd" class="ember-text-field ember-view form-control" name="passwd" type="password">
					</div>
					<button type="submit" class="btn text-white" id="btnSign">로그인</button>
				</form>
				<a href="signUp" class="btn text-white" id="btnSign">회원가입</a>
				<div class="findAccount">
					<span>ID/비밀번호를 잊어버리셨나요?</span>
				</div>
			</div>
		<!-- 여기 상단으로 -->
		</div>
	<jsp:include page="/WEB-INF/views/main/footer.jsp"></jsp:include>
	</div>
</body>
</html>