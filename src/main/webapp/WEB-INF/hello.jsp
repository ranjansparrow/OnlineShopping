<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    
    
    <p> Here it is</p>
    <c:forEach items="${members}" var="member">
    	<img src = "/images/${member.imageUpload}" height="100px" />
    </c:forEach>
   
     
</body>
</html>