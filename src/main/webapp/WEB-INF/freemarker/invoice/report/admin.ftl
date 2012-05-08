<#import "/application.ftl" as layout />
<#import "/spring.ftl" as spring />
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">
<@layout.template 'View an Invoice'>

    <div class="container">

        <p id="print-announce">
            <i>
                <strong style="color: #08C;">Please use browser to print report</strong> <small>( Menu > File > Print )</small>
            </i>
        git ad</p>
    <table id="invoices" class="table table-bordered table-striped">
        <thead>
        <tr>
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
            <th>Accesable Value in INR</th>
            <th>Duty Exempt</th>
            <th>25% DF</th>
            <th>Outright P</th>
            <th>Loan Basis</th>
            <th>Free of Charge</th>
            <th>CG Approved in INR</th>
            <th>Duty Forgone</th>
            <th>Running Balance</th>
        </tr>
        </thead>
        <tbody style="word-wrap:break-word, break-word: hyphenate">
        <#list invoiceList as invoice>
                <tr id="admin_invoice_${invoice.invoiceNumber}">
                    <td>${invoice.STPIApprovalNumberAndDate!}</td>
                    <td class="description">${invoice.descriptionOfGoods!}</td>
                    <td>${invoice.foreignCurrency!}</td>
                    <td>${invoice.foreignValueDisplayAmount!}</td>
                    <td>${invoice.amountSTPIApproval!}</td>
                    <td>${invoice.CIFDisplayAmountInINR!}</td>
                    <td>${invoice.bondNumber!}</td>
                    <td>${invoice.bondDate!}</td>
                    <td>${invoice.billOfEntryNumber!}</td>
                    <td>${invoice.billOfEntryDate!}</td>
                    <td>${invoice.assessableValueInINR!}</td>
                    <td>${invoice.dutyExempt!}</td>
                    <td></td>
                    <td>${invoice.outrightPurchase!}</td>
                    <td>${invoice.loanBasis!}</td>
                    <td>${invoice.freeOfCharge!}</td>
                    <td>${invoice.cgApprovedInINR!}</td>
                    <td>${invoice.dutyForgone!}</td>
                    <td>${invoice.runningBalance!}</td>
                </tr>
        </#list>
        </tbody>
    </table>
    </div>

    <script>
        $("#location").val("${invoice.location!}");
    </script>
</@layout.template>