/**
 * prdNoCheck.js
 */
 
 $(document).ready(function() {
 	//	bookNoCheckBtn 클릭했을 때 
 	$('#bookNoCheckBtn').on('click', function() {
 	
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val();
 		
 		if(bookNo == ""){
 			alert("도서번호를 입력하세요");
 			return false;
 			
 		} else{
 		
	 		$.ajax({
	 			type:"post",
	 			url:"/book/bookNoCheck", 
	 			data : {"bookNo": bookNo},
	 			dataType:'text',
	 			success:function(result) {
	 				if(result == "available") {
	 					alert("사용가능한 도서번호입니다.");
	 				} else {
	 					alert("사용할 수 없는 도서번호 입니다.");
	 				}
	 			},
	 			error:function() {
	 				alert("실패");
	 			}
	 		});
 		
 		}
 	
 	});
 
 });