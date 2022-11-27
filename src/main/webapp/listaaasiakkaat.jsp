<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="scipts/main.js"></script>
<title>Insert title here</title>
</head>
<body>




<table id ="listaus">
<thead>
<tr>
<th colspan="5" class="oikealle"><a href="lisaaasiakas.jsp">Lisää uusi asiakas</a></th>

</th>
<tr>
			<th>Hakusana:</th>
			<th colspan="3"><input type="text" id="hakusana"></th>
			<th><input type="button" value="hae" id="hakunappi" onclick="haeAsiakkaat()"></th>
		</tr>	
</thead>
<script scr="scripts/main.js"></script>
	<thead>
	<tr>
	
	<th>etunimi</th>
	<th>sukunimi</th>
	<th>puhelin</th>
	<th>sposti</th>
	</thead>
	<tbody id = "tbody">
	</tbody>
	</tr>
</table>

</body>
</html>