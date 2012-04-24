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
    <h1>Invoice ${invoice.invoiceNumber}</h1>
    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>NAME</th>
            <th>VALUE</th>

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
            <td>STPI Approval Number</td>
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
            <td>Currency</td>
            <td>${invoice.currency!}</td>

        </tr>
        <tr>
            <td>Foreign Currency</td>
            <td>${invoice.foreignCurrency!}</td>

        </tr>
        <tr>
            <td>Amount STPI Approval</td>
            <td>${invoice.amountSTPIApproval!}</td>

        </tr>
        <tr>
            <td>CIF Value In INR</td>
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
            <td>Assessable Value In INR</td>
            <td>${invoice.assessableValueInINR!}</td>

        </tr>
        <tr>
            <td>Duty Exempt</td>
            <td>${invoice.dutyExempt!}</td>

        </tr>

        <tr>
            <td>25% DF</td>
            <td>${invoice.twentyFivePercentDF!}</td>

        </tr>

        <tr>
            <td>Outright Purchase</td>
            <td>${invoice.outrightPurchase!}</td>

        </tr>

        <tr>
            <td>Loan Basis</td>
            <td>${invoice.loanBasis!}</td>

        </tr>

        <tr>
            <td>Free Of Charge</td>
            <td>${invoice.freeOfCharge!}</td>

        </tr>

        <tr>
            <td>CG Approved In INR</td>
            <td>${invoice.CGApprovedInINR!}</td>

        </tr>

        <tr>
            <td>Duty Forgone</td>
            <td>${invoice.dutyForgone!}</td>

        </tr>


        <tr>
            <td>Running Balance</td>
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