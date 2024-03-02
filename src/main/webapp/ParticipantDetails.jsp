<%@page import="java.util.ArrayList"%>
<%@page import="com.gym.model.Participant"%>
<%@page import="com.gym.db.Db"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="Header.html" %>
<!DOCTYPE html>
<html>
<head>
    <style>
          *{
                background-color:burlywood;
            }
    </style>
<meta charset="ISO-8859-1">
<title>Participants Details</title>
</head>
<body>
     
     <%
        Db d = new Db();
       ArrayList<Participant> p =d.displayAllParticipantDetails();
       StringBuffer b = new StringBuffer();
       if(p.size()>0){
    	   %>
    	   <table>
    	      <tr>
    	         <th>ID</th>
    	         <th>NAME</th>
    	         <th>SHOW DETAILS</th>
    	         <th>EDIT</th>
    	         <th>DELETE</th>
    	      </tr>
    	      <% 
    	         for(Participant p1: p){
    	        	 %>
    	        	 <tr>
    	        	    <td><%=p1.id %></td>
    	        	    <td><%=p1.name %></td>
    	        	    <td><a href="participantdetails?id=<%=p1.id%>">Info</a></td>
    	        	    <td><a href="editparticipant?id=<%=p1.id%>">Click Here</a></td>
    	        	    <td><a href="deleteparticipant?id=<%=p1.id%>">ClickHere</a></td>
    	        	 </tr>
    	        	 <% 
    	         }
    	      %>
    	   </table>
    	   <% 
       }
       else{
    	   %>
    	   <h3>No Participants</h3>
    	   <% 
       }
     %>
</body>
</html>