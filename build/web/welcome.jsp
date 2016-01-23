<%-- 
    Document   : welcome
    Created on : Jan 18, 2016, 7:03:55 PM
    Author     : Rob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./common/_header.jsp" />
    <body>
        <jsp:include page="./common/_nav.jsp" />
        <jsp:include page="./common/_welc.jsp" />
        

            <jsp:include page="./common/_signupform.jsp" />
            <jsp:include page="./common/_reviewform.jsp" />

        
        <jsp:include page="./common/_footer.jsp" />
    </body>
</html>
