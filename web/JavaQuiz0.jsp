<! 
    Document   : JavaQuiz0
    Author     : Dustin Scott
>
<!DOCTYPE html>
<%@ page import="proj1.JavaQuizBean" %>
<jsp:useBean id="JavaQuizBeanId" scope="session" class="proj1.JavaQuizBean">
</jsp:useBean>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title >Java Quiz</title> 
  </head>
  <body>
    <% JavaQuizBeanId.init(); %>
    
    <% int chapterNo=Integer.parseInt(request.getParameter("chap")); %>
    <!--<h3 style='width:500px auto; max-width:650px; margin:0 auto; '>Java Quiz</h3>
    <div style='width:500px auto; max-width:650px; margin:0 auto; border:2px 
        solid #00cc00; font-weight normal'>
      <form method='post' action='gradeQuestion'>-->
         
      
      </form>
    </div>
</html>