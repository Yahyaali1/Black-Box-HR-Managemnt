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
 <h1 id="checking"></h1>
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
                <H3 class="active panel-body">Welcome HRM</H3>
            </div>
            <li class="active">
                <a href="DashBoardMain_SME_Mark.jsp">Mark Applicants </a>

            </li>


        </ul>



    </div>

    <div class="row">
        <div class=" col-lg-4 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="col-lg-12">
                <h1 class="page-header white ">Job Listed</h1>
            </div>

                <table class="table well ">
                    <thead class=" ">
                    </thead>
                    <tbody>
                    <tr>
                        <td colspan="1"><label>Select Job Posted</label>
                            <select class="form-control" id="jobslisted" name="list" onchange="onhrmlistchange(this)" >
                                <option disabled selected>Please Select</option>
                                <c:forEach items="${requestScope.joblist}" var="job">
                                    <option id="j_${job.jId}" value="${job.jId}">${job.sDate} ${job.jTitle}</option>
                                </c:forEach>
                            </select>
                        </td>

                    </tr>
                        <div hidden>
                            <form id="yahya" method="post" action="dohrmform">
                                <input type="number" name="hrmformtype" value="1">
                                <input type="number" name="jobid" value="">

                            </form>
                        </div>
                    </tbody>
                </table>



        </div>
    <div class=" col-lg-12 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 class="white">Applications</h1>
        <div class="col-lg-10">
            <ul class="nav nav-tabs text-success">
                <li class="active "><a data-toggle="tab" href="#markrequest">Mark Requests for ${requestScope.active.jTitle}</a></li>
            </ul>
            <div class="tab-content">
                <div id="markrequest" class="tab-pane fade in active">
                    <div class="col-lg-12 well">

                        <div >
                            <table class="table table-hover well ">
                                <thead class="navbar-default">
                                <div hidden>
                                    <form id="formplan" method="post" action="dohrmform">
                                        <input type="number" name="hrmformtype" value="2">
                                        <input type="number" name="statusid" value="">
                                        <input type="date" name="date" value="">
                                        <input type="number" name="time" value="">
                                    </form>
                                </div>
                                <tr class="navbar-default">
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Cv</th>
                                    <th>Score 1</th>
                                    <th>Score 2</th>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Plan</th>
                                    <th>Mark</th>
                                </tr>
                                </thead>
                                <tbody>
                                <td> <div class="modal fade" id="new1" role="dialog">
                                    <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Mark Candidate</h4>
                                            </div>
                                            <form class="form" id="hrmformmark" method="post" action="/dohrmform">
                                                <input hidden value="3" name="hrmformtype">
                                                <input hidden value="" name="jobid">
                                                <div class="modal-body" id="1modal">
                                                    <table class="table well ">
                                                        <thead class=" ">
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td colspan="1"><label>Communication Skills</label>
                                                                <input name="skill1" type="number" max="5" min="1" class="form-control"  placeholder="1-5" required autofocus>
                                                            </td>
                                                            <td colspan="1"><label>Coding Skills</label>
                                                                <input name="skill2" type="number" max="5" min="1" class="form-control"  placeholder="1-5" required autofocus>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="1"><label>Confidence</label>
                                                                <input name="skill3" type="number" max="5" min="1" class="form-control"  placeholder="1-5" required autofocus>
                                                            </td>
                                                            <td colspan="1"><label>Creative Thinking</label>
                                                                <input name="skill4" type="number" max="5" min="1" class="form-control"  placeholder="1-5" required autofocus>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="1"><label>Crtical Thinking</label>
                                                                <input name="skill5" type="number" max="5" min="1" class="form-control"  placeholder="1-5" required autofocus>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="1"><label>Salary Offered</label>
                                                                <input name="salary" type="text"  class="form-control"  placeholder="15k-100k" required autofocus>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" id="1form"  class="btn-default btn-lg btn-block" style="width: 25%" >Submit!</button>
                                                </div>
                                            </form>
                                        </div>

                                    </div>
                                </div></td>


            <c:forEach items="${requestScope.apphrlist}" var="app">
                                <tr id="${app.appId}hrm">
                                    <td >${app.appName}</td>
                                    <td >${app.email}</td>
                                    <td><a href="doupload?fileName=${app.appCv}">Cv </a></td>
                                    <td id="${app.appId}score0">${app.score1}</td>
                                    <td id="${app.appId}score1">-</td>
                                    <td><input type="date" class="form-control" id="timings${app.appId}" value="${app.dateHrm}">
                                    </input> </td>
                                    <td><input type="number" min="9" max="16"  class="form-control" id="day${app.appId}" value="${app.timeHrm}"  >
                                    </input> </td>
                                    <c:set var="plan" scope="request" value="${app.plan}"/>
                                    <td >
                                    <c:if test="${plan == false}">
                                    <button id="plan${app.appId}" class="btn-info btn-block" onclick="markhrm(this)" ><span class="white glyphicon glyphicon-ok"></span></button>
                                    </c:if>
                                    </td>
                                    <td >
                                    <c:if test="${plan == true}">
                                        <button class="btn-info btn-block" id="mark${app.appId}" onclick="displaysmemarksheethrm(this)"><span class="white glyphicon glyphicon-pencil"></span></button>
                                    </c:if>
                                    </td>
                                </tr>
            </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>

            </div>
        </div>





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
