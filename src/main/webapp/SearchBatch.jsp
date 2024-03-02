<%@page import="com.gym.model.Batch"%>
<%@page import="com.gym.db.Db"%>
<%@page import="java.util.ArrayList"%>
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
<title>Search Batch</title>
</head>
<body>
 
     
     <%
         ArrayList<Batch> batches = new ArrayList<Batch>();
         Db d = new Db();
         batches = d.fetchAllBatchesDetails();
     %>
     <form action="sbd" method="post">
          <select name="bname">
                <option value="">--select--</option>
                <%
                   for(Batch batch: batches){
                	   %>
                <option value=<%=batch.batchId %>><%=batch.batchName%></option>
                <%
                   }
                %>
          </select>
          <input type="submit" value="search">
     </form>
     
     <a href="dab">Display All Batch Details</a>
     
</body>
</html>