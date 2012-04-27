<#import "/spring.ftl" as spring/>
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">
<!DOCTYPE html>
<html>
<head>
    <title>Add/Edit invoice | Kabbadi</title>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet"/>
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }

        .radio{
            display: inline-block;
        }
        .radio{
            margin-left: 10px;
        }

    </style>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/custom-tabs.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            var redirectTo = $("#redirectToTab");
            redirectTo.val((window.location.hash + "").replace("#", ""));

            $('a[data-toggle="tab"]').on('shown', function (e) {
                redirectTo.val($(e.target).attr("href").replace("#", ""));
            });
        });
    </script>

</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="<@spring.url '/invoice/list'/>">Kabbadi</a>

        </div>
    </div>
</div>




<div class="container" position="relative">
<h1>Add/Edit Asset of Invoice ${asset.invoice.invoiceNumber!}</h1>

<p>* indicates mandatory fields</p>
<br/>

    <hr/>
<#include "edit.ftl" >
</div>
</body>
</html>