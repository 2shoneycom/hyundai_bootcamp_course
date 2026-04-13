/**
 * 	productSearh2.js
 */
 
 $(document).ready(function() {
 	$('#bookSearchForm2').on('submit', function() {
 		event.preventDefault();
 		
 		let formData = $(this).serialize();
 		
 		let keyword = $('#keyword').val();
 		let type = $('#type').val();
 		
 		if(keyword == "" || type == ""){
 			alert("검색 조건과 검색어를 입력하세요");
 		} else {
 		
 		$.ajax({
	 			type:"post",
	 			url:"/book/bookSearch2", 
	 			data : formData, 
	 			success:function(result) { 
	 				$('#searchResultBox').html(result);
	 			},
	 			error:function() {
	 				alert("실패");
	 			}
	 		});
 	
 		} // else 끝
 	}); // submit 끝
 
 });