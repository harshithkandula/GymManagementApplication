<%@page import="java.util.ArrayList"%>
<%@page import="com.gym.model.Batch"%>
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
<title>Batch Details</title>
</head>
<body>
   
     
   
     <%
       Db d = new Db();
       ArrayList<Batch> bl = d.fetchAllBatchesDetails();
       StringBuffer b = new StringBuffer();
       if(bl.size()>0){
    	   %>
    	   <table>
    	      <tr>
    	         <th>ID</th>
    	         <th>NAME</th>
    	         <th>DETAILS</th>
    	         <th>MODIFY</th>
    	         <th>CANCEL</th>
    	      </tr>
    	      <%
    	        for(Batch i: bl){
    	        	%>
    	        	<tr>
    	        	    <td><%=i.batchId %></td>
    	        	    <td><%=i.batchName %></td>
    	        	    <td><a href="sb?bname=<%=i.batchName%>">Details</a></td>
    	        	    <td><a href="editbatch?batchname=<%=i.batchName%>">Click Here</a></td>
    	        	    <td><a href="cancelbatch?batchname=<%=i.batchName%>">Click Here</a></td>
    	        	</tr>
    	      <% 
    	          }
    	      %>
    	   </table>
    	   <%
       }
     %>
</body>
</html>