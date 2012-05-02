<#import "/spring.ftl" as spring/>
<#setting number_format="computer">
<#setting datetime_format="dd/MM/yyyy">
<!DOCTYPE html>
<html>
<head>

<title>List Invoices | Kabbadi</title>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet">
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="/kabbadi/static/css/kabbadi.css" rel="stylesheet">
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/custom-tabs.js" type="text/javascript"></script>
</head>
<body>
<div class="tabable">
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="<@spring.url '/'/>">Kabbadi</a>

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
                    <th style="min-width: 40px">PO #</th>
                    <th>Invoice #</th>
                    <th>STPI Approval #/Date</th>
                    <th style="min-width:85px">STPI Approved Amount</th>
                    <th>Bond #</th>
                    <th>Bond Date</th>
                    <th>Location</th>
                    <th class="description">Description</th>
                    <th style="min-width: 90px"></th>

                </tr>
                </thead>
                <tbody style="word-wrap:break-word, break-word: hyphenate">
                <#list invoices as invoice>
                    <#if invoice.isBonded() >
                        <tr id="admin_invoice_${invoice.invoiceNumber}">
                            <td>${invoice.purchaseOrderNumber!}</td>
                            <td>${invoice.invoiceNumber}</td>
                            <td>${invoice.STPIApprovalNumberAndDate!}</td>
                            <td>${invoice.amountSTPIApproval!}</td>
                            <td>${invoice.bondNumber!}</td>
                            <td>${invoice.bondDate!}</td>
                            <td>${invoice.location!}</td>
                            <td class="description">${invoice.descriptionOfGoods!}</td>
                            <td>
                                <span class="btn btn-info btn-mini">
                                    <a href="edit/${invoice.invoice_id}">EDIT</a>
                                </span>
                                <span class="btn btn-info btn-mini">
                                    <a href="<@spring.url '/invoice/${invoice.invoice_id}'/>">VIEW</a>
                                </span>
                            </td>
                        </tr>
                    </#if>
                </#list>
                </tbody>
            </table>
        </div>
        <div id="finance" class="tab-pane fade">

        <div class="page-header" align="right">
                        <a href="<@spring.url "/invoice/create#finance"/>" class="btn btn-inverse" id="finance_add_invoice">Add New</a>
                        <button href="#" class="btn btn-inverse">Generate Report</button>
                    </div>

        <table class="table table-bordered table-striped">
            <thead>
                <tr>

                    <th style="min-width: 40px">PO #</th>
                    <th>Invoice #</th>
                    <th>Bond #</th>
                    <th>Bill of Entry #</th>
                    <th>Date of Invoice</th>
                    <th>Supplier name/address</th>
                    <th>GB (Apr 01)</th>
                    <th>Additions</th>
                    <th>Deletions</th>
                    <th>GB (Dec 31)</th>
                    <th>Location</th>
                    <th style="min-width: 90px"></th>
                </tr>
            </thead>
            <tbody style="word-wrap:break-word, break-word: hyphenate">
            <#list invoices as invoice>

                <tr id="finance_invoice_${invoice.invoiceNumber}">
                    <td>${invoice.purchaseOrderNumber!}</td>
                    <td>${invoice.invoiceNumber!}</td>
                    <td>${invoice.bondNumber!}</td>
                    <td>${invoice.billOfEntryNumber!}</td>
                    <td>${invoice.dateOfInvoice!}</td>
                    <td>${invoice.supplierNameAndAddress!}</td>
                    <td>${invoice.openingPurchaseValueAsOnApril01!}</td>
                    <td>${invoice.additionsDuringTheYear!}</td>
                    <td>${invoice.deletionsDuringTheYear!}</td>
                    <td>${invoice.gbOnDecember31()!}</td>
                    <td>${invoice.location!}</td>
                        <td>
                            <span class="btn btn-info btn-mini">
                                <a href="edit/${invoice.invoice_id}#finance">EDIT</a>
                            </span>
                            <span class="btn btn-info btn-mini">
                                <a href="<@spring.url '/invoice/${invoice.invoice_id}#finance'/>">VIEW</a>
                        </span>
                        </td>
                </tr>
            </#list>


            </tbody>
        </table>
        </div>
        <div id="is" class="tab-pane fade">
         <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th style="width:120px">Invoice #</th>
                <th>Asset #</th>
                <th>Location</th>
                <th>Status</th>
                <th>Is Leased</th>
                <th>Leasing Expiration</th>
                <th>Model Name</th>
                <th style="min-width: 90px"></th>
            </tr>
            </thead>
            <tbody style="word-wrap:break-word, break-word: hyphenate">
            <#list invoices as invoice>
                <tr id="is_invoice_${invoice.invoiceNumber}">
                    <td colspan="7" style="font-weight:bold;">${invoice.invoiceNumber}</td>
                    <td>
                        <span class="btn btn-info btn-mini">
                                <a href="<@spring.url '/invoice/${invoice.invoice_id}/asset/create'/>">&nbsp;&nbsp; Add Assets &nbsp;</a>
                        </span>
                    </td>
                </tr>
                <#list invoice.assets as asset>
                <tr id="asset_${asset.assetNumber!}">
                    <td></td>
                    <td>${asset.assetNumber!}</td>
                    <td>${invoice.location!}</td>
                    <td>${asset.status!}</td>
                    <#if asset.leased!>
                        <td>Yes</td>
                    <#else>
                        <td>No</td>
                    </#if>
                    <td>${asset.leasingExpiration!}</td>
                    <td>${asset.modelName!}</td>
                    <td>
                            <span class="btn btn-info btn-mini">
                                <a href="<@spring.url '/invoice/${invoice.invoice_id}/asset/${asset.assetNumber!}/edit'/>">EDIT</a>
                            </span>
                            <span class="btn btn-info btn-mini">
                                <a href="<@spring.url '/asset/${asset.assetNumber}'/>">VIEW</a>
                            </span>

                    </td>
                </tr>
                </#list>
            </#list>


            </tbody>
            </table>
        </div>
    </div>

</div>
</div>

</body>
</html>
