<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사원추가</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
   $(function(){
      console.log("ready....");
      
//       let obj_dept_job_id = {
//             dept_ids:[10,20,30,40,50,60],
//             job_ids:[
//                'FI_MGR',
//                'FI_ACCOUNT',
//                'AC_MGR']};
      
      //json_dept_id.do
//       select department_id from temp_dept;
      
      $.get("json_dept_id.do",function(responseText){
//          console.log(".get : ",responseText);
         let dept_ids = JSON.parse(responseText);//10~270
         console.log(".get : ",dept_ids);
         dept_ids.forEach(function(dept_id){
            $("#department_id").append(
               '<option value="'+dept_id+'">'+dept_id+'</option>');
         });
         
      });
      
      $.get("json_job_id.do",function(responseText){
//          console.log(".get : ",responseText);
         let job_ids = JSON.parse(responseText);//10~270
         console.log(".get : ",job_ids);
         
         job_ids.forEach(function(job_id){
            $("#job_id").append(
               '<option value="'+job_id+'">'+job_id+'</option>');
         });
         
      });
      
      
      
      
   });
</script>
</head>
<body>
   <h1>사원추가</h1>
   <form action="insertOK.do" method="post">
      <label for="first_name">first_name:</label>
      <input type="text" placeholder="first_name" id="first_name"
         name="first_name" value="GilDong">
      <br> 
      
      <label for="last_name">last_name:</label>
      <input type="text"
         placeholder="last_name" id="last_name" name="last_name" value="Yang"><br> 
      <label for="salary">salary:</label>
      <input type="text" placeholder="salary"
         id="salary" name="salary" value="9990"><br> 
      <label for="department_id">department_id:</label>
      <select id="department_id" name="department_id">
      </select><br> 
      <label for="job_id">job_id:</label>
      <select id="job_id" name="job_id">
      </select><br>
      <input type="submit" value="사원추가">
   </form>

</body>
</html>