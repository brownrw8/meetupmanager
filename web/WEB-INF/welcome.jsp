
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./common/_header.jsp" />
    <body>
        <jsp:include page="./common/_nav.jsp" />
        <jsp:include page="./common/_welc.jsp" />
        
        <jsp:include page="./common/_signupform.jsp" />
        <jsp:include page="./common/_reviewform.jsp" />
        <jsp:include page="${user.isAdmin ? './common/_adminform.jsp' : ''}" />
        
        <jsp:include page="./common/_myevents.jsp" />
               
        <jsp:include page="./common/_footer.jsp" />
    </body>
</html>
