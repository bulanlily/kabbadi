<#setting datetime_format="dd/MM/yyyy">
<!DOCTYPE html>
<html>
<head>
    <title>View an Invoice | Kabbadi</title>
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/custom-tabs.js" type="text/javascript"></script>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
        .table th, .table td {
        padding: 3px;
        }
        th.name {
        width: 20%;
        }
    </style>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">

</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Kabbadi</a>

        </div>
    </div>
</div>


<div class="container" position="relative">
    <h1>Invoice # ${invoice.invoiceNumber}</h1>
    <br>
    <div class="tabbable">
        <ul class="nav nav-tabs" id="tabs">
            <li class="active"><a href="#admin" data-toggle="tab">Admin</a></li>
            <li><a href="#finance" data-toggle="tab">Finance</a></li>
        </ul>

        <div class="tab-content">
            <div class="tab-pane active" id="admin">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="name">NAME</th>
                        <th class="value">VALUE</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Purchase Order Number</td>
                        <td>${invoice.purchaseOrderNumber!}</td>

                    </tr>
                    <tr>
                        <td>Invoice number</td>
                        <td>${invoice.invoiceNumber}</td>

                    </tr>
                    <tr>
                        <td>STPI Approval No/Date</td>
                        <td>${invoice.STPIApprovalNumberAndDate!}</td>
                    </tr>
                    <tr>
                        <td>STPI Approved Amount </td>
                        <td>${invoice.amountSTPIApproval!}</td>

                    </tr>
                    <tr>

                    <tr>
                        <td>Date of Arrival</td>
                        <td>${invoice.dateOfArrival!}</td>
                    </tr>

                    <tr>
                        <td>Description of Goods</td>
                        <td>${invoice.descriptionOfGoods!}</td>

                    </tr>

                    <tr>
                        <td>Currency Type</td>
                        <td>${invoice.currency!}</td>

                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td>${invoice.foreignCurrency!}</td>

                    </tr>
                        <td>CIF Value (INR)</td>
                        <td>${invoice.CIFDisplayAmountInINR!}</td>

                    </tr>
                    <tr>
                        <td>Bond Number</td>
                        <td>${invoice.bondNumber!}</td>

                    </tr>
                    <tr>
                        <td>Bond Date</td>
                        <td>${invoice.bondDate!}</td>

                    </tr>
                    <tr>
                        <td>Bill of Entry Number</td>
                        <td>${invoice.billOfEntryNumber!}</td>

                    </tr>
                    <tr>
                        <td>Bill of Entry Date</td>
                        <td>${invoice.billOfEntryDate!}</td>

                    </tr>
                    <tr>
                        <td>Assessable Value (INR)</td>
                        <td>${invoice.assessableValueInINR!}</td>

                    </tr>
                    <tr>
                        <td>Duty Exempt (INR)</td>
                        <td>${invoice.dutyExempt!}</td>

                    </tr>

                    <tr>
                        <td>25% DF (INR)</td>
                        <td>${invoice.twentyFivePercentDF!}</td>

                    </tr>

                    <tr>
                        <td>Outright Purchase (INR)</td>
                        <td>${invoice.outrightPurchase!}</td>

                    </tr>

                    <tr>
                        <td>Loan Basis (INR)</td>
                        <td>${invoice.loanBasis!}</td>

                    </tr>

                    <tr>
                        <td>Free Of Charge (INR)</td>
                        <td>${invoice.freeOfCharge!}</td>

                    </tr>

                    <tr>
                        <td>CG Approved (INR)</td>
                        <td>${invoice.CGApprovedInINR!}</td>

                    </tr>

                    <tr>
                        <td>Duty Forgone (INR)</td>
                        <td>${invoice.dutyForgone!}</td>

                    </tr>


                    <tr>
                        <td>Running Balance (INR)</td>
                        <td>${invoice.runningBalance!}</td>

                    </tr>


                    <tr>
                        <td>Location</td>
                        <td>${invoice.location!}</td>

                    </tr>


                    <tr>
                        <td>Status</td>
                        <td>${invoice.status!}</td>

                    </tr>


                    <tr>
                        <td>Remarks</td>
                        <td>${invoice.remarks!}</td>

                    </tr>


                    </tbody>
                </table>
            </div>
            <div class="tab-pane" id="finance">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="name">NAME</th>
                        <th class="value">VALUE</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Purchase Order Number</td>
                        <td>${invoice.purchaseOrderNumber!}</td>

                    </tr>
                    <tr>
                        <td>Invoice Number</td>
                        <td>${invoice.invoiceNumber}</td>

                    </tr>
                    <tr>
                        <td>Date of Invoice</td>
                        <td>${invoice.dateOfInvoice!}</td>
                    </tr>

                    <tr>
                        <td>Date of Commissioning</td>
                        <td>${invoice.dateOfCommissioning!}</td>
                    </tr>

                    <tr>
                        <td>Supplier Name & Address</td>
                        <td>${invoice.supplierNameAndAddress!}</td>
                    </tr>

                    <tr>
                        <td>Group of Assets</td>
                        <td>${invoice.groupOfAssets!}</td>
                    </tr>

                    <tr>
                        <td>Description of Goods</td>
                        <td>${invoice.descriptionOfGoods!}</td>

                    </tr>

                    <tr>
                        <td>Quantity</td>
                        <td>${invoice.quantity!}</td>
                    </tr>

                    <tr>
                        <td>Location</td>
                        <td>${invoice.location!}</td>

                    </tr>


                    <tr>
                        <td>Identification Number</td>
                        <td>${invoice.identificationNumber!}</td>

                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>${invoice.type!}</td>

                    </tr>
                    <tr>
                        <td>GB as on April 01. 2011</td>
                        <td>${invoice.openingPurchaseValueAsOnApril01!}</td>

                    </tr>
                    <tr>
                        <td>Additions During the Year</td>
                        <td>${invoice.additionsDuringTheYear!}</td>

                    </tr>
                    <tr>
                        <td>Deletions During the Year</td>
                        <td>${invoice.deletionsDuringTheYear!}</td>

                    </tr>
                    <tr>
                        <td>GB on December 31, 2011</td>
                        <td>${invoice.gbOnDecember31()!}</td>
                    </tr>
                    <tr>
                        <td>Cost Centre</td>
                        <td>${invoice.costCentre!}</td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
</body>
</html>