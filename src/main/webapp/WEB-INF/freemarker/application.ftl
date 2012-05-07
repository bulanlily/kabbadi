<#macro template title>
<!DOCTYPE html>
<html>
    <head>
        <title>${title} | Kabbadi</title>
        <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet"/>
        <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
              type="text/css"/>
        <link href="/kabbadi/static/css/kabbadi.css" rel="stylesheet" />
        <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
        <script src="/kabbadi/static/js/jquery.datePicker.js" type="text/javascript"></script>
        <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
        <script src="/kabbadi/static/js/custom-tabs.js" type="text/javascript"></script>
        <script src="/kabbadi/static/js/quicksearch.js" type="text/javascript"></script>
        <script src="/kabbadi/static/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>

        <style type="text/css">
            body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }

            div.error_div{
            color: #B94A48;
            margin-bottom:5px;
            }
        </style>

    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand" href="<@spring.url '/'/>">Kabbadi</a>

                </div>
            </div>
        </div>


        <div class="container" position="relative">
           <#nested/>
        </div>
    </body>
</html>


</#macro>