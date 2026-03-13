/**
 * join.html에 포함되는 js
 * submit 버튼 클릭시 동작되도록 구성 
 */

window.onload = function() {
	document.getElementById('joinForm').onsubmit = () => {
		// 성명
		let name = document.getElementById('name');
		if (name.value == '') {
			alert("성명을 입력하세요");
			name.focus();
			return false;	// 이게 없으면 무조건 submit 이벤트가 완료됨 (즉, 다음 페이지로 넘어감)
		}
		
		// 아이디
		let id = document.getElementById('id');
		if (id.value.length < 6 || id.value.length > 10) {
			alert("id를 6~10자 내로 입력하세요 ");
			id.focus();
			return false;
		}
		
		// 비밀번호
		let pass = document.getElementById('password');
		let passChk = document.getElementById('passwordCheck');
		if (pass.value != passChk.value) {
			alert("비밀번호가 일치하지 않습니다");
			passChk.value = "";
			passChk.focus();
			return false;
		}
		
		// 직업
		let job = document.getElementById('job');
		if (job.selectedIndex==0) {
			alert("직업을 선택하세요");
			return false;
		}
		
		// 이메일 수신 동의
		// 라디오 버튼의 그룹 참조를 위해 name 속성을 활용한 참조
		let chk = false;
		for (let i = 0; i < joinForm.emailRcv.length; i++) {
			if (joinForm.emailRcv[i].checked=true)
				chk=true;
		}
		if (chk == false) {
			alert("이메일 수신 여부를 선택하세요");
			return false;
		}
		
		let agree1 = document.getElementById('agreement1');
		let agree2 = document.getElementById('agreement2');
		
		if (agree1.checked == false || agree2 == false) {
			alert("모든 약관에 동의해야 합니다");
			return false;
		}
	} // onsubmit
}// onload