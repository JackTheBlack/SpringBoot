<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>Hellow World</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>
<body>
		<h1>Hola World</h1>
		<p>desarrollo web con spring</p>
		 <table>
        <tr th:each="user :${personas}">
    	<td th:text="${user}"></td>
    	</tr>
   </table>
   <a href="mail" >Contactanos</a>
   
</body>
</html>