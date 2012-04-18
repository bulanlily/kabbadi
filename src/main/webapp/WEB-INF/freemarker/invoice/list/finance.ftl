<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <title>kabaddi</title>
    <link rel="javascript" href="/kabbadi/static/js/bootstrap.tab.js">
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
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
            <a class="brand" href="#">Kabbadi</a>

        </div>
    </div>
</div>
<ul class="nav nav-tabs" id="tab" align="right">
    <li class="active"><a data-toggle="tab" href="home.html">Admin</a></li>
    <li class="active"><a data-toggle="tab" href="home.html">Finance</a></li>
    <li class=""><a data-toggle="tab" href="home.html">IS</a></li>

</ul>


<div class="container" position="relative">
    <section id="gridCustomization">
        <div class="page-header" align="right">
            <a href="<@spring.url "/invoice/create" />" class="btn btn-inverse">Add New</a>
            <button href="#" class="btn btn-inverse">Generate Report</button>
        </div>

        <table class="table table-bordered table-striped">
            <thead>
            <tr>

                <th></th>
                <th>PO #</th>
                <th>Invoice number</th>
                <th>Date of Invoice</th>
                <th>Supplier name and address</th>
                <th>Opening purchase value as on April 01</th>
                <th>Additions During the year</th>
                <th>Deletion During the year</th>
                <th>Total purchase value as on December 31</th>
                <th>Total Depreciation</th>
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
                    <td style="width: 130px">${invoice.purchaseOrderNumber!}</td>
                    <td>${invoice.invoiceNumber!}</td>
                    <td>${invoice.dateOfInvoice!}</td>
                    <td>${invoice.supplierNameAndAddress!}</td>
                    <td>${invoice.openingPurchaseValueAsOnApril01!}</td>
                    <td>${invoice.additionsDuringTheYear!}</td>
                    <td>${invoice.deletionDuringTheYear!}</td>
                    <td>${invoice.totalPurchaseValueOnDecember31!}</td>
                    <td>${invoice.totalDepreciation!}</td>
                    <td>${invoice.location!}</td>
                </tr>
            </#list>


            </tbody>
        </table>
    </section>

</div>

<script src="http://platform.twitter.com/widgets.js" type="text/javascript"></script>
<script src="assets/js/jquery.js"></script>
<script src="assets/js/google-code-prettify/prettify.js"></script>
<script src="assets/js/bootstrap-transition.js"/>
<script src="assets/js/bootstrap-alert.js"/>
<script src="assets/js/bootstrap-modal.js"/>
<script src="assets/js/bootstrap-dropdown.js"/>
<script src="assets/js/bootstrap-scrollspy.js"/>
<script src="assets/js/bootstrap-tab.js"/>
<script src="assets/js/bootstrap-tooltip.js"/>
<script src="assets/js/bootstrap-popover.js"/>
<script src="assets/js/bootstrap-button.js"/>
<script src="assets/js/bootstrap-collapse.js"/>
<script src="assets/js/bootstrap-carousel.js"/>
<script src="assets/js/bootstrap-typeahead.js"/>
<script src="assets/js/application.js"/>

</body>
</html>
