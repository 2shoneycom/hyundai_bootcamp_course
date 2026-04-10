/**
 * $.ajax() 메소드 통한 비동기 통신 진행 스크립트
 */
 
 $(document).ready(function(){
 	$('#frmLogin').on('submit',function(){
 	
 		event.preventDefault();
 		
 		let user_id = $('#user_id').val();
 		let user_pw = $('#user_pw').val();
 		
 		$.ajax({
 			type:"post",
 			url:"/mybatis/login", //비동기방식 요청
 			data:{"id":user_id,
 				  "pw":user_pw },
		    success:function(result){ //서버가 전송한 응답데이터를 받을 파라미터 필요
		    	if(result=="success"){
		    		message="로그인 성공\n상품 조회 화면으로 이동합니다";
		    		alert(message);
		    		location.href="/mybatis/product/listAllProduct"; //동기방식요청(브라우저가 요청)
		    		}
	    		else{
	    			message="로그인 실패";
	    			alert(message);
	    			}
    			
		    },
		    error:function(data, textState){
		    	alert("전송실패");
		    },
		    complete:function(data, textState){
		    
		    } 		
 		}); //ajax 끝
	 }); //on 끝
 }); //ready 끝