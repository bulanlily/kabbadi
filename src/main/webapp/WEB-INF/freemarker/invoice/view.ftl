<#import "/application.ftl" as layout />
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="###,###,##0.00">
<#import "/spring.ftl" as spring />


<@layout.template 'View an Invoice'>
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
                        <td>${invoice.foreignCurrency!}</td>

                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td>${invoice.foreignValueDisplayAmount!}</td>

                    </tr>
                        <td>CIF Value (INR)</td>
                            <td>${invoice.CIFDisplayAmountInINR!} </td>
                    </tr>
                    <tr>
                        <td>Import Type</td>
                        <td>  <#if invoice.importType??>${invoice.importType.description} </#if></td>
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
                        <td>CG Approved (INR)</td>
                        <td>${invoice.cgApprovedInINR!}</td>
                    </tr>

                    <tr>
                        <td>Duty Foregone (INR)</td>
                        <td>${invoice.dutyForgone!}</td>
                    </tr>


                    <tr>
                        <td>Running Balance (INR)</td>
                        <td>${invoice.runningBalance()!}</td>
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
</@layout.template>