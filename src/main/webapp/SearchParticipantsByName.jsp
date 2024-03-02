<%@page import="com.gym.db.Db"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gym.model.Participant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Participants By Name</title>
</head>
<body>
     <%
       ArrayList<Participant> pn = new ArrayList<Participant>();
       Db d =new Db();
       pn = d.displayAllParticipantDetails();
     %>
       <form action="spbn" method="post">
            <label>Participant Name</label>
            <select name="pname">
                 <option value="">--select participant--</option>
                 <%
                   if(pn.size() > 0){
                	   for(Participant p:pn){
                		   %>
                		   <option value=<%=p.name %>><%=p.name %></option>
                		   <% 
                	   }
                   }
                 %>
            </select>
            <input type="submit" value="search">
       </form>
</body>
</html>