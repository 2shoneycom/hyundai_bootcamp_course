/**
 * ajax 활용한 상품검색요청 스크립트
 */
 
 $(document).ready(function(){
 	$("#prdSearchFrm2").on('submit',function(){
 		event.preventDefault();
 		
 		//form 내부의 여러 input 관련 value를 쿼리스트링 방식의 데이터로 변환
 		//type=prdName&keyword=노트북 으로 자동 구성
 		let formData = $(this).serialize();
 		
 		let keyword = $("#keyword").val(); 
 		let type = $("#type").val();
 		
 		if(keyword==""||type==""){
 			alert("검색조건과 검색어를 입력하세요");
 		}else{
 			$.ajax({
 			  type:"post",
 			  url: "/mybatis/product/productSearch2",
 			  data:formData,
 			  success:function(result){
 			  		console.log(result);
 			  		$("#searchResultBox").html(result);

 			  },
 			  error:function(){
 			  	alert("전송실패");
 			  }
 			
 			});//ajax
 			
 			}//else 끝
 		
 		
 		
 	
 	});//on 
 });//ready