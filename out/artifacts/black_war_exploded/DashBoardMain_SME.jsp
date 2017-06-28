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
                <H3 class="active panel-body">Welcome SME</H3>
            </div>

            <li class="active">
                <a HREF="DashBoardMain_SME.jsp">Profile</a>
            </li>
            <li>
                <a href="DashBoardMain_SME_Mark.jsp">Mark Applicants</a>
            </li>


        </ul>



    </div>

    <div class="row">
    <div class=" col-lg-8 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="white">Profile SME</h1>


        <form class="form" id="updateformsme" action="/dosmeform" method="post" >
            <input name="smeformtype" value="1" hidden>
            <table class="table well " id="update_table" onclick="update_applicant_info()">
                <thead class=" ">
                </thead>
                <tbody>
                <tr>

                    <td colspan="1"><label>First Name</label>
                        <input value="Yahya" type="text"  name="updatefname" class="form-control " required autofocus/>
                    </td>
                    <td colspan="1"><label>Last Name</label>
                        <input type="text" name="updatelname" class="form-control " required autofocus/>
                    </td>
                    <td colspan="1"><label>Email</label>
                        <input type="email" name="updateemail" class="form-control " required autofocus/>
                    </td>
                </tr>

                <tr>
                    <td colspan="1"><label>Prefered Timings 1</label>
                        <select class="form-control" name="updattimings1">
                            <option class="1">9:00-10:00 (AM)</option>
                            <option class="2">10:00-11:00 (AM)</option>
                            <option class="3">1:00-2:00 (PM)</option>
                            <option class="4">2:00-3:00 (PM)</option>
                            <option class="5">4:00-5:00 (pM)</option>
                        </select>

                    <td colspan="1"><label>Prefered Timings 2</label>
                        <select class="form-control" name="updatetimings2">
                            <option class="1">9:00-10:00 (AM)</option>
                            <option class="2">10:00-11:00 (AM)</option>
                            <option class="3">1:00-2:00 (PM)</option>
                            <option class="4">2:00-3:00 (PM)</option>
                            <option class="5">4:00-5:00 (pM)</option>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td colspan="2">
                        <button disabled=true class="btn-danger btn-lg btn-block " style="width: 25%"  id="updateformbutton" type="submit" >Update</button></td>
                </tr>

                </tbody>
            </table>

        </form>


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
