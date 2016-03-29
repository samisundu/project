<%
    session.removeAttribute("userid");
    session.removeAttribute("username");
    response.sendRedirect("login.jsp");


%>