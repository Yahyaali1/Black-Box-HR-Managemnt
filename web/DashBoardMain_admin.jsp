<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
                <H3 class="active panel-body">Admin Dashboard</H3>
            </div>

            <li class="active" >
                <a HREF="DashBoardMain_admin.jsp">Admin</a>
            </li>


        </ul>



    </div>


    <div class=" col-lg-4 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

    </div>

    <div class="row">
            <div class=" col-lg-10 col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="white page-header">Manage Users</h1>
                <div class="col-lg-12">
                    <div class="alert">
                        <div id="notification">

                        </div>
                    </div>

                    <ul class="nav nav-tabs text-success">
                        <li class="active "><a data-toggle="tab" href="#users">Users</a></li>
                        <li><a data-toggle="tab" href="#newuser">Add User</a>

                    </ul>
                    <div class="tab-content">
                        <div id="users" class="tab-pane fade in active">
                            <div class="col-lg-10 well">
                                <div >
                                    <table class="table table-hover well ">
                                        <thead class="navbar-default">
                                        <tr class="navbar-default">
                                            <th>Email</th>
                                            <th>Password</th>
                                            <th>Type</th>
                                            <th>Edit</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <div hidden>
                                        <form id="adminchange" method="post" action="doadmin">
                                            <input name="adminformtype" value="1">
                                            <input name="email" type="email">
                                            <input name="pass" type="password">

                                        </form>

                                        <form id="admindelete" method="post" action="doadmin">
                                            <input name="adminformtype" value="2">
                                            <input name="email" type="email">

                                        </form>
                                        </div>

                                        <c:forEach items="${requestScope.userlist}" var="list">
                                        <tr id="row${list.userId}">
                                            <td> <input type="email" id="email${list.userId}" class="form-control table long" placeholder="email" value="${list.userEmail}" required autofocus disabled ></td>
                                            <td> <input type="text" id="pass${list.userId}" class="form-control table long" placeholder="email" value="${list.userPassword}" required autofocus disabled></td>
                                            <td>${list.userType}</td>
                                            <td colspan="1" ><button id="buttonedit${list.userId}" onclick="btn_edit(this)" class="btn-info btn-sm  btn-block" ><span class="white glyphicon glyphicon-edit"></span></button></td>
                                            <td colspan="1"><button disabled id="buttonupdate${list.userId}" onclick="btn_save(this)" class="btn-primary btn-sm  btn-block" ><span class="white glyphicon glyphicon-save"></span></button></td>
                                            <td colspan="1"><button id="buttondelete${list.userId}" onclick="btn_rem(this)" class="btn-danger btn-sm  btn-block" ><span class="white glyphicon glyphicon-remove"></span></button></td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                        <div id="newuser" class="tab-pane fade in">
                            <div class="col-lg-12 well">
                                <form class="form" method="post" action="doadmin">
                                    <input hidden name="adminformtype" value="3">
                                    <table class="table well ">
                                        <thead class=" ">
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td colspan="1"><label>Email</label>
                                                <input type="email"  name="email" class="form-control "  placeholder="Email"
                                                       required autofocus>
                                            </td>
                                            <td colspan="1"><label>Password</label>
                                                <input type="text" name="pass" class="form-control table long" placeholder="Password" required autofocus>
                                            </td>

                                            <td colspan="1">
                                                <label>Type</label>
                                                <select class="form-control" name="type" >
                                                    <option id="1" value="3">SME</option>
                                                    <option id="2" value="2">HR</option>
                                                    <option id="5" value="1">Admin</option>
                                                    <option id="6" value="4">HRM</option>
                                                </select>
                                            </td>


                                        </tr>

                                        <tr>

                                            <td></td>

                                            <td colspan="1" class="button"><button class="btn-primary btn-lg btn-block " style="width: 25%"  id="newuseradded">Add!</button></td>
                                        </tr>
                                        </tbody>
                                    </table>

                                </form>

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
