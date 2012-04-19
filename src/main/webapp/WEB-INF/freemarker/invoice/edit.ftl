<#import "/spring.ftl" as spring/>
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">
<!DOCTYPE html>
<html>
<head>
    <title>Add a new invoice | Kabbadi</title>
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


<div class="container" position="relative">
<h1>New Invoice</h1>
        <form action="<@spring.url '/invoice/save'/>" method="POST">

            <div class="row">
                <div class="span3">
                    <input name="id" type="hidden" value="${invoice.id!} "/>

                    <label for="purchaseOrderNumber">Purchase Order Number</label>
                    <input name="purchaseOrderNumber" value="${invoice.purchaseOrderNumber!}" />

                    <label for="invoiceNumber">Invoice number *</label>
                    <input name="invoiceNumber" required="true" value="${invoice.invoiceNumber!}"/>

                    <label for="STPIApprovalNumberAndDate">STPI Approval Number</label>
                    <input name="STPIApprovalNumberAndDate" value="${invoice.STPIApprovalNumberAndDate!}"/>

                    <label for="descriptionOfGoods">Description of Goods</label>
                    <input name="descriptionOfGoods" value="${invoice.descriptionOfGoods!}" />

                    <label for="currency">Currency</label>
                    <input name="currency" value="${invoice.currency!}" />

                    <label for="foreignCurrency">Foreign Currency</label>
                    <input name="foreignCurrency" value="${invoice.foreignCurrency!}" />

                    <label for="amountSTPIApproval">Amount STPI Approval</label>
                    <input name="amountSTPIApproval" value="${invoice.amountSTPIApproval!}" />


                    <label for="CIFValueInINR">CIF Value In INR</label>
                    <input name="CIFValueInINR" value="${invoice.CIFValueInINR!}" />

                </div>
                <div class="span3">

                    <label for="bondNumber">Bond Number</label>
                    <input name="bondNumber" value="${invoice.bondNumber!}" />

                    <label for="bondDate">Bond Date</label>
                    <input name="bondDate" type="date" value="${invoice.bondDate!}" />

                    <label for="billOfEntryNumber">Bill of Entry Number</label>
                    <input name="billOfEntryNumber" value="${invoice.billOfEntryNumber!}" />

                    <label for="billOfEntryDate">Bill of Entry Date</label>
                    <input name="billOfEntryDate" type="date" value="${invoice.billOfEntryDate!}" />

                    <label for="assessableValueInINR">Assessable Value In INR</label>
                    <input name="assessableValueInINR" value="${invoice.assessableValueInINR!}" />

                    <label for="dutyExempt">Duty Exempt</label>
                    <input name="dutyExempt" value="${invoice.dutyExempt!}" />


                    <label for="twentyFivePercentDF">25% DF</label>
                    <input name="twentyFivePercentDF" value="${invoice.twentyFivePercentDF!}" />

                    <label for="CGApprovedInINR">CG Approved In INR</label>
                    <input name="CGApprovedInINR" value="${invoice.CGApprovedInINR!}" />
                </div>
                <div class="span3">
                    <label for="dutyForgone">Duty Forgone</label>
                    <input name="dutyForgone" value="${invoice.dutyForgone!}" />

                    <label for="runningBalance">Running Balance</label>
                    <input name="runningBalance" value="${invoice.runningBalance!}" />

                    <label for="outrightPurchase">Outright Purchase</label>
                    <input name="outrightPurchase" value="${invoice.outrightPurchase!}" />

                    <label for="loanBasis">Loan Basis</label>
                    <input name="loanBasis" value="${invoice.loanBasis!}" />

                    <label for="freeOfCharge">Free Of Charge</label>
                    <input name="freeOfCharge" value="${invoice.freeOfCharge!}" />

                    <label for="status">Status</label>
                    <input name="status" value="${invoice.status!}" />

                    <label for="remarks">Remarks</label>
                    <input name="remarks" value="${invoice.remarks!}" />

                    <label for="location">Location</label>
                    <input name="location" value="${invoice.location!}" />
                </div>
                <div class="span3">
                    <h2>Finance Details</h2>

                    <label for="status">Date of Invoice</label>
                    <input name="financeDetails.dateOfInvoice" />
                    <label for="status">Supplier name and address</label>
                    <input name="financeDetails.supplierNameAndAddress" />
                    <label for="status">Opening purchase value as on April 01</label>
                    <input name="financeDetails.openingPurchaseValueAsOnApril01" />
                    <label for="status">Additions during the year</label>
                    <input name="financeDetails.additionsDuringTheYear" />
                    <label for="status">DeletionsDuringTheYear</label>
                    <input name="financeDetails.DeletionsDuringTheYear" />

                </div>

            </div>
            <br/>

            <input type="submit" value="Submit invoice" />
            <a href="<@spring.url '/invoice/list'/>"><input type="button" value="Cancel" /></a>
        </form>
</div>
</body>
</html>