<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
.dropdown-menu {top:auto;}
</style>

</head>
<body>

<div class="container">                                     
  <div class="dropdown">
   <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Assignments by student
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#"></a>
      <div class="container">
		  <form role="form" action="dataview" method = "post">
		    <div class="form-group">
		      <label for="s_ID">Student ID:</label>
		      <input type="s_ID" class="form-control" name="s_ID" id= "s_ID" placeholder="Enter s_ID">
		    </div>
		    <button type="submit" class="btn btn-primary btn-lg btn-block" value="dataview">Find Assignments</button>
		  </form>
		</div>
      </li>
      </ul>
  </div>
</div>
<br><br>


<div class="container">                                     
  <div class="dropdown">
   <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Assignments by type
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#"></a>
      <div class="container">
		  <form role="form" action="bytype" method = "post">
		    <div class="form-group">
		      <label for="a_type">Assignment type:</label>
		      <input type="a_type" class="form-control" name="a_type" id= "a_type" placeholder= "Enter "a_type">
		    </div>
		    <button type="submit" class="btn btn-primary btn-lg btn-block" value="bytype">Find Assignments</button>
		  </form>
		</div>
      </li>
      </ul>
  </div>
</div>
 <br><br>    
      
      
  <div class="container">                                     
  <div class="dropdown">
   <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Assignments by student and type
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#"></a>
      <div class="container">
		  <form role="form" action="typestudent" method = "post">
		    <div class="form-group">
		      <label for="st_ID">Student ID:</label>
		      <input type="st_ID" class="form-control" id= "st_ID" name="st_ID" placeholder= "Enter st_ID">
		    </div>
		     <div class="form-group">
		      <label for="st_type">Assignment type:</label>
		      <input type="st_type" class="form-control" id= "st_type" name="st_type" placeholder= "Enter st_type">
		    </div>
		    <button type="submit" class="btn btn-primary btn-lg btn-block" value="typestudent">Find Assignments</button>
		  </form>
		</div>
      </li>
      </ul>
  </div>
</div>
<br><br>

      <div class="container">                                     
  <div class="dropdown">
   <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Student average
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#"></a>
      <div class="container">
		  <form role="form" action="average" method = "post">
		    <button type="submit" class="btn btn-primary btn-lg btn-block" value="average">Find Average</button>
		  </form>
		</div>
      </li>
      </ul>
  </div>
</div>
<br><br>

 <div class="container">                                     
  <div class="dropdown">
   <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Student average by assignment type
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#"></a>
      <div class="container">
		  <form role="form" action="averagestd" method = "post">
		    <div class="form-group">
		      <label for="st_avg_id">Assignment type:</label>
		      <input type="st_avg_id" class="form-control" id= "st_avg_id"  name="st_avg_id" placeholder= "Enter st_avg_id">
		    </div>
		    <button type="submit" class="btn btn-primary btn-lg btn-block" value="averagestd">Find Average</button>
		  </form>
		</div>
      </li>
      </ul>
  </div>
</div>
<br><br>

 <div class="container">                                     
  <div class="dropdown">
   <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Maximum and Minimum grade for assignment type
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#"></a>
      <div class="container">
		  <form role="form" action="maxmin" method = "post">
		    <div class="form-group">
		      <label for="mm_type">Assignment type:</label>
		      <input type="mm_type" class="form-control" id= "mm_type" name="mm_type" placeholder= "Enter mm_type">
		    </div>
		    <button type="submit" class="btn btn-primary btn-lg btn-block" value="maxmin">Find</button>
		  </form>
		</div>
      </li>
      </ul>
  </div>
</div>
      
     
</body>
</html>





