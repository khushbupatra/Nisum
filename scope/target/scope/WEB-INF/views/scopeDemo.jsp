<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bean Scope Demonstration</title>
</head>
<body>
    <h1>Bean Scope Demonstration</h1>

    <p>Singleton bean value: ${singletonValue}</p>
    <p>Prototype bean value: ${prototypeValue}</p>
    <p>Request scope bean value: ${requestValue}</p>
    <p>Session scope bean value: ${sessionValue}</p>

    <p><a href="scope">Refresh page</a></p>
    <p><a href="scope" target="_blank">Open in new tab</a></p>
</body>
</html>