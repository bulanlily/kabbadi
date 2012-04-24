<!DOCTYPE html>
<html>
<head>
    <title>View an Invoice | Kabbadi</title>
    <link rel="javascript" href="/kabbadi/static/js/bootstrap.tab.js">
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
        .table th, .table td {
        padding: 3px;
        }
        th.name {
        width: 25%;
        }
        th.value {
        width: 75%;
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
    <h1>Invoice: ${invoice.invoiceNumber}</h1>
    <br>
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
            <td>Currency Value</td>
            <td>${invoice.foreignCurrency!}</td>

        </tr>
        <tr>
            <td>Amount STPI Approval</td>
            <td>${invoice.amountSTPIApproval!}</td>

        </tr>
        <tr>
            <td>CIF Value (INR)</td>
            <td>${invoice.CIFValueInINR!}</td>

        </tr>
        <tr>
            <td>Bond Number</td>
            <td>${invoice.bondNumber!}</td>

        </tr>
        <tr>
            <td>Bond Date</td>
            <td>${invoice.bond!}</td>

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
</body>
</html>