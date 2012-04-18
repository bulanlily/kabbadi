<!DOCTYPE html>
<html>
<head>
    <title>kabaddi</title>
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="static/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="static/js/jquery.js" type="text/javascript"></script>
    <script src="static/js/bootstrap-tab.js" type="text/javascript"></script>
</head>


<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="home.html"> KABBADI</a>

        </div>
    </div>
</div>


<ul class="nav nav-tabs" id="tab" align="right">
    <li class="active"><a data-toggle="tab" href="#admin">Admin</a></li>
    <li class=""><a data-toggle="tab" href="#finance">Finance</a></li>
    <li class=""><a data-toggle="tab" href="#is">IS</a></li>

</ul>


<div id="myTabContent" class="tab-content">

    <div id="admin" class="tab-pane fade in active">
        <div class="page-header" align="right">
            <button href="#" class="btn btn-inverse">Add New</button>
            <button href="#" class="btn btn-inverse">Generate Report</button>
        </div>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th></th>
                <th>First</th>
                <th>First</th>
                <th>First</th>
                <th>First</th>
                <th>First</th>
                <th>First</th>
                <th>First</th>
                <th>First</th>
            </tr>
            </thead>
            <tbody style="word-wrap:break-word, break-word: hyphenate">
            <#list invoices as invoice>
                <tr>
                    <td class="span2"><span class="label" style="background-color:white"><a
                            href="#">EDIT</a></span> <span
                            class="label" style="background-color:white"> <a
                            href="#">VIEW DETAILS</a></span></td>
                    <td style="width: 130px">${invoice}</td>
                    <td>Provides
                    </td>
                    <td>Provides</td>
                    <td>Provides</td>
                    <td>Provides</td>
                    <td>Provides</td>
                    <td>Provides</td>
                    <td>Provides</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <div id="finance" class="tab-pane fade">
        <p>you can put your finance details here!!!</p>
    </div>
    <div id="is" class="tab-pane fade">
        <p>you can put your IS details here!!!</p>
    </div>

</div>


</body>
</html>
