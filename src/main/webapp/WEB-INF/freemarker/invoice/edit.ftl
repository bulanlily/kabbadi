<#import "/spring.ftl" as spring/>
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">
<!DOCTYPE html>
<html>
<head>
    <title>Add a new invoice | Kabbadi</title>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet" />
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/custom-tabs.js" type="text/javascript"></script>

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
<h1>New Invoice</h1>
<br />
        <form action="<@spring.url '/invoice/save'/>" method="POST">

            <div class="row">
                <div class="span3">
                    <input name="id" type="hidden" value="${invoice.id!} "/>

                    <label for="invoiceNumber">Invoice number *</label>
                    <input name="invoiceNumber" required="true" value="${invoice.invoiceNumber!}"/>

                    <label for="purchaseOrderNumber">Purchase Order Number</label>
                    <input name="purchaseOrderNumber" value="${invoice.purchaseOrderNumber!}" />

                    <label for="location">Location</label>
                    <input name="location" value="${invoice.location!}" />

                    <label for="descriptionOfGoods">Description of Goods</label>
                    <input name="descriptionOfGoods" value="${invoice.descriptionOfGoods!}" />

                </div>
            </div>
            <br />

            <div class="tabbable">
                <ul class="nav nav-tabs" id="tabs">
                    <li class="active"><a href="#admin" data-toggle="tab">Admin</a></li>
                    <li><a href="#finance" id="finance_tab" data-toggle="tab">Finance</a></li>
                </ul>

                <div class="tab-content">
                    <div class="tab-pane active" id="admin">
                        <div class="row">
                            <div class="span3">
                                <label for="STPIApprovalNumberAndDate">STPI Approval Number</label>
                                <input name="STPIApprovalNumberAndDate" value="${invoice.STPIApprovalNumberAndDate!}"/>
                            </div>

                            <div class="span3">
                                <label for="dateOfArrival">Date of Arrival</label>
                                <input name="dateOfArrival" value="${invoice.dateOfArrival!}"/>
                            </div>

                        </div>
                        <div class="row">
                            <div class="span3">
                                <label for="bondNumber">Bond Number</label>
                                <input name="bondNumber" value="${invoice.bondNumber!}" />
                            </div>
                            <div class="span3">
                                <label for="bondDate">Bond Date</label>
                                <input name="bondDate" type="date" value="${invoice.bondDate!}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="span3">
                                <label for="billOfEntryNumber">Bill of Entry Number</label>
                                <input name="billOfEntryNumber" value="${invoice.billOfEntryNumber!}" />
                            </div>

                            <div class="span3">
                                <label for="billOfEntryDate">Bill of Entry Date</label>
                                <input name="billOfEntryDate" type="date" value="${invoice.billOfEntryDate!}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="span3">
                                <label for="foreignCurrency">Foreign Currency</label>
                                <input name="foreignCurrency" value="${invoice.foreignCurrency!}" />
                            </div>

                            <div class="span3">
                                <label for="currency">Currency</label>
                                <input name="currency" value="${invoice.currency!}" />
                            </div>

                            <div class="span3">
                                <label for="amountSTPIApproval">Amount STPI Approval</label>
                                <input name="amountSTPIApproval" value="${invoice.amountSTPIApproval!}" />
                            </div>

                            <div class="span3">
                                <label for="assessableValueInINR">Assessable Value In INR</label>
                                <input name="assessableValueInINR" value="${invoice.assessableValueInINR!}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="span3">
                                <label for="CIFValueInINR">CIF Value In INR</label>
                                <input name="CIFValueInINR" value="${invoice.CIFValueInINR!}" />
                            </div>

                            <div class="span3">
                                <label for="CGApprovedInINR">CG Approved In INR</label>
                                <input name="CGApprovedInINR" value="${invoice.CGApprovedInINR!}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="span3">
                                <label for="dutyExempt">Duty Exempt</label>
                                <input name="dutyExempt" value="${invoice.dutyExempt!}" />
                            </div>

                            <div class="span3">
                                <label for="twentyFivePercentDF">25% DF</label>
                                <input name="twentyFivePercentDF" value="${invoice.twentyFivePercentDF!}" />
                            </div>

                            <div class="span3">
                                <label for="dutyForgone">Duty Foregone</label>
                                <input name="dutyForgone" value="${invoice.dutyForgone!}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="span3">
                                <label for="loanBasis">Loan Basis</label>
                                <input name="loanBasis" value="${invoice.loanBasis!}" />
                            </div>

                            <div class="span3">
                                <label for="outrightPurchase">Outright Purchase</label>
                                <input name="outrightPurchase" value="${invoice.outrightPurchase!}" />
                            </div>

                            <div class="span3">
                                <label for="freeOfCharge">Free Of Charge</label>
                                <input name="freeOfCharge" value="${invoice.freeOfCharge!}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="span3">
                                <label for="runningBalance">Running Balance</label>
                                <input name="runningBalance" value="${invoice.runningBalance!}" />
                            </div>

                            <div class="span3">
                                <label for="status">Status</label>
                                <input name="status" value="${invoice.status!}" />
                            </div>

                            <div class="span3">
                                <label for="remarks">Remarks</label>
                                <input name="remarks" value="${invoice.remarks!}" />
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="finance">
                            <div class="span3">
                                <label for="dateOfInvoice">Date of Invoice</label>
                                <input name="dateOfInvoice" value="${invoice.dateOfInvoice!}" />

                                <label for="supplierNameAndAddress">Supplier name and address</label>
                                <input name="supplierNameAndAddress" value="${invoice.supplierNameAndAddress!}" />

                                <label for="openingPurchaseValueAsOnApril01">Opening purchase value as on April 01</label>
                                <input name="openingPurchaseValueAsOnApril01" value="${invoice.openingPurchaseValueAsOnApril01!}" />

                                <label for="additionsDuringTheYear">Additions during the year</label>
                                <input name="additionsDuringTheYear" value="${invoice.additionsDuringTheYear!}" />

                            </div>
                            <div class="span3">

                                <label for="deletionsDuringTheYear">Deletions during the year</label>
                                <input name="deletionsDuringTheYear" value="${invoice.deletionsDuringTheYear!}" />

                                <label for="dateOfCommissioning">Date of Commissioning</label>
                                <input name="dateOfCommissioning" value="${invoice.dateOfCommissioning!}" />

                                <label for="groupOfAssets">Group of Assets</label>
                                <input name="groupOfAssets" value="${invoice.groupOfAssets!}" />

                                <label for="costCentre">Cost Centre</label>
                                <input name="costCentre" value="${invoice.costCenter!}" />

                                </div>
                            <div class="span3">

                                <label for="quantity">Quantity</label>
                                <input name="quantity" value="${invoice.quantity!}" />

                                <label for="identificationNumber">Identification Number</label>
                                <input name="identificationNumber" value="${invoice.identificationNumber!}" />

                                <label for="type">Type</label>
                                <input name="type" value="${invoice.type!}" />
                            </div>
                    </div>
                </div>
            </div>
            <br />

            <hr />
            <input type="submit" name="submit" value="Submit invoice" class="btn btn-primary" />
            <a href="<@spring.url '/invoice/list'/>"><input class="btn" type="button" value="Cancel" /></a>
            <br />
            <br />
            <p>* indicates mandatory fields</p>
            <hr />

        </form>
</div>
</body>
</html>