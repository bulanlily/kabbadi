package kabbadi.domain;

import kabbadi.service.InvoiceService;

import java.math.BigDecimal;

public class RunningBalanceUpdater {
    private final InvoiceService invoiceService;

    public RunningBalanceUpdater(InvoiceService invoiceService) {

        this.invoiceService = invoiceService;
    }

    public void updateSince(Invoice currentInvoice) {
        currentInvoice.setRunningBalance(calculatePreviousBalance(currentInvoice.getBondNumber(), currentInvoice.getLocation()));
    }

    private BigDecimal calculatePreviousBalance(String bondNumber, Location location) {
        String previousBondNumber = new PreviousBondNumberConverter(bondNumber).getPreviousBondNumber();
        Invoice previousInvoice = invoiceService.findByPreviousBondNumber(previousBondNumber, location);

        if (previousInvoice == null) {
            return new BigDecimal(0);
        }

        previousInvoice.setRunningBalance(
                calculatePreviousBalance(previousInvoice.getBondNumber(), previousInvoice.getLocation())
                        .subtract(previousInvoice.getAmountSTPIApproval())
                        .add(previousInvoice.getAdditionsDuringTheYear())
        );
        return previousInvoice.getRunningBalance();
    }


}
