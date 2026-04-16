/**
 * 회원 탈퇴 경고창 확인 후 진행 
 */

$(document).ready(function(){
	$('#deleteMember').on('click', function(){
		event.preventDefault();
		
		let memId = $(this).data('id');
		
		let answer = confirm("정말로 탈퇴하시겠습니까?");
		if (answer) {
			$.ajax({
				type:"post",
				url:"/member/deleteInfo",
				data:{"id":memId},
				dataType:"text",
				success:function(result){
					if (result == "success") {
						alert("회원 탈퇴가 완료되었습니다");
						location.href = "/";
					}
				},
				error:function(){
					alert("회원탈퇴 오류 발생");
				}
			});
		}
	});
});
