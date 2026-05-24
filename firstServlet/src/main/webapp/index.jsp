<!DOCTYPE html>
<html>
<head>
    <title>My First Servlet</title>
</head>
<body>
    <h1>Welcome to Servlet Demo</h1>
    <ul>
        <li><a href="hello">Call Servlet (Annotation)</a></li>
        <li><a href="hello">Call Servlet (web.xml)</a></li>
    </ul>

    <h3>Send Data to Servlet:</h3>
    <form action="hello" method="post">
        Name: <input type="text" name="username">
        <input type="submit" value="Submit">
    </form>
</body>
</html>