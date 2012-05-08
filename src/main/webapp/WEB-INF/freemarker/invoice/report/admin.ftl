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
        </p>
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
        <#list oldInvoiceList as invoice>
                <#include "reportData.ftl" />
        </#list>
        <#list newInvoiceList?sort_by("bondNumber") as invoice>
                <#include "reportData.ftl" />
        </#list>
        </tbody>
    </table>
    </div>

</@layout.template>