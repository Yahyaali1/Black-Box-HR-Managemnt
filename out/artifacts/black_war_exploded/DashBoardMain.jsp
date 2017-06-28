<%@ page import="java.io.PrintWriter" %>
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
                <H3 class="active panel-body">Dashboard

                </H3>
            </div>

            <li class="active">
                <a HREF="dohrpostjob">Post Job</a>
            </li>
            <li>
                <a href="dohrjoblist">Job Listing</a>
            </li>


        </ul>



    </div>
    <div class=" col-lg-8 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 class="page-header white">Dashboard HR</h1>

        <form class="form" action="dohrfrom" method="post"  >
            <input name="formtype" value="5" hidden>
            <H3 class="white">Post A Job</H3>
            <table class="table well ">
                <thead class=" ">

                </thead>
                <tbody>
                <tr>

                    <td colspan="1"><label>Start Date</label>
                        <input type="date"  name="startdate" class="form-control "  placeholder="Start Date"
                               required autofocus>
                    </td>
                    <td colspan="1"><label>End Date</label>
                        <input type="date" name="enddate" class="form-control table long" placeholder="End Date" required autofocus>
                    </td>
                    <td colspan="1"><label>Job Title</label>
                        <input type="text" name="jobtitle" minlength="25" class="form-control table long" placeholder="Job Title" required autofocus>
                    </td>

                </tr>
                <tr >

                    <td colspan="2">
                        <label>Job Description</label>
                        <textarea type="text" rows="4" cols="3" name="descrp" minlength="50" class="form-control table_long"  required autofocus></textarea> </td>

                </tr>
                <tr>
                    <td colspan="2">
                        <label>Skill Description</label>
                        <textarea type="text" rows="4" cols="3" name="skillreq" minlength="10" class="form-control table_long"  required autofocus></textarea> </td>
                </tr>

                <tr>
                    <td colspan="1">
                        <label>Other</label>
                        <textarea type="text" rows="4" cols="3" name="otherreq" minlength="10" class="form-control table_long"   autofocus></textarea> </td>
                </tr>
                <tr>
                    <td colspan="2" class="button"><button type="submit" class="btn-primary btn-lg btn-block " style="width: 25%"  id="submit_form">Submit!</button></td>
                </tr>
                </tbody>
            </table>

        </form>


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
