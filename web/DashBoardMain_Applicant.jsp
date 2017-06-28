<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@page import="classes.*" %>
<%@ page import="classes.NormalUser" %>
<%@ page import="classes.User" %>


<!doctype html>
<html lang="">
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
<body class="page-header2 " id="top-image" >
 <h1 id="checking">Hello there</h1>
<nav class="navbar navbar-inverse navbar-fixed-top ">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Black Box Inc<img src="" alt="">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="dologout">LogOut<span class="sr-only">(current)</span></a></li>

            </ul>


        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="row">
    <div class="col-sm-3 col-md-2 col-xs-2 sidebar">
        <ul class="nav nav-sidebar">

            <div class="well text-success ">
                <H3 class="active panel-body">Welcome Applicant</H3>
            </div>

            <li class="active">
                <a HREF="DashBoardMain_Applicant.jsp" >Profile</a>
            </li>
            <li>
                <a href="DashBoardMain_Applicant_Jobs_Applied.jsp">Job Applied</a>
            </li>


        </ul>



    </div>

    <div class="row">
    <div class=" col-lg-8 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


            <h1 class="white">Profile  </h1>

        <h6 class="white">Click to update</h6>




        <form class="form" id="updateform"  action="doappform" method="post" >
            <input name="appformtype" value="1" hidden>
            <table class="table well " id="update_table" onclick="update_applicant_info()">
                <thead class=" ">
                </thead>
                <tbody>
                <tr>


                    <td colspan="1"><label>First Name</label>
                        <input value="${requestScope.normaluser.fName}" type="text" name="updatefname" class="form-control " required autofocus/>
                    </td>
                    <td colspan="1"><label>Last Name</label>
                        <input value="${requestScope.normaluser.lName}" type="text" name="updatelname" class="form-control " required autofocus/>
                    </td>
                    <td colspan="1"><label>Email</label>
                        <input value="${requestScope.normaluser.userEmail}" type="email" name="updateemail" class="form-control " required autofocus/>
                    </td>
                </tr>
                <tr >

                    <td colspan="1"><label>Gender</label>
                        <select class="form-control" name="updategender">

                            <c:set var="gender" scope="request" value="${requestScope.normaluser.gender}"/>
                            <c:if test="${gender ==true}">
                                <option selected>Male</option>
                            </c:if>
                            <c:if test="${gender==false}">
                                <option selected>Female</option>
                            </c:if>


                        </select>
                    </td>
                    <td colspan="1"><label>Password</label>
                        <input type="password"  name="updatepassword" class="form-control " required autofocus/>
                    </td>
                    <td colspan="1"><label>Confirm Password</label>
                        <input type="password" name="updatepassword2" class="form-control " required autofocus/>
                    </td>
                </tr>
                <td colspan="2">
                    <label>Your 100 word description</label>
                    <textarea value="" type="text" rows="4" cols="3" maxlength="600\" name="updatedescription" class="form-control "  required autofocus>${requestScope.normaluser.descrp}</textarea> </td>



                <tr>

                    <td colspan="1"><label>Skill 1</label>
                        <input value="${requestScope.normaluser.skill1}" type="text"  name="signupskill1" class="form-control "  required autofocus>
                    </td>
                    <td colspan="1"><label>Years</label>
                        <select  class="form-control" name="updateyear1">
                            <option selected >${requestScope.normaluser.year1}</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5+</option>
                        </select>
                    </td>

                </tr>

                <tr>

                    <td colspan="1"><label>Skill 2</label>
                        <input type="text" value="${requestScope.normaluser.skill2}" name="updateskill2" class="form-control "  required autofocus>
                    </td>
                    <td colspan="1"><label>Years</label>
                        <select class="form-control" name="updateyear2">
                            <option selected >${requestScope.normaluser.year2}</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5+</option>
                        </select>
                    </td>

                </tr>
                <tr>

                    <td colspan="1"><label>Phone (optional)</label>
                        <input type="tel" value="${requestScope.normaluser.phone}"  name="updatetel" class="form-control "  autofocus>
                    </td>


                </tr>

                <tr>
                    <td colspan="2">
                        <button  class="btn-danger btn-lg btn-block " style="width: 25%"  id="updateformbutton" type="submit" >Update</button></td>
                </tr>

                </tbody>
            </table>

        </form>


    </div>
    </div>

    <c:set var="result" scope="request" value="${requestScope.result}"/>
    <c:if test="${result = true}">
        <div class="col-lg-6"> <div class="alert alert-success alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;
            </a> <strong>Applied !</strong></div> </div>
    </c:if>
    <c:if test="${result=false}">
        <div class="col-lg-6"> <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;
            </a> <strong>Already Applied !</strong> </div> </div>
    </c:if>


    <div class="row">

        <div id="jobs" class=" col-lg-10 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <H1 class="white text-center"> These are the Oppourtunities we have for you ! </H1>

            <table class="table table-bordered well table-scroll ">
                <thead class="navbar-inverse white">
                <div hidden>
                    <form action="doappform" method="post" id="applyforjob" >
                        <input name="appformtype" value="2">
                        <input name="jobid" value="-1">
                    </form>

                </div>
                <tr class="navbar-inverse ">
                    <th>Date</th>
                    <th> Job Description</th>
                    <th> Skill Set</th>
                    <th> Other Requirement</th>
                    <th>Apply </th>
                </tr>
                </thead>
                <tbody>



                <c:forEach items="${requestScope.joblist}" var="job">

                <tr id="${job.jId}row">

                    <td  class="date" >${job.sDate}</td>
                    <td class="wrap"> ${job.jJobdes}</td>
                    <td> ${job.jSkill}</td>
                    <td> ${job.other}</td>
                    <td class="button"><button onclick="btn_apply_job(this)" class="btn-success btn-lg btn-block" id="button${job.jId}">Yes!</button></td>
                </tr>
                </c:forEach>


                </tbody>
            </table>

        </div>
    </div>


</div>






<footer >
    <div class=" well-lg">

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
