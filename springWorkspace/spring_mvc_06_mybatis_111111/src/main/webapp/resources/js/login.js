/**
 * 
 */
 
 $(document).ready(function() {
 	$('#frmLogin').on('submit', function() {
 	
 		event.preventDefault();
 		
 		let user_id = $('#user_id').val();
 		let user_pw = $('#user_pw').val();
 		
 		$.ajax({
 			type:"post",
 			url:"/mybatis/login",
 			data:{"id":user_id,
 				  "pw":user_pw},
 			success:function(result) {
 				if (resut=="success") {
 					message="로그인 성공\n상품 조회 화면으로 이동합니다";
 					alert(message);
 					location.href="/mybatis/product/listAllProduct";
 				}
 				else {
 					message="로그인 실패";	
 					alert(message);
 				}
 			},
 			error:function(data, textState) {
 				alert("전송실패");
 			},
 			compelete:function(data, textState) {
 				
 			}
 		});
 	});
 });