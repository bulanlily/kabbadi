<tr id="admin_invoice_${invoice.invoiceNumber}">
    <td>${i}</td>
    <td style="line-height:11px">${invoice.STPIApprovalNumberAndDate!}</td>
    <td class="description" style="line-height:11px">${invoice.descriptionOfGoods!}</td>
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
    <td>${invoice.getLoanBasis()!}</td>
    <td>${invoice.getFreeOfCharge()!}</td>
    <td>${invoice.cgApprovedInINR!}</td>
    <td>${invoice.dutyForegone!}</td>
    <td>${invoice.runningBalance()!}</td>
</tr>