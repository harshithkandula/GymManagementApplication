<%@page import="com.gym.model.Batch"%>
<%@page import="java.util.ListIterator"%>
<%@page import="com.gym.db.Db"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.html" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
     *{
                background-color:burlywood;
            }
</style>
<meta charset="ISO-8859-1">
<title>Add Participant</title>
</head>
<body>

      <%
        ArrayList<Batch> batch_names = new ArrayList<Batch>();
        Db db = new Db();
        batch_names = db.fetchAllBatchesDetails();
        
      %>
     <form action="register" method="post">
         <label>Candidate Name</label>
         <input type="text" name="pname"><br>
         <label>Date Of Birth</label>
         <input type="date" name="dob"><br>
         <label>Gender:</label>
         Male<input type="radio" name="gender" value="male">
         Female<Input type="radio" name="gender" value="female">
         <br>
         <label>Batch Name</label>
         <select name="bname">
              <option value="">-select Batch-</option>
             <%
                if(batch_names.size()>0){
                	for(Batch b: batch_names){
                		%>
                		<option value=<%=b.batchId %>><%=b.batchName %></option>
                		<% 
                	}
                }
                	 %> 
         </select><br>
         <label>Profession</label>
         <input type="text" name="job"><br>
         <label>Contact Number</label>
         <input type="text" name="phno"><br>
         <label>Address</label>
         <textarea name="addr" rows="15" cols="40"></textarea>
         
         <br>
         <br>
         
         <input type="submit" value="register">
    </form>
</body>
</html>