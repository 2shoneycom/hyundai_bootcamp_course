/**
 *  상품번호 중복 체크 : ajax 활용
 */
 
 $(document).ready(function(){
 	$('#prdNoCheckBtn').on('click',function(){
 		event.preventDefault();
 		
 		let prdNo = $('#prdNo').val();
 		
 		if(prdNo == "") {
 			alert("상품번호를 입력하세요");
 			return false;
 		}else{
 			$.ajax({
 				type:"post",
 				url:"/mybatis/product/prdNoCheck",
 				data:{"prdNo":prdNo},
 				dataType:'text',
 				sucess:function(result){
 				
 				},
 				error:function(data, textStatus){
 					alert("전송실패");
 				}
 			
 			});//ajax 		
 		} //else
 	
 	});//on  
 });//ready