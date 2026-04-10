/**
 * 
 */
 
 $(document).ready(function() {
 	$('#prdNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let prdNo = $('#prdNo').val();
 		
 		if (prdNo == "") {
 			alert("상품 번호를 입력하세요");
 			return false;
 		} else {
 			$.ajax({
 				type:"post",
 				url:"/mybatis/product/prdNoCheck",
 				data:{"prdNo": prdNo},
 				dataType: 'text',
 				success: function(result) {
 					
 				},
 				error:function(data, textStatus) {
 					alert("전송 실패");
 				}
 			});
 		}
 		
 	});
 });