<#import "/application.ftl" as layout />
<#import "/invoice/utils.ftl" as utils />
<#import "/spring.ftl" as spring />
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">

<@layout.template 'List Invoices' >


    <script type="text/javascript">

        $(function () {
            $('input#admin_search').quicksearch('#admin table tbody tr');
            $('input#finance_search').quicksearch('#finance table tbody tr');
            $('input#is_search').quicksearch('#is table tbody tr');
        });
    </script>
<div class="tabbable">
    <ul class="nav nav-tabs" id="tab" align="right">
        <li class="active"><a data-toggle="tab" href="#admin">Admin</a></li>
        <li class=""><a data-toggle="tab" href="#finance">Finance</a></li>
        <li class=""><a data-toggle="tab" href="#is">IS</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div id="admin" class="tab-pane fade in active">
    <@utils.template 'admin'/>

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
                <#list invoices?sort_by("bondNumber")?reverse as invoice>
                    <#if invoice.isBonded() >
                        <tr id="admin_invoice_${invoice.invoiceNumber}">
                            <td>${invoice.purchaseOrderNumber!}</td>
                            <td>${invoice.invoiceNumber}</td>
                            <td>${invoice.STPIApprovalNumberAndDate!}</td>
                            <td>${invoice.amountSTPIApproval!}</td>
                            <td>${invoice.bondNumber!}</td>
                            <td>${invoice.bondDate!}</td>
                            <td>
                                <#if invoice.location??>
                                    ${invoice.location.getLocation()!}
                                </#if>

                            </td>
                            <td class="description">${invoice.descriptionOfGoods!}</td>
                            <td>
                                <span class="btn btn-info btn-mini">
                                    <a href="<@spring.url '/invoice/${invoice.invoice_id}/edit' />">EDIT</a>
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

            <@utils.template 'finance'/>


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
                    <td>${invoice.location.getLocation()!}</td>
                        <td>
                            <span class="btn btn-info btn-mini">
                                <a href="<@spring.url '/invoice/${invoice.invoice_id}/edit#finance' />">EDIT</a>
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
            <div class="page-header"  style="height:42px">"
                <form action="#" class="span3" align="left">
                    <input name="search" id="is_search" type="text" placeholder="Search...">
                    <span style="display: none;" class="loading">Loading...</span>
                </form>
            </div>


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
            <#if invoice.groupOfAssets! == "Computer Equipments">
                <tr id="is_invoice_${invoice.invoiceNumber}">
                    <td colspan="7" style="font-weight:bold;">${invoice.invoiceNumber}</td>
                    <td>
                        <span class="btn btn-info btn-mini" style="width:67px">
                                <a href="<@spring.url '/invoice/${invoice.invoice_id}/asset/create'/>" >Add Assets</a>
                        </span>
                    </td>
                </tr>
                <#list invoice.assets as asset>
                <tr id="asset_${asset.assetNumber!}">
                    <td>${invoice.invoiceNumber}</td>
                    <td>${"${asset.assetNumber!}"?left_pad(4,'0')}</td>
                    <td>${invoice.location.getLocation()!}</td>
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
                                <a href="<@spring.url '/invoice/${invoice.invoice_id}/asset/${asset.assetNumber}'/>">VIEW</a>
                            </span>

                    </td>
                </tr>
                </#list>
             </#if>
            </#list>


            </tbody>
            </table>
        </div>
    </div>

</div>
</@layout.template>
