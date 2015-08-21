<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>grades</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <style>
 
  .other-color{
  background: lightskyblue
  }
  
  .jumbotron h1{
  color: slategray
  }
  
 </style>

 
 
<title>Grade Book</title>
</head>
<body>

<div class="container">
  
  <div class="container">
  <div class="jumbotron other-color">
    <center><h1>Add Information</h1></center>        
  </div>     
</div>
  
  
  
  <form class="form-horizontal" role="form" action="addstudent" method = "post">
    <div class="form-group">
      <label class="control-label col-sm-5" for="studentID">Student ID:</label>
      <div class="col-sm-5">
        <input type="text" class="form-control" id="studentID" name = "studentID" placeholder="Enter studentID">
      </div>
    </div>
    
    
    <div class="form-group">
      <label class="control-label col-sm-5" for="class">Class name:</label>
      <div class="col-sm-5">          
        <input type="text" class="form-control" id="class" name = "class" placeholder="Enter class">
      </div>
    </div>
    
    
    <div class="form-group">
      <label class="control-label col-sm-5" for="assignment">Assignment name:</label>
      <div class="col-sm-5">          
        <input type="text" class="form-control" id="assignment" name = "assignment" placeholder="Enter assignment">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-5" for="type">Type of Assignment:</label>
      <div class="col-sm-5">          
        <input type="text" class="form-control" id="type" name = "type" placeholder="Enter type">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-5" for="date">Date:</label>
      <div class="col-sm-5">          
        <input type="text" class="form-control" id="date" name = "date" placeholder="Enter date">
      </div>
    </div>
    
    
    <div class="form-group">
      <label class="control-label col-sm-5" for="grade">Grade:</label>
      <div class="col-sm-5">          
        <input type="text" class="form-control" id="grade" name = "grade" placeholder="Enter grade">
      </div>
    </div>
       
       
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-5">
       <center> <button type="submit" class="btn btn-primary btn-lg btn-block" value="addstudent">Add Student</button></center>
      </div>
    </div>
  </form>


 <div class="container">
  <div class="jumbotron other-color">
   <center> <h1>Adjust Weights</h1>  </center>    
  </div>     
</div>

  <form role="form-horizontal" action="setweights" method = "post">
  

     <div class="form-group">
      <label class="control-label col-sm-5" for="grade">Homework weight:</label>
      <div class="col-sm-5">          
        <input type="text" class="form-control" id="grade" name = "grade" placeholder="Enter grade">
      </div>
    </div>
    
    
    
    <div class="form-group">
      <label class="control-label col-sm-5" for="quiz">Quiz weight:</label>
       <div class="col-sm-5"> 
      <input type="number" class="form-control" id="quiz" name="quiz" placeholder="Enter quiz">
      </div> 
        </div>
<br><br>

    <div class="form-group">
      <label class="control-label col-sm-5" for="project">Project weight:</label>
      <div class="col-sm-5"> 
      <input type="number" class="form-control" id="project" name="project" placeholder="Enter project">
      </div> 
    </div>    
    
    
    <br><br>
    
    
    <div class="form-group">
      <label class="control-label col-sm-5" for="test">Test weight:</label>
      <div class="col-sm-5"> 
      <input type="number" class="form-control" id="test" name="test" placeholder="Enter test">
      </div> 
    </div> 
    
    <br><br>
    
    <div class="form-group">        
     <div class="col-sm-offset-2 col-sm-5">
       <button type="submit" class="btn btn-primary btn-lg btn-block" value="addstudent">Set Weights</button>
     </div>
   
  </form>
</div>



</body>
</html>