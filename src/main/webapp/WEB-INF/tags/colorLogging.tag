<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="color" type="java.lang.String"  required="false"%>
<%@ attribute name="size" type="java.lang.Integer"  %>
<%--size만큰  =을 출략 --%>

<font color="${color }">
<c:forEach begin="1" end="${size }">=</c:forEach><br/>
</font>