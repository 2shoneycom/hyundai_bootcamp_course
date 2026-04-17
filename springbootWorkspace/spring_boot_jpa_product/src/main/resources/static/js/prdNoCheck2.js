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
 			//javascript 내장 함수: get방식 fetch("url+data").then().catch()
 			fetch("/mybatis/product/prdNoCheck2/"+prdNo) //1.url로 네트워크 요청 전송, 서버 응답 객체 : promise 객체 반환
 			.then(response=>response.text()) //콜백으로 호출 됨 -> HTTPResponse 객체를 첫번째 인자로 받음
 			//.then(response=>console.log(response.text()))
 			.then(result=>{ //첫번째 then에서 파싱한 실제 body data를 인자로 받음
 	 				console.log(result);
 					if(result=="available"){
 						alert("사용가능한 번호 입니다2.");
 					}else{
 						alert("사용 불가능한 번호 입니다2.");
 					}			
 			
 				})
 			.catch(err => console.log(err));	
 		} //else
 	
 	});//on  
 });//ready