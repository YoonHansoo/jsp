<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.ddit.rangers.service.RangersService"%>
<%@page import="kr.or.ddit.rangers.model.RangerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%--
    	jstl을 사용 하기 위한 준비 : jsp 디렉티브(taglib)을 이용하여 사용하고자 하는 라이브러리 선언 
    							prefix = "임의로 작성 가능하나 일반적으로 사용하는 이름  권장
    							core : c , format : fmt, function : fn
    							uri = "자동완성 기능"
     --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		RangerVo rangerVo = new RangerVo("brown", "브라운", 8);
		session.setAttribute("ranger", rangerVo);
	%>

	<%-- url: localhost/jstl/core.jsp --%>
	<h2>core : set</h2>

	<%--특정 scope(page,request, session, application)에 속성을 생성
	기본 scope : page   --%>
	<%--pageContext.setAttribute("userId","brown"); --%>

	<c:set var="userId" value="brown" scope="session" />
	<%--속성 생성 --%>

	user(표현식) :
	<%=pageContext.getAttribute("userId")%>
	<br /> user(표현식-session) :
	<%=session.getAttribute("userId")%>
	<br /> userId(EL) : ${userId}
	<br />


	<c:set target="${ranger}" property="age" value="10" />
	<%--속성을변경  target=> 객체  property => 속성(setter와 매핑됨)  value=>바꿀 값 --%>

	ranger - 나이변경 : ${ranger.age }
	<br />

	<h2>객체생성</h2>
	<c:set var="test" value="<%=new RangerVo(\"brown\",\"브라운\", 15)%>" />
	test : ${test }
	<br />


	<%-- 
	pageContext.removeAttribute("test");
	--%>
	<c:remove var="test" />
	test : ${test}
	<br />

	<h2>core - if</h2>
	<!-- pageContext에 code속성 추가 -->
	<c:set var="code" value="01"></c:set>
	<c:if test="${code == '00'}">
	 <span>코드가 00값 입니다.</span>
	</c:if>
	<c:if test="${code == '01'}">
	 <span>코드가 01값 입니다.</span>
	</c:if>
	
	<h2> core - choose</h2>
	<%-- request.setAttribute("code","03")  --%>
	
	<c:remove var="code"/>
	
	<c:set var ="code" value="01" scope ="request"/>
	
	<c:choose>
		<c:when test="${code == '00'}"> code가 ${code}00값 입니다.</c:when>	
		<c:when test="${code == '01'}"> code가 ${code}01값 입니다.</c:when>	
		<c:when test="${code == '02'}"> code가 ${code}02값 입니다.</c:when>	
		<c:when test="${code == '03'}"> code가 ${code}03값 입니다.</c:when>
		                                             
		                                             
		<c:otherwise>code가 ${code} else  입니다.</c:otherwise>	
	</c:choose>
	
	<h2> core - forEach</h2>
	
	<%
		RangersService rangerService = new RangersService();
	request.setAttribute("rangersList", rangerService.getRangerVoAll());
	%>

<h3>향상된 for 문</h3>
<c:forEach items="${rangersList}" var ="ranger">
	${ranger.name} / ${ranger.alias } / ${ranger.age }<br/>
</c:forEach>


<h3>일반 for 문</h3>
<%--for(int i = 0; i=0<10; i++ --%>
<c:forEach begin="0" end ="10" varStatus="status" step="1">
	<span>test${status.index}"</span> <br/>
</c:forEach>

<%--
	for(int i = 0; i < rangersList.size(); i++)
		System.out.println(rangerList.get(i).name);
 --%>
<c:forEach var="i" begin="0" end="${rangersList.size()-1}">
${rangersList.get(i).name} / ${rangersList.get(i).alias} / ${rangersList.get(i).age}  <br/>

</c:forEach>


<h2>core - forEach (map)</h2>

<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("ranger1","brown");
	map.put("ranger2","cony");
	map.put("ranger3","sally");

	pageContext.setAttribute("map", map);
%>
	<c:forEach items="${map}" var="entry">
	${entry.key} / ${entry.value }<br/>
	</c:forEach>
     

</body>
</html>