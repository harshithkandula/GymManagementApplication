<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="Header.html" %>
<!DOCTYPE html>
<html>
<head>
<style>
     *{
                background-color:burlywood;
            }
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%
       String stype = request.getParameter("sortby");
       if(stype.equalsIgnoreCase("batch")){
    	   %>
    	   <%@ include file="SearchParticipantsByBatch.jsp" %>
    	   <%
       }
       else if(stype.equalsIgnoreCase("participantid")){
    	   %>
    	   <%@ include file="SearchParticipantById.jsp" %>
    	   <% 
       }
       else{
    	   %>
    	   <%@ include file="SearchParticipantByName.html" %>
    	   <% 
       }
     %>
</body>
</html>