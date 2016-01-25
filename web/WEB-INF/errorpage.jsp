<%@page import="java.util.List"%>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./common/_header.jsp" />
    <body>
        <jsp:include page="./common/_nav.jsp" />
        <h2 class="error">Something went wrong!</h1>
        <p class="error">Sorry, we'll fix this in a jiffy!</p>
        <p class='error'>
            Stack Trace: <%= exception %>
        </p>
            <% 
                StackTraceElement traces[] = exception.getStackTrace();
                for(StackTraceElement element: traces){
                    out.print("<p class=\"error error-trace\">"+element.toString()+"</p>");
                }
            %>
        
    </body>
</html>