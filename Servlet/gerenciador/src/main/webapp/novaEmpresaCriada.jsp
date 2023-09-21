<%
  	String nomeEmpresa = (String)request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  Empresa <%= nomeEmpresa %> cadastrada com sucesso
</body>
</html>	