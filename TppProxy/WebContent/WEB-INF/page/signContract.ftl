<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>sign contract</title>
</head>
<body>
<h2>页面签约</h2>
url--->${url}
<#list formItemMap?keys as key>
key:${key}--->value:${formItemMap[key]?default("")}
</#list>
<form action="${url}" method="post">
<#if formItemMap?exists>
<#list formItemMap?keys as key>
<input type="hidden" name="${key}" value="${formItemMap[key]?default("")}"/>
</#list>
</#if>
<input type="submit" value="确认"/>
</form>
<script language="javascript">
	//自动提交表单
	//document.forms[0].submit();
</script>
</body>
</html>