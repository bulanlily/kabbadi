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

        <#list oldInvoiceList as invoice>
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

</@layout.template>