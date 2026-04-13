/**
 * 	productSearh1.js
 */
 
 $(document).ready(function() {
 	$('#bookSearchForm1').on('submit', function() {
 		event.preventDefault();
 		
 		let formData = $(this).serialize();
 		
 		let keyword = $('#keyword').val();
 		let type = $('#type').val();
 		
 		if(keyword == "" || type == ""){
 			alert("검색 조건과 검색어를 입력하세요");
 		} else {
 		
 		$.ajax({
	 			type:"post",
	 			url:"/book/bookSearch1", 
	 			data : formData, 
	 			success:function(result) { 
	 				
	 				$('#searchResultBox').empty();
	 				$('#searchResultBox').append('<table id="resultTable" border="1" width="500">' + 
	 																		'<tr><th>도서번호</th><th>도서명</th><th>저자</th>' +
	 																		'<th>도서가격</th><th>출판일</th><th>재고</th><th>분류번호</th><th>사진</th></tr>');
	 				if(result == "") { // 검색 결과 없는 경우
	 					$('#resultTable').append('<tr align="center"><td colspan="8">찾는 상품이 없습니다</td></tr>');
	 				} else {
	 				for(let i=0; i<result.length; i++) {
	 				/*
	 				for(let i=0; i<result.length; i++) {	 	
	 						let  prd_date = new Date(result[i].prdDate);
	 						let year = prd_date.getFullYear();
	 						let month = (prd_date.getMonth() + 1).toString().padStart(2, '0');
	 						let date = (prd_date.getDate().toString().padStart(2, '0'));
	 						let prdDate = `${year}-${month}-${date}`;				
	 						$('#resultTable').append('<tr><td>' + result[i].prdNo + '</td><td>' + 
	 																						    result[i].prdName + '</td><td>' +
	 																						    result[i].prdPrice + '</td><td>' +
	 																						    result[i].prdCompany + '</td><td>' +
	 																						    result[i].prdStock + '</td><td>' +
	 																						    prdDate + '</td><td>' +
	 							'<img src="/mybatis/prd_images/' +  result[i].prdNo + 
	 																					'.jpg" width="30" height="20"></td></tr>');
	 					}
	 				*/
	 				
	 						$('#resultTable').append('<tr><td>' + result[i].bookNo + '</td><td>' + 
	 															  result[i].bookName + '</td><td>' +
	 													  		  result[i].bookAuthor + '</td><td>' +
	 														      result[i].bookPrice + '</td><td>' +
	 															  result[i].bookDate + '</td><td>' +
	 														      result[i].bookStock + '</td><td>' +
	 														      result[i].pubNo + '</td><td>' +
	 							'<img src="/book_images/' + result[i].bookNo +
	 							'.jpg" width="30" height="20"></td></tr>');
	 					}
	 				}
	 				
	 				$('#searchResultBox').append('</table>');
	 			},
	 			error:function() {
	 				alert("실패");
	 			}
	 		});
 	
 		} // else 끝
 	}); // submit 끝
 
 });