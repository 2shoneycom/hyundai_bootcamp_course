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
 			//javascript 내장 함수: post방식 fetch(url,option[,data]).then().catch()
 			//option에 data 추가 시 body에 추가 가능
 			fetch("/mybatis/product/prdNoCheck3",
 				{
 				 method:'post',
 				 headers:{
 				 	'Content-Type':'application/json'
 				 },
 				 body:prdNo 				 
 				 }) 
 			.then(response=>response.text()) 
 			.then(result=>{ 
 	 				console.log(result);
 					if(result=="available"){
 						alert("사용가능한 번호 입니다3.");
 					}else{
 						alert("사용 불가능한 번호 입니다3.");
 					}			
 			
 				})
 			.catch(err => console.log(err));	
 		} //else
 	
 	});//on  
 });//ready