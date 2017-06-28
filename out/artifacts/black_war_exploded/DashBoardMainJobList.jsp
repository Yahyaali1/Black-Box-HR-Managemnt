<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@page import="classes.*" %>

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
                <H3 class="active panel-body">HR Dashboard</H3>
            </div>

            <li >
                <a HREF="dohrpostjob">Post Job</a>
            </li>
            <li class="active">
                <a href="dohrjoblist">Job Listing</a>
            </li>


        </ul>



    </div>


    <div class=" col-lg-4 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="col-lg-12">
            <h1 class="page-header white ">Job Listed</h1>
        </div>


            <H3 class="white">Ad's Responses</H3>
            <table class="table well ">
                <thead class=" ">

                </thead>
                <tbody>
                <tr>
                    <td colspan="1"><label>Select Job Posted</label>

                        <select class="form-control" id="jobslisted" onchange="onjobselection(this)" >
                            <option disabled selected>Please Select</option>
                            <c:forEach items="${requestScope.joblist}" var="job">
                            <option id="j_${job.jId}" value="${job.jId}">${job.sDate} ${job.jTitle}</option>
                            </c:forEach>
                        </select>
                    </td>

                    </td>

                </tr>
                </tbody>
                <div hidden>


                <form id="selectjob" method="post" action="dohrfrom">
                    <input name="formtype" value="1" >
                    <input type="text" name="jobid" value="" >

                </form>
                </div>
            </table>



    </div>

    <div class="row">
            <div class=" col-lg-12 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="white page-header">Applications</h1>

                <c:set var="er" scope="request" value="${requestScope.error}"/>
                <c:if test="${er%2== 0 && er!=0}">
                    <div class="col-lg-6 right">
                        <div class="alert alert-danger alert-dismissable fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;
                        </a> <strong>${requestScope.msg} </strong></div> </div>
                   </c:if>
                <c:if test="${er%2!= 0 && er!=0}">
                    <div class="col-lg-6 right">
                        <div class="alert alert-success alert-dismissable fade in">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;
                            </a> <strong>${requestScope.msg} </strong></div> </div>
                </c:if>
                <div class="col-lg-10">
                    <div class="alert">
                        <div id="notification">

                        </div>
                    </div>

                    <ul class="nav nav-tabs text-success">
                        <li class="active "><a data-toggle="tab" href="#newrequest">New</a></li>
                        <li><a data-toggle="tab" href="#markapplications">Marked SME </a>
                        <li><a data-toggle="tab" href="#final">Final Short Listing </a>
                    </ul>
                    <div class="tab-content">
                        <div id="newrequest" class="tab-pane fade in active">
                            <div class="col-lg-12 well">

                                <div >
                                    <table class="table table-hover well ">
                                        <div hidden>
                                            <form id="newapp" method="post" action="dohrfrom" >
                                                <input name="formtype" value="2">
                                                <input type="text" name="accept" value="">
                                                <input type="number" name="jobid" value="">
                                                <input type="number" name="smeid" value="">
                                                <input type="text" name="date" value="">
                                                <input type="number" name="time" value="">

                                            </form>
                                        </div>
                                        <thead class="navbar-default">
                                        <tr class="navbar-default">
                                            <th>Name</th>
                                            <th>Major Skill</th>
                                            <th>Minor Skill</th>
                                            <th>Cv Link</th>
                                            <th>SME</th>
                                            <th>Date</th>
                                            <th>Time (9am-5pm)</th>
                                            <th>Set</th>
                                            <th>Rem</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${requestScope.newApp}" var="newapp">


                                        <tr id="${newapp.appId}new">
                                            <td >${newapp.appName}</td>
                                            <td >${newapp.major}</td>
                                            <td>${newapp.minor}</td>
                                            <td><a href="doupload?fileName=${newapp.appCv}">CvLink</a></td>


                                            <td><select class="form-control" id="list${newapp.appId}" >
                                                <option id="1empty"></option>
                                            <c:forEach items="${requestScope.sme}" var="smelist">
                                                <option id="1sme1" value=${smelist.userId}>${smelist.fName} ${smelist.lName}</option>
                                            </c:forEach>
                                                </select> </td>
                                            <td><input type="date" class="form-control" id="timings${newapp.appId}" value="${newapp.dateSme}" ></input> </td>

                                            <td><input type="number" min="9" max="16"  class="form-control" id="day${newapp.appId}" value="${newapp.timeSme}"></input> </td>

                                            <c:set var="smeset" scope="request" value="${newapp.sme}"/>
                                            <c:if test="${smeset == false}">
                                            <td colspan="1" ><button id="buttontrue${newapp.appId}" class="btn-info btn-sm  btn-block" onclick="newapplication(true,this)" ><span class="white glyphicon glyphicon-ok"></span></button></td>
                                            <td colspan="1"><button id="buttonfalse${newapp.appId}" class="btn-warning btn-sm  btn-block" onclick="newapplication(false,this)" ><span class="white glyphicon glyphicon-remove"></span></button></td>
                                            </c:if>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                        <div id="markapplications" class="tab-pane fade in">
                            <div class="col-lg-12 well">

                                <div >
                                    <table class="table table-hover well ">
                                        <div hidden>
                                            <form id="newapp2" method="post" action="dohrfrom" >
                                                <input name="formtype" value="3">
                                                <input type="text" name="accept2" value="">
                                                <input type="number" name="jobid2" value="">
                                            </form>
                                        </div>
                                        <thead class="navbar-default">
                                        <tr class="navbar-default">
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Cv</th>
                                            <th>Tel</th>
                                            <th>Score</th>
                                            <th>To Manager</th>
                                            <th>Reject </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${requestScope.hrSmeTable}" var="smetable">
                                        <tr id="${smetable.appId}mark">

                                            <td >${smetable.appName}</td>
                                            <td >${smetable.email}</td>
                                            <td><a href="doupload?fileName=${smetable.appCv}">Cv Link</a></td>
                                            <td>${smetable.tel}</td>
                                            <td>${smetable.score1}</td>

                                            <c:set var="smemark" scope="request" value="${smetable.smeMark}"/>
                                            <c:if test="${smemark == true}">
                                            <td colspan="1" ><button id="forward${smetable.appId}"  class="btn-info btn-sm  btn-block" onclick="forwardtomanger(true,this)" ><span class="white glyphicon glyphicon-chevron-right"></span></button></td>
                                            <td colspan="1"><button id="pending${smetable.appId}"  class="btn-warning btn-sm  btn-block" onclick="forwardtomanger(false,this)" ><span class="white glyphicon glyphicon-remove"></span></button></td>
                                            </c:if>

                                        </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>

                            </div>

                        </div>
                        <div id="final" class="tab-pane fade">
                            <div class="col-lg-12 well">
                                <div >
                                    <table class="table table-hover well ">
                                       <div hidden>
                                        <form id="newapp3" method="post" action="dohrfrom" >
                                            <input name="formtype" value="4">
                                            <input type="text" name="accept3" value="">
                                            <input type="number" name="jobid3" value="">
                                        </form>
                                       </div>
                                        <thead class="navbar-default">
                                        <tr class="navbar-default">
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Tel</th>
                                            <th>Cv</th>
                                            <th>Score 1</th>
                                            <th>Score 2</th>
                                            <th>Salary</th>
                                            <th>Offer</th>
                                            <th>Reject </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${requestScope.hrFinalTable}" var="ftable">


                                        <tr id="${ftable.appId}final">
                                            <td >${ftable.appName}</td>
                                            <td colspan="1" >${ftable.email}</td>
                                            <td>${ftable.telF}</td>
                                            <td><a href="doupload?fileName=${ftable.appCv}">Cv</a></td>
                                            <td id="${ftable.appId}score0">${ftable.score1}</td>
                                            <td id="${ftable.appId}score1">${ftable.score2}</td>
                                            <td ><label>${ftable.salary}K</label></td>


                                            <c:set var="hrmmark"  value="${ftable.isOffer}"/>
                                            <c:set var="hrmcheck"  value="${ftable.isMark}"/>
                                            <c:if test="${hrmcheck==true && hrmmark==''}">

                                            <td colspan="1" ><button id="letter${ftable.appId}"  class="btn-info btn-sm  btn-block" onclick="offerletter(true,this)" ><span class="white glyphicon glyphicon-chevron-right"></span></button></td>
                                            <td colspan="1"><button id="reject${ftable.appId}"  style="width: 80%" class="btn-warning btn-sm  btn-block" onclick="offerletter(false,this)" ><span class="white glyphicon glyphicon-remove"></span></button></td>
                                            </c:if>
                                            <c:if test="${hrmmark == true}">
                                                <td colspan="1" >Offered</td>
                                                <td colspan="1" ></td>
                                            </c:if>


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






<footer>
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