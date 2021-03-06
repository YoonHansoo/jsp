/**
 * @param CookieName
 *            쿠기 이름으로 해당 쿠키 값을 조회
 */
function getCookieValue(cookieName) {
	/*
	 * String cookieValue = "";
	 * 
	 * for(String cookie : cookieArray){
	 * if(cookiename.equals(cookie.split("=")[0])){ cookieValue =
	 * cookie.split("=")[1]; break; } } return cookieValue;
	 */

	var cookieValue = "";
	var cookieArray = document.cookie.split("; ");

	for (var i = 0; i < cookieArray.length; i++) {

		// userId = brown
		var cookie = cookieArray[i];
		if (cookieName == cookie.split("=")[0]) { // cookieName
			cookieValue = cookie.split("=")[1]; // cookieValue
			break;
		}
	}
	return cookieValue;
}

/**
 * @param cookieName
 * @param cookieValue
 * @param expire
 *            쿠키 생성
 */
function setCookie(cookieName, cookieValue, expires) {
	// 현재 날짜 기준으로 expires 날짜 만큼 유효한 쿠키 생성
	// 쿠키 생성 방법 : document.cookie = "cookie 문자열 포맷"
	// cookie 문자열 포맷 : cookieName = cookieValue; path=/; expires = gmtString

	var today = new Date();
	today.setDate(today.getDate() + parseInt(expires));
	document.cookie = cookieName + "=" + cookieValue + "; path=; expires="
			+ today.toGMTString();

}

/**
 * @param cookieName @
 *            쿠키 삭제
 */
function deleteCookie(cookieName) {
	var dt = new Date();  //오늘날짜
	dt.setDate(dt.getDate()-1); //하루 전 날짜
	
	document.cookie = cookieName + "= + path=/; expires= " + dt.toGMTString(); //현재시간기준으로 expires가  과거이면 자동삭제됨
}


//실제로 한글을 넣을 땐  encodeURIComponent(cookieValue)라고 넣어야 함













