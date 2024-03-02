<%@page import="com.gym.model.Batch"%>
<%@page import="com.gym.db.Db"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
   <style type="text/css">
         *{
                background-color:burlywood;
            }
   </style>
<meta charset="ISO-8859-1">
<title>SearchParticipantsByBatch</title>
</head>
<body>
     <%
        Db d = new Db();
        ArrayList<Batch> batch = new ArrayList<Batch>();
        batch = d.fetchAllBatchesDetails();
     %>
     <form action="dppb" method="post">
         <select name="b_name">
              <option value="">--select batch--</option>
              <%
                if(batch.size()>0){
                	for(Batch b: batch){
                		%>
                		<option value=<%=b.batchId %>><%=b.batchName %></option>
                		<% 
                	}
                }
                
              %>
         </select>
         <input type="submit" value="proceed">
     </form>
</body>
</html>