<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Form</title>
</head>
<body>
<h2>Enter Person Details</h2>
<form action="addPerson" method="post">
    Name: <input type="text" name="name"/><br/>
    Age: <input type="text" name="age"/><br/>
    Address: <br/>
    City: <input type="text" name="address.city"/><br/>
    Country: <input type="text" name="address.country"/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
