/**
 * 장바구니 목록 : 삭제를 위한 품목 체크 버튼 기능
 */

$(document).ready(function() {
    // [전체 선택] 클릭했을 때
    $('#allCheck').on('click', function() {
        let chk = $('#allCheck').prop("checked"); // 체크되어있으면 true, 아니면 false

        if (chk) {
            $('.chkDelete').prop("checked", true);
        }
        else {
            $('.chkDelete').prop("checked", false);
        }

    });

    // 개별 체크박스 해제할 경우 [전체 선택]도 해제
    // 개별 체크박스가 모두 체크된 경우 [전체 선택]도 체크
    $('.chkDelete').click(function() {
        let total = $('.chkDelete').length;
        let checked = $('.chkDelete:checked').length;

        if (total === checked) {
            $('#allCheck').prop("checked", true);
        }
        else {
            $('#allCheck').prop("checked", false);
        }
    });

    // 장바구니 삭제 요청 ajax
    $('#deleteCartBtn').on('click', function() {
        let chk = $('.chkDelete').is(':checked'); // 개별 체크박스들 중 하나라도 체크되어있으면 true

        if (chk) { // 하나라도 선택한 경우
            let answer = confirm("선택된 상품을 삭제 하시겠습니까?");
			
			if (answer) {
				let checkArr = new Array();
				$('.chkDelete:checked').each(function() {
					checkArr.push($(this).val());
				});
				
				// 배열 data를 파라미터 ajax 요청
				$.ajax({
					url:"/product/deleteCart",
					type:"post",
					data:{"delPrd":checkArr},
					success:function(result){
						if (result) {
							location.href="/product/cartList";
						}
					},
					error:function(){
						alert("오류 발생");
					}
				});
			}
        } 
		else {
			alert("선택된 상품이 없습니다");
		}
    });
	
	// 연습문제 2 : cartList에서 수량변경하면 구매금액과 총 금액이 변경되도록 추가
	$('.cartQty').on('change', function() {
		let qty = $('.cartQty').val();
		
	});
}); 
