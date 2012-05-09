<#import "/spring.ftl" as spring />
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">
<!DOCTYPE html>
<html>
<head>
    <title>View an Invoice | Kabbadi</title>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <link href="/kabbadi/static/css/kabbadi.css" rel="stylesheet"/>
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/jquery.datePicker.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-dropdown.js" type="text/javascript"></script>
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


<div class="container" position="relative" style="margin-left: 50px;">

    <div class="container">

        <p id="print-announce">
            <i>
                <strong style="color: #08C;">Please use browser to print report</strong>
                <small>( Menu > File > Print )</small>
            </i>
        </p>
        <table id="invoices" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th></th>
                <th>STPI Approval #/Date</th>
                <th>Description of Goods</th>
                <th>Currency</th>
                <th>Invoice Amount</th>
                <th>STPI Approved Amount</th>
                <th>CIF Value in INR</th>
                <th>Bond #</th>
                <th>Bond Date</th>
                <th>BOE Number</th>
                <th>BOE Date</th>
                <th>Assessable Value in INR</th>
                <th>Duty Exempt</th>
                <th>25% DF</th>
                <th>Outright Purchase</th>
                <th>Loan Basis</th>
                <th>Free of Charge</th>
                <th>CG Approved in INR</th>
                <th>Duty Forgone</th>
                <th>Running Balance</th>
            </tr>
            </thead>
            <tbody style="word-wrap:break-word, break-word: hyphenate">


            <#assign i = 0>
            <#list oldInvoiceList as invoice>
                <#assign i = i+1>
                <#include "reportData.ftl" />

            </#list>
            <#list newInvoiceList?sort_by("bondNumber") as invoice>
                <#if invoice.bondNumber != ''>
                    <#include "reportData.ftl" />
                </#if>
            </#list>
            <td>TOTAL</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>${sumCIF()!}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>${sumAssessable()!}</td>
            <td></td>
            <td></td>
            <td>${sumOP()}</td>
            <td>${sumLB()}</td>
            <td>${sumFC()}</td>
            <td>${sumCG()}</td>
            <td>${sumDF()}</td>
            <td></td>
            </tbody>
        </table>
    </div>
</div>
</body>

<#function sumCIF>
    <#local sumNum = 0>
        <#list oldInvoiceList as invoice>
            <#if invoice.CIFDisplayAmountInINR != ''>
                <#local sumNum= sumNum + invoice.CIFDisplayAmountInINR?number>
            </#if>
        </#list>
        <#list newInvoiceList as invoice>
            <#if invoice.CIFDisplayAmountInINR != ''>
                <#local sumNum= sumNum + invoice.CIFDisplayAmountInINR?number>
            </#if>
        </#list>
        <#return sumNum>
</#function>


<#function sumAssessable>
    <#local sumNum = 0>
        <#list oldInvoiceList as invoice>

            <#if (invoice.assessableValueInINR??)>
                <#local sumNum= sumNum + invoice.assessableValueInINR>
            </#if>
        </#list>
        <#list newInvoiceList as invoice>
            <#if (invoice.assessableValueInINR?? )>
                <#local sumNum= sumNum + invoice.assessableValueInINR>
            </#if>
        </#list>
        <#return sumNum>
</#function>

<#function sumOP>
    <#local sumNum = 0>
        <#list oldInvoiceList as invoice>

            <#if (invoice.outrightPurchase??)>
                <#local sumNum= sumNum + invoice.outrightPurchase>
            </#if>
        </#list>
        <#list newInvoiceList as invoice>
            <#if (invoice.outrightPurchase?? )>
                <#local sumNum= sumNum + invoice.outrightPurchase>
            </#if>
        </#list>
        <#return sumNum>
</#function>

<#function sumLB>
    <#local sumNum = 0>
        <#list oldInvoiceList as invoice>

            <#if (invoice.loanBasis??)>
                <#local sumNum= sumNum + invoice.loanBasis>
            </#if>
        </#list>
        <#list newInvoiceList as invoice>
            <#if (invoice.loanBasis?? )>
                <#local sumNum= sumNum + invoice.loanBasis>
            </#if>
        </#list>
        <#return sumNum>
</#function>

<#function sumFC>
    <#local sumNum = 0>
        <#list oldInvoiceList as invoice>

            <#if (invoice.freeOfCharge??)>
                <#local sumNum= sumNum + invoice.freeOfCharge>
            </#if>
        </#list>
        <#list newInvoiceList as invoice>
            <#if (invoice.freeOfCharge?? )>
                <#local sumNum= sumNum + invoice.freeOfCharge>
            </#if>
        </#list>
        <#return sumNum>
</#function>

<#function sumCG>
    <#local sumNum = 0>
        <#list oldInvoiceList as invoice>

            <#if (invoice.cgApprovedInINR??)>
                <#local sumNum= sumNum + invoice.cgApprovedInINR>
            </#if>
        </#list>
        <#list newInvoiceList as invoice>
            <#if (invoice.cgApprovedInINR?? )>
                <#local sumNum= sumNum + invoice.cgApprovedInINR>
            </#if>
        </#list>
        <#return sumNum>
</#function>

<#function sumDF>
    <#local sumNum = 0>
        <#list oldInvoiceList as invoice>

            <#if (invoice.dutyForegone??)>
                <#local sumNum= sumNum + invoice.dutyForegone>
            </#if>
        </#list>
        <#list newInvoiceList as invoice>
            <#if (invoice.dutyForegone?? )>
                <#local sumNum= sumNum + invoice.dutyForegone>
            </#if>
        </#list>
        <#return sumNum>
</#function>

</html>