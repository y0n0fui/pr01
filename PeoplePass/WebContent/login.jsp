<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jstl/fmt'%>
<%@ page
	import="org.springframework.security.ui.AbstractProcessingFilter"%>
<%@ page
	import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.AuthenticationException"%>


<html>
<head>
<title>Sistema P. P. - Login</title>
<link rel='stylesheet' type='text/css' href="./css/showcase_style.css" />
</head>


<body onload="document.f.j_username.focus();" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<fmt:setBundle basename="com.pp.messages" />

	<%-- this form-login-page form is also used as the
         form-error-page to ask for a login again.
         --%>

	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<table width="409" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="125"><img src="./css/images/login/login_01.jpg"
				width="125" height="255" alt=""></td>
			<td width="274"><table width="274" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td><img src="css/images/login/login_02.jpg" width="274"
							height="92" alt=""></td>
					</tr>
					<tr>
						<td height="153" align="right" valign="middle"
							background="css/images/login/login_04.jpg">
							<form name="f" action="<c:url value='j_spring_security_check'/>"
								method="POST">
								<fmt:message key="login.name" />
								<input type='text' name='j_username'
									value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' />
								<br> <br>
								<fmt:message key="login.password" />
								<input type='password' name='j_password'> <br> <br>
								<input value='<fmt:message key="login.login"/>' name='login'
									type="submit">
								<c:if test="${not empty param.login_error}">
									<font color="red"> <fmt:message key="login.error" /> <!-- Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>. -->
									</font>
								</c:if>
							</form></td>
					</tr>
			</td>
		</tr>
		<tr>
			<td><img src="css/images/login/login_05.jpg" width="274"
				height="10" alt=""></td>
		</tr>
	</table>
	</td>
	<td width="10"><img src="css/images/login/login_03.jpg" width="10"
		height="255" alt=""></td>
	</tr>
	</table>
	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="texto_login style1"><div align="center">
					<p>&nbsp;</p>
					<p>&copy; 2011 PeoplePass S. A., Todos los derechos reservados.</p>
				</div></td>
		</tr>
	</table>
</body>
</html>
