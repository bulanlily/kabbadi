<!DOCTYPE html>
<html>
<head>
    <title>Add a new invoice | Kabbadi</title>
</head>
<body>
<p>New Invoice</p>
<div>
        <form action="create" method="POST">
            <label for="invoiceNumber">Invoice number</label>
            <input name="invoiceNumber" value="${invoice.invoiceNumber!}" />

            <label for="STPIApprovalNumberAndDate">STPI Approval Number</label>
            <input name="STPIApprovalNumberAndDate" value="${invoice.STPIApprovalNumberAndDate!}" />

            <label for="descriptionOfGoods">Description of Goods</label>
            <input name="descriptionOfGoods" value="${invoice.descriptionOfGoods!}" />
            
            <label for="currency">Currency</label>
            <input name="currency" value="${invoice.currency!}" />
            
            <label for="foreignCurrency">Foreign Currency</label>
            <input name="foreignCurrency" value="${invoice.foreignCurrency!}" />
            
            <label for="amountSTPIApproval">Amount STPI Approval</label>
            <input name="amountSTPIApproval" value="${invoice.amountSTPIApproval!}" />
            
            <label for="CIFValueInINR">CIF Value In INR</label>
            <input name="CIFValueInINR" value="${invoice.CIFValueInINR!}" />
            
            <label for="bondNumber">Bond Number</label>
            <input name="bondNumber" value="${invoice.bondNumber!}" />

            <label for="bondDate">Bond Date</label>
            <input name="bondDate" value="${invoice.bondDate!}" />

            <label for="billOfEntryNumber">Bill of Entry Number</label>
            <input name="billOfEntryNumber" value="${invoice.billOfEntryNumber!}" />

            <label for="billOfEntryDate">Bill of Entry Date</label>
            <input name="billOfEntryDate" value="${invoice.billOfEntryDate!}" />

            <label for="assessableValueInINR">Assessable Value In INR</label>
            <input name="assessableValueInINR" value="${invoice.assessableValueInINR!}" />

            <label for="dutyExempt">Duty Exempt</label>
            <input name="dutyExempt" value="${invoice.dutyExempt!}" />

            <label for="twentyFivePercentDF">25% DF</label>
            <input name="twentyFivePercentDF" value="${invoice.twentyFivePercentDF!}" />

            <label for="CGApprovedInINR">CG Approved In INR</label>
            <input name="CGApprovedInINR" value="${invoice.CGApprovedInINR!}" />

            <label for="dutyForgone">Duty Forgone</label>
            <input name="dutyForgone" value="${invoice.dutyForgone!}" />

            <label for="office">Office</label>
            <input name="office" value="${invoice.office!}" />

            <label for="letters">Letters</label>
            <input name="letters" value="${invoice.letters!}" />

            <label for="flags">Flags</label>
            <input name="flags" value="${invoice.flags!}" />

            <label for="status">Status</label>
            <input name="status" value="${invoice.status!}" />

            <label for="remarks">Remarks</label>
            <input name="remarks" value="${invoice.remarks!}" />

            <label for="purchaseOrderNumber">Purchase Order Number</label>
            <input name="purchaseOrderNumber" value="${invoice.purchaseOrderNumber!}" />

            <label for="location">Location</label>
            <input name="location" value="${invoice.location!}" />
                        

            <input type="submit" value="Submit invoice" />
        </form>
</div>
</body>
</html>