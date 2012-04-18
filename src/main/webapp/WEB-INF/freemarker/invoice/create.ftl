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
        <form action="create" method="POST">

            <div class="row">
                <div class="span3">
            <label for="purchaseOrderNumber">Purchase Order Number</label>
            <input name="purchaseOrderNumber"  />

            <label for="invoiceNumber">Invoice number *</label>
            <input name="invoiceNumber" required="true"/>

            <label for="STPIApprovalNumberAndDate">STPI Approval Number</label>
            <input name="STPIApprovalNumberAndDate" />

            <label for="descriptionOfGoods">Description of Goods</label>
            <input name="descriptionOfGoods" />
            
            <label for="currency">Currency</label>
            <input name="currency" />
            
            <label for="foreignCurrency">Foreign Currency</label>
            <input name="foreignCurrency" />
            
            <label for="amountSTPIApproval">Amount STPI Approval</label>
            <input name="amountSTPIApproval" />


            <label for="CIFValueInINR">CIF Value In INR</label>
            <input name="CIFValueInINR" />

                </div>
                <div class="span3">
            
            <label for="bondNumber">Bond Number</label>
            <input name="bondNumber" />

            <label for="bondDate">Bond Date</label>
            <input name="bondDate" type="date"/>

            <label for="billOfEntryNumber">Bill of Entry Number</label>
            <input name="billOfEntryNumber" />

            <label for="billOfEntryDate">Bill of Entry Date</label>
            <input name="billOfEntryDate" type="date" />

            <label for="assessableValueInINR">Assessable Value In INR</label>
            <input name="assessableValueInINR" />

            <label for="dutyExempt">Duty Exempt</label>
            <input name="dutyExempt"  />


            <label for="twentyFivePercentDF">25% DF</label>
            <input name="twentyFivePercentDF" />

            <label for="CGApprovedInINR">CG Approved In INR</label>
            <input name="CGApprovedInINR" />
                </div>
                <div class="span3">
            <label for="dutyForgone">Duty Forgone</label>
            <input name="dutyForgone" />

            <label for="runningBalance">Running Balance</label>
            <input name="runningBalance" />

            <label for="outrightPurchase">Outright Purchase</label>
            <input name="outrightPurchase" />

                        <div class="row">
                            <div class="span">
                                <label for="loanBasis">Loan Basis</label>
                                <input name="loanBasis" type="checkbox" />
                            </div>
                            <div class="span">
                                <label for="freeOfCharge">Free Of Charge</label>
                                <input name="freeOfCharge" type="checkbox" />
                            </div>

                        </div>

            <label for="status">Status</label>
            <input name="status" />

            <label for="remarks">Remarks</label>
            <input name="remarks" />

            <label for="location">Location</label>
            <input name="location" />
                </div>
            </div>
            <br/>

            <input type="submit" value="Submit invoice" />
            <a href="list"><input type="button" value="Cancel" /></a>
        </form>
</div>
</body>
</html>