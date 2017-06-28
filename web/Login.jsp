<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@page import="classes.*" %>
<%@ page import="classes.NormalUser" %>
<%@ page import="classes.User" %>

<!doctype html>
<html class="no-js" lang="">
<head>

    <title> Black Box Inx</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width = device-width, initial-scale=1">

    <link href="bootstrap/css/bootstrap.min.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">

    <style>.padding_top{

    }

    </style>





</head>
<body class="page-header2 " id="top-image">


<div class="container-fluid white">
    <h1><img src="Images/code-design.png" sizes="height=10" class="center-block top" >
        <H1 class="text-center">
            Black Box Inc
        </h1>
    </h1>
</div>



<nav class="navbar navbar-inverse ">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="" alt="">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li ><a href="index.jsp">Home<span class="sr-only">(current)</span></a></li>
                <li ><a href="./Aboutus.jsp">About Us </a></li>
                <li><a href="./Contactus.jsp">Contact Us</a></li>
                <li class="active"><a href="dologin">Sign In</a></li>
            </ul>


        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>



<div class="row center-block">

    <div class="col-lg-12 center-block" >

        <h1 class="white text-center"  >Please Sign in to Apply for a job</h1>
    </div>
</div>
<div class="container">


    <div class="row ">

        <c:set var="result" scope="request" value="${requestScope.result}"/>
        <c:if test="${result == true}">

            <div class="col-lg-6"> <div class="alert alert-success alert-dismissable fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;
                </a> <strong>Succesful Login with User name and Password </strong></div> </div>
        </c:if>
        <c:if test="${result==false}">
            <div class="col-lg-6"> <div class="alert alert-danger alert-dismissable fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;
                </a> <strong>Sign up Failed Email Already Exist </strong> </div> </div>
        </c:if>
        <c:set var="result2" scope="request" value="${requestScope.resultsignin}"/>
        <c:if test="${result2 == false}">
            <div class="col-lg-6"> <div class="alert alert-danger alert-dismissable fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;
                </a> <strong>Sign in Failed please check email/password </strong> </div> </div>
        </c:if>

        <div class="col-lg-8">

            <ul class="nav nav-tabs navbar-inverse">
                <li class="active "><a data-toggle="tab" href="#Signin">SignIn</a></li>
                <li><a data-toggle="tab" href="#Signup">SignUp </a>
            </ul>
            <div class="tab-content">
                <div id="Signin" class="tab-pane fade in active">
                    <div class="col-lg-12 well">
                        <form class="form-signin" id="signin_form" action="doadmin" method="post">
                            <input type="hidden" name="adminformtype" value="4"/>
                            <h2 id="signinheading" class="form-signin-heading ">
                                Sign In
                            </h2>
                            <label for="inputid" class="sr-only">Email</label>
                            <input name= "inputid" onchange="emailvalidate(this)" data-toggle="tooltip" title="Sign in to proceed further" type="email" id="inputid" class="form-control" placeholder="Email"
                                   required autofocus> <div id="checkemail" style="display: none"> </div>
                            <label for="password" class="sr-only">Email</label>
                            <input name="password" type="password" id="password" class="form-control" placeholder="Password"
                                  minlength="8" required autofocus>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                        </form>

                        <div class="row" id="notification">

                        </div>
                    </div>
                </div>
                <div id="Signup" class="tab-pane fade">
                    <form class="form" id="signupform" action="doadmin" method="post" >
                        <input type="hidden" name="adminformtype" value="5"/>
                        <table class="table well ">
                            <thead class=" ">
                            </thead>
                            <tbody>
                            <tr>

                                <td colspan="1"><label>First Name</label>
                                    <input type="text" minlength="1" maxlength="50"  name="namefirst" class="form-control " required autofocus>
                                </td>
                                <td colspan="1"><label>Last Name</label>
                                    <input type="text" minlength="1" maxlength="50" name="namelast" class="form-control " required autofocus>
                                </td>
                                <td colspan="1"><label>Email</label>
                                    <input type="email" name="email" class="form-control " required autofocus>
                                </td>
                            </tr>
                            <tr >

                                <td colspan="1"><label>Gender</label>
                                    <select class="form-control" name="gender" required>
                                        <option hidden></option>
                                        <option value="true">Male</option>
                                        <option value="false">Female</option>

                                    </select>
                                </td>
                                <td colspan="1"><label>Password</label>
                                    <input name="password" type="password" minlength="8" id="signuppassword" class="form-control " required autofocus>
                                </td>
                            </tr>
                            <td colspan="2">
                                <label>Your 100 word description</label>
                                <textarea type="text" name="descrp" rows="4" cols="3" minlength="100" maxlength="600\" id="signupdescrp" class="form-control "  required autofocus></textarea> </td>



                            <tr>

                                <td colspan="1"><label>Skill 1</label>
                                    <input type="text"   name="skill1" class="form-control "  required autofocus>
                                </td>
                                <td colspan="1"><label>Years</label>
                                    <input type="number" min="1" max="5"  name="year1" class="form-control "  required autofocus>
                                </td>

                            </tr>

                            <tr>

                                <td colspan="1"><label>Skill 2</label>
                                    <input type="text"  name="skill2" class="form-control "  required autofocus>
                                </td>
                                <td colspan="1"><label>Years</label>
                                    <input type="number" min="1" max="5"  name="year2" class="form-control "  required autofocus>

                                </td>

                            </tr>
                            <tr>

                                <td colspan="1"><label>Phone (optional)</label>
                                    <input type="tel"  name="tel" class="form-control "  autofocus>
                                </td>


                            </tr>

                            <tr>
                                <td colspan="2">
                                    <button class="btn-success btn-lg btn-block " style="width: 25%"  id="submit_form" type="submit">Sign Up!</button></td>
                            </tr>

                            </tbody>
                        </table>

                    </form>


                </div>

            </div>
        </div>

        <div class="col-lg-4">
            <div class="well">
                <H3>Having trouble ?</H3>
                <p>Contact: 03234974774 <br>
                    Email: info@blackbox.com</p>
            </div>
        </div>


    </div>



    <div class="row">

        <div class="col-lg-12 ">
            <H1 class="white text-center"> These are the Oppourtunities we have for you ! </H1>

            <table class="table table-bordered well table-scroll ">
                <thead class="navbar-inverse white">
                <tr class="navbar-inverse">
                    <th>Date</th>
                    <th> Job Description</th>
                    <th> Skill Set</th>
                    <th> Other Requirement</th>
                    <th>Apply </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="date"> 13-jan-2017</td>
                    <td class="wrap">I am in need of a Software or application that can put executable (EXE) files together with other files like microsoft word,excel,pdf or image and make it undetectable.it must be able to run ,install and work perfectly on window 7 ultimate.and it must be 100% fuctional</td>
                    <td>Java Dev</td>
                    <td>3+ Years Exp</td>
                    <td class="button"><button   class="btn-success btn-lg btn-block" onclick="on_apply(id)" id="1job">Yes!</button></td>
                </tr>

               <c:forEach items="${requestScope.joblist}" var="job">

                    <tr id="${job.jId}row">

                     <td  class="date" >${job.sDate}</td>
                     <td class="wrap"> ${job.jJobdes}</td>
                     <td> ${job.jSkill}</td>
                     <td> ${job.other}</td>
                   <td class="button" colspan="1"><button   class="btn-success btn-lg btn-block" onclick="on_apply(id)" id="1${job.jId}">Yes!</button></td>
                   </tr>
               </c:forEach>
                </tbody>
            </table>

        </div>
    </div>


</div>

<footer>
    <div class=" well-lg white ">

        <p> Contact us right away </p>
    </div>
</footer>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/custom.js" type="text/javascript"></script>
<script src="js/vendor/jquery-1.12.0.min.js" type="text/javascript"></script>
<script src="js/vendor/modernizr-2.8.3.min.js" type="text/javascript"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
