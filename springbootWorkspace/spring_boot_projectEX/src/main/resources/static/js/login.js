/**
 * login.js
 */

$(document).ready(function() {
    $('#loginForm').on('submit', function() {
        event.preventDefault();

        let id = $('#id').val();
        let pwd = $('#pwd').val();

        if (id == "") {
            alert("아이디를 입력해주세요");
			$('#id').focus();
        }
        else if (pwd == "") {
            alert("비밀번호를 입력해주세요");
			$('#pwd').focus();
        }
        else {
            $.ajax({
                type: "post",
                url: "/member/login",
                data: { "id": $('#id').val(), "pwd": $('#pwd').val() },
                dataType: "text",
                success: function(result) {
                    if (result == "success") {
                        alert("로그인 성공\n메인 페이지로 이동합니다");
                        location.href = "/"; // 로그인 처리된 메인페이지
                    } else {
                        alert("아이디 또는 비밀번호가 일치하지 않습니다");
						$('#pwd').val("");
						$('#id').focus();
                    }
                },
                error: function() {
                    alert("전송실패");
                }
            }); // ajax 끝
        }

    }); // on 끝
}); // ready 끝