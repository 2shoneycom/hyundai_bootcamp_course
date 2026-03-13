/**
 * subMenu.js 
 */

let showAllMenu = false;

$(document).ready(function() {
	$('#showAllMenu').on('click', function() {
		if (showAllMenu) {
			$('#subMenuBox').css('visibility', 'hidden');
			$(this).text("전체보기 ▼").css('color', 'black');
			showAllMenu = false;
		} else {
			$('#subMenuBox').css('visibility', 'visible');
			$(this).text("메뉴닫기 ▲").css('color', 'blue');
			showAllMenu = true;
		}
	});
})