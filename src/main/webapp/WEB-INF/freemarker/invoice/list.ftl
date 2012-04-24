<#import "/spring.ftl" as spring/>
<#setting number_format="computer">
<#setting datetime_format="dd/MM/yyyy">
<!DOCTYPE html>
<html>
<head>

<title>List Invoices | Kabbadi</title>
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
<div class="tabable">
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Kabbadi</a>

        </div>
    </div>
</div>
    <div class="container" position="relative">
    <ul class="nav nav-tabs" id="tab" align="right">
    <li class="active"><a data-toggle="tab" href="#admin">Admin</a></li>
    <li class=""><a data-toggle="tab" href="#finance">Finance</a></li>
    <li class=""><a data-toggle="tab" href="#is">IS</a></li>
</ul>
    <div id="myTabContent" class="tab-content">
        <div id="admin" class="tab-pane fade in active">
            <div class="page-header" align="right">
                <a href="<@spring.url "/invoice/create"/>" class="btn btn-inverse" id="admin_add_invoice">Add New</a>
                <button href="#" class="btn btn-inverse" id="admin_generate_report">Generate Report</button>
            </div>

            <table id="invoices" class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>PO #</th>
                    <th>Invoice number</th>
                    <th>STPI Approval No/Date</th>
                    <th>Bond No</th>
                    <th>Bond Date</th>
                    <th>Amount as per STPI Approval</th>
                    <th>Location</th>
                    <th>Description</th>
                    <th></th>

                </tr>
                </thead>
                <tbody style="word-wrap:break-word, break-word: hyphenate">
                <#list invoices as invoice>
                    <tr id="admin_invoice_${invoice.invoiceNumber}">
                        <td style="width: 130px">${invoice.purchaseOrderNumber!}</td>
                        <td>${invoice.invoiceNumber}</td>
                        <td>${invoice.STPIApprovalNumberAndDate!}</td>
                        <td>${invoice.bondNumber!}</td>
                        <td>${invoice.bondDate!}</td>
                        <td>${invoice.amountSTPIApproval!}</td>
                        <td>${invoice.location!}</td>
                        <td>${invoice.descriptionOfGoods!}</td>
                        <td style="width: 130px">
                            <span class="label" style="background-color:white">
                                <a href="edit/${invoice.id}">EDIT</a>
                            </span>
                            <span class="label" style="background-color:white">
                                <a href="<@spring.url '/invoice/${invoice.id}'/>">VIEW DETAILS</a>
                            </span>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div id="finance" class="tab-pane fade">

        <div class="page-header" align="right">
                        <a href="<@spring.url "/invoice/create"/>" class="btn btn-inverse">Add New</a>
                        <button href="#" class="btn btn-inverse">Generate Report</button>
                    </div>

                    <table class="table table-bordered table-striped">
                        <thead>
            <tr>

                <th>PO #</th>
                <th>Invoice number</th>
                <th>Bond No</th>
                <th>Bill of Entry No</th>
                <th>Date of Invoice</th>
                <th>Supplier name and address</th>
                <th>GB on Apr 01</th>
                <th>Additions during the year</th>
                <th>Deletions during the year</th>
                <th>GB on Dec 31</th>
                <th>Location</th>
                <th></th>
            </tr>
            </thead>
            <tbody style="word-wrap:break-word, break-word: hyphenate">
            <#list invoices as invoice>

                <tr id="finance_invoice_${invoice.invoiceNumber}">
                    <td style="width: 60px">${invoice.purchaseOrderNumber!}</td>
                    <td>${invoice.invoiceNumber!}</td>
                    <td>${invoice.bondNumber!}</td>
                    <td>${invoice.billOfEntryNumber!}</td>
                    <td>${invoice.dateOfInvoice!}</td>
                    <td>${invoice.supplierNameAndAddress!}</td>
                    <td>${invoice.openingPurchaseValueAsOnApril01!}</td>
                    <td>${invoice.additionsDuringTheYear!}</td>
                    <td>${invoice.deletionDuringTheYear!}</td>
                    <td>${invoice.totalPurchaseValue()!}</td>
                    <td>${invoice.location!}</td>
                        <td style="width: 80px">
                        <span class="label" style="background-color:white">
                            <a href="edit/${invoice.id}#finance">EDIT</a>
                        </span>
                        <span class="label" style="background-color:white">
                            <a href="#">VIEW</a>
                        </span>
                        </td>
                </tr>
            </#list>


            </tbody>
        </table>
        </div>
        <div id="is" class="tab-pane fade">
            <p>you can put your IS details here!!!</p>
        </div>
    </div>

</div>
</div>

</body>
</html>
