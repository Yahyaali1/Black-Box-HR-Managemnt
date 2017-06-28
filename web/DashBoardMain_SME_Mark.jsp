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
                <H3 class="active panel-body">Welcome SME</H3>
            </div>

            <li>
                <a HREF="DashBoardMain_SME.jsp">Profile</a>
            </li>
            <li class="active">
                <a href="dosmeform">Mark Applicants</a>
            </li>


        </ul>



    </div>

    <div class="row">
    <div class=" col-lg-10 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 class="white">Applications</h1>

        <div class="col-lg-10">

            <ul class="nav nav-tabs text-success">
                <li class="active "><a data-toggle="tab" href="#newrequest">New Requests</a></li>
                <li><a data-toggle="tab" href="#markapplications">Mark Applicants </a>
            </ul>
            <div class="tab-content">
                <div id="newrequest" class="tab-pane fade in active">
                    <div class="col-lg-12 well">

                        <div >
                            <table class="table table-hover well ">
                                <div hidden>
                                    <form id="smeapplication" method="post" action="/dosmeform" >
                                        <input name="smeformtype" value="2">
                                        <input name="jobid" value="" type="number">
                                        <input name="status" value="" type="text">
                                    </form>
                                </div>
                                <thead class="navbar-default">

                                <tr class="navbar-default">
                                    <th>Candidate Name</th>
                                    <th>Job Description</th>
                                    <th>Cv Link</th>
                                    <th>Date/Time(9Am-5Pm)</th>
                                    <th>Accept</th>
                                    <th>Reject</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${requestScope.applists}" var="applistf">
                                <tr id="${applistf.appId}Mark">
                                    <td >${applistf.appName}</td>
                                    <td >${applistf.jd}</td>
                                    <td><a href="doupload?fileName=${applistf.appCv}">CvLink</a></td>
                                    <td>${applistf.dateSme}/${applistf.timeSme} </td>
                                    <td class="button"><button id="btn${applistf.appId}" class="btn-info  btn-block" onclick="on_mark_select(this,true)" ><span class="white glyphicon glyphicon-ok"></span></button></td>
                                    <td class="button"><button id="btnr${applistf.appId}" class="btn-warning  btn-block" onclick="on_mark_select(this,false)" ><span class="white glyphicon glyphicon-remove"></span></button></td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
                <div id="markapplications" class="tab-pane fade">
                    <div class="col-lg-12 well">

                        <div >
                            <table class="table table-hover well ">
                                <thead class="navbar-default">
                                <tr class="navbar-default">
                                    <th>Candidate Name</th>
                                    <th>Job Description</th>
                                    <th>Cv Link</th>
                                    <th>Date/Time(9:00Am-16:00Pm)</th>
                                    <th>Mark</th>

                                </tr>
                                </thead>
                                <tbody>
                                <td><div class="modal fade" id="new" role="dialog">
                                    <div class="modal-dialog">

                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Mark Candidate</h4>
                                            </div>
                                            <form class="form" id="1forms" action="/dosmeform" method="post">
                                                <input name="smeformtype" value="3" hidden>
                                                <input name="jobid" value="" hidden >
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
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit"  class="btn-default btn-lg btn-block"  style="width: 25%"  id="submit_form" >Submit!</button>
                                                </div>
                                            </form>
                                        </div>

                                    </div>
                                </div></td>

                                <c:forEach items="${requestScope.applistm}" var="applist">
                                <tr id="${applist.appId}">
                                    <td >${applist.appName}</td>
                                    <td >${applist.jd}</td>
                                    <td><a href="doupload?fileName=${applist.appCv}">New </a></td>
                                    <td>${applist.dateSme}/${applist.timeSme}</td>
                                    <td class="button"><button class="btn-info  btn-block" id="button${applist.appId}" onclick="displaysmemarksheet(this)"><span class="white glyphicon glyphicon-pencil"></span></button>
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
