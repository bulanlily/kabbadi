<#import "/application.ftl" as layout/>
<#import "/spring.ftl" as spring />
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">

<@layout.template 'Add/Edit Invoice' >

<h1>Add/Edit Invoice</h1>

<p>* indicates mandatory fields</p>
<br/>

<form action="<@spring.url '/invoice/save'/>" name="newInvoiceForm" id='newInvoiceForm' method="POST">
<input name="invoice_id" type="hidden" value="${invoice.invoice_id!} "/>

<div class="row">
    <div class="span3">
        <label for="invoiceNumber">Invoice number *</label>
        <input name="invoiceNumber" value="${invoice.invoiceNumber!}"/>
        <div class='error_div' id='newInvoiceForm_invoiceNumber_errorloc'></div>
    </div>
    <div class="span3">
        <label for="purchaseOrderNumber">Purchase Order Number</label>
        <input name="purchaseOrderNumber" value="${invoice.purchaseOrderNumber!}"/>
    </div>
    <div class="span3">

        <label for="locations">Location</label>
        <@spring.formSingleSelect "invoice.location", locations, ""/>

    </div>
    <div class="span3">
        <label for="descriptionOfGoods">Description of Goods</label>
        <input name="descriptionOfGoods" value="${invoice.descriptionOfGoods!}"/>

        <input name="role" type="hidden" id="redirectToTab"/>

    </div>
</div>
<div class="row">
    <div class="span3">
        <label for="foreignValue.amount">Invoice Amount</label>
        <input name="foreignValue.amount" value="${invoice.foreignValueDisplayAmount!}"/>

        <div class='error_div' id='newInvoiceForm_foreignValue.amount_errorloc'></div>
    </div>

    <div class="span3">
        <label for="currency">Currency</label>
        <input name="foreignValue.currency" value="${invoice.foreignCurrency!}"/>
    </div>

</div>
<br/>

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
            <label for="dateOfArrival">Date of Arrival (dd/mm/yyyy)</label>
            <input name="dateOfArrival" class="defaultDatepicker" value="${invoice.dateOfArrival!}"/>

            <div class='error_div' id='newInvoiceForm_dateOfArrival_errorloc'></div>
        </div>

    </div>
    <div class="row">
        <div class="span3">
            <label for="bondNumber">Bond Number</label>
            <input name="bondNumber" value="${invoice.bondNumber!}"/>
        </div>
        <div class="span3">
            <label for="bondDate">Bond Date (dd/mm/yyyy)</label>
            <input name="bondDate" class="defaultDatepicker"  value="${invoice.bondDate!}"/>

            <div class='error_div' id='newInvoiceForm_bondDate_errorloc'></div>
        </div>
    </div>
    <div class="row">
        <div class="span3">
            <label for="billOfEntryNumber">Bill of Entry Number</label>
            <input name="billOfEntryNumber" value="${invoice.billOfEntryNumber!}"/>
        </div>

        <div class="span3">
            <label for="billOfEntryDate">Bill of Entry Date (dd/mm/yyyy)</label>
            <input name="billOfEntryDate" class="defaultDatepicker" 
                   value="${invoice.billOfEntryDate!}"/>

            <div class='error_div' id='newInvoiceForm_billOfEntryDate_errorloc'></div>

        </div>
    </div>
    <div class="row">
        <div class="span3">
            <label for="amountSTPIApproval">Amount STPI Approval</label>
            <input name="amountSTPIApproval" value="${invoice.amountSTPIApproval!}"/>

            <div class='error_div' id='newInvoiceForm_amountSTPIApproval_errorloc'></div>
        </div>

        <div class="span3">
            <label for="assessableValueInINR">Assessable Value In INR</label>
            <input name="assessableValueInINR" value="${invoice.assessableValueInINR!}"/>

            <div class='error_div' id='newInvoiceForm_assessableValueInINR_errorloc'></div>
        </div>
    </div>
    <div class="row">
        <div class="span3">
            <label for="importType">Import Types</label>
            <select name="importType">
                <#list importTypes as importType>
                    <option value="${importType.toString()}" >${importType.getDescription()}</option>
                </#list>
            </select>
        </div>
        <div class="span3">
            <label for="CIFValueInINR">CIF Value In INR</label>
            <input name="CIFValueInINR" value="${invoice.CIFDisplayAmountInINR!}"/>
        </div>
        <div class="span3">

            <label for="cgApprovedInINR">Add CG Value (INR)</label>
            <input name="cgApprovedInINR" value="${invoice.cgApprovedInINR!}"/>

            <div class='error_div' id='newInvoiceForm_cgApprovedInINR_errorloc'></div>
        </div>
    </div>
    <div class="row">
        <div class="span3">
            <label for="dutyExempt">Duty Exempt</label>
            <input name="dutyExempt" value="${invoice.dutyExempt!}"/>

            <div class='error_div' id='newInvoiceForm_dutyExempt_errorloc'></div>
        </div>

        <div class="span3">
            <label for="twentyFivePercentDF">25% DF</label>
            <input name="twentyFivePercentDF" value="${invoice.twentyFivePercentDF!}"/>

            <div class='error_div' id='newInvoiceForm_twentyFivePercentDF_errorloc'></div>
        </div>

        <div class="span3">
            <label for="dutyForgone">Duty Foregone</label>
            <input name="dutyForgone" value="${invoice.dutyForgone!}"/>

            <div class='error_div' id='newInvoiceForm_dutyForgone_errorloc'></div>
        </div>
    </div>

    <div class="row">
        <div class="span3">
            <label for="runningBalance">Running Balance</label>
            <input name="runningBalance" value="${invoice.runningBalance!}"/>
            <p class="help-block hide" id="previous_matched_bond_number">
                <strong>Previous Bond#:</strong>
                <span id="previous_bond_number"></span>
                <a href="#" id="remove_previous_bond_number"> x</a>
                <span class="hide" id="previous_bond_value"></span>
            </p>
        </div>

        <div class="span3">
            <label for="status">Status</label>
            <input name="status" value="${invoice.status!}"/>
        </div>

        <div class="span3">
            <label for="remarks">Remarks</label>
            <input name="remarks" value="${invoice.remarks!}"/>
        </div>
    </div>
</div>

<div class="tab-pane" id="finance">
    <div class="row">
        <div class="span3">
            <label for="dateOfInvoice">Date of Invoice</label>
            <input name="dateOfInvoice" class="defaultDatepicker" value="${invoice.dateOfInvoice!}"/>

            <div class='error_div' id='newInvoiceForm_dateOfInvoice_errorloc'></div>
        </div>
        <div class="span3">

            <label for="supplierNameAndAddress">Supplier name and address</label>
            <input name="supplierNameAndAddress" value="${invoice.supplierNameAndAddress!}"/>

        </div>
        <div class="span3">
            <label for="groupOfAssets">Group of Assets</label>
            <select name="groupOfAssets" value="${invoice.groupOfAssets!}">
                <option value="Computer Equipments">Computer Equipments</option>
                <option value="Furniture and Fixtures">Furniture and Fixtures</option>
                <option value="Leasehold improvements">Leasehold improvements</option>
                <option value="Office Equipments">Office Equipments</option>
            </select>
        </div>

    </div>
    <div class="row">
        <div class="span3">
            <label for="quantity">Quantity</label>
            <input name="quantity" value="${invoice.quantity!}"/>

            <div class='error_div' id='newInvoiceForm_quantity_errorloc'></div>
        </div>

        <div class="span3">
            <label for="identificationNumber">Identification Number</label>
            <input name="identificationNumber" value="${invoice.identificationNumber!}"/>

        </div>
    </div>
    <div class="row">
        <div class="span3">
            <label for="openingPurchaseValueAsOnApril01">GB on April 01</label>
            <input name="openingPurchaseValueAsOnApril01" value="${invoice.openingPurchaseValueAsOnApril01!}"/>

            <div class='error_div' id='newInvoiceForm_openingPurchaseValueAsOnApril01_errorloc'></div>
        </div>

        <div class="span3">
            <label for="additionsDuringTheYear">Additions during the year</label>
            <input name="additionsDuringTheYear" value="${invoice.additionsDuringTheYear!}"/>

            <div class='error_div' id='newInvoiceForm_additionsDuringTheYear_errorloc'></div>
        </div>
        <div class="span3">
            <label for="deletionsDuringTheYear">Deletions during the year</label>
            <input name="deletionsDuringTheYear" value="${invoice.deletionsDuringTheYear!}"/>

            <div class='error_div' id='newInvoiceForm_deletionsDuringTheYear_errorloc'></div>
        </div>

    </div>
    <div class="row">
        <div class="span3">
            <label for="dateOfCommissioning">Date of Commissioning</label>
            <input name="dateOfCommissioning" class="defaultDatepicker" value="${invoice.dateOfCommissioning!}"/>

            <div class='error_div' id='newInvoiceForm_dateOfCommissioning_errorloc'></div>
        </div>
        <div class="span3">
            <label for="costCentre">Cost Centre</label>
            <input name="costCentre" value="${invoice.costCenter!}"/>
        </div>
    </div>
</div>
</div>
</div>
<br/>

<hr/>
<span class="span3">
    <input type="submit" name="submit" value="Submit invoice" class="btn btn-primary"/>
    <a id="cancelButton" href="<@spring.url '/invoice/list'/>"><input class="btn" type="button" value="Cancel" /></a>
</span>
<span class="alert alert-error span4 hide" id="form_errors_msg">
    <center>Submission failed. Check for invalid input messages.</center>
</span>
<br/>
<br/>
<hr/>

</form>

<script src="/kabbadi/static/js/invoice/edit.js" ></script>
<script>
    kabbadi.invoice.edit.initialize();
    $("#location").val("${invoice.location!}");
</script>
</@layout.template>
