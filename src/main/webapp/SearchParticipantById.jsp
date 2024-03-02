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
<title>Search Participant By ID</title>
</head>
<body>
     <form action="spbi" method="post">
        <label>Participant ID</label>
        <input type="text" name=pid placeholder="Enter participant id">
        <input type="submit" value="search">
     </form>
</body>
</html>