<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>

    <title>kabaddi</title>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Kabbadi</a>

        </div>
    </div>
</div>
<ul class="nav nav-tabs" id="tab" align="right">
    <li class="active"><a data-toggle="tab" href="#admin">Admin</a></li>
    <li class=""><a data-toggle="tab" href="#finance">Finance</a></li>
    <li class=""><a data-toggle="tab" href="#is">IS</a></li>

</ul>
<div class="container" position="relative">
    <div id="myTabContent" class="tab-content">
        <div id="admin" class="tab-pane fade in active">
            <div class="page-header" align="right">
                <a href="<@spring.url "/invoice/create"/>" class="btn btn-inverse">Add New</a>
                <button href="#" class="btn btn-inverse">Generate Report</button>
            </div>

            <table class="table table-bordered table-striped">
                <thead>
                <tr>
      <th></th>
                    <th>PO #</th>
                    <th>Invoice number</th>
                    <th>STPI Approval No/Date</th>
                    <th>Bond No</th>
                    <th>Bond Date</th>
                    <th>Amount as per STPI Approval</th>
                    <th>Location</th>

                </tr>
                </thead>
                <tbody style="word-wrap:break-word, break-word: hyphenate">
                <#list invoices as invoice>

                    <tr>
                        <td style="width: 130px"><span class="label" style="background-color:white"><a
                                href="#">EDIT</a></span> <span
                                class="label" style="background-color:white"> <a
                                href="#">VIEW DETAILS</a></span></td>
                        <td style="width: 130px">${invoice.invoiceNumber!}</td>
                        <td>${invoice.invoiceNumber}</td>
                        <td>${invoice.STPIApprovalNumberAndDate!}</td>
                        <td>${invoice.bondNumber!}</td>
                        <td>${invoice.bondDate!}</td>
                        <td>${invoice.amountSTPIApproval!}</td>
                        <td>${invoice.location!}</td>
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

</div>

</body>
</html>
