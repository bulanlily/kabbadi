package kabbadi.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PreviousBondNumberConverter {

    private final String currentBondNumber;

    public PreviousBondNumberConverter(String currentBondNumber) {
        this.currentBondNumber = currentBondNumber;
    }

    public static final String ANYTHING = "%";

    public String getPreviousBondNumber() {

        try {
            String[] invoiceNumberAndYears = currentBondNumber.split("/");
            Integer previousInvoiceNumber = parsePreviousNumber(invoiceNumberAndYears[0]);

            String bondNumber = padNumberWithZero(previousInvoiceNumber);
            String financeYear = invoiceNumberAndYears[1];

            if (isTheFirstInvoiceOfThisYear(previousInvoiceNumber)) {
                String newFinanceYear = financeYear.split("-")[0];

                int startingYear = parsePreviousNumber(newFinanceYear);
                financeYear = padNumberWithZero(startingYear) + "-" + newFinanceYear;

                bondNumber = ANYTHING;
            }


            return String.format("%s/%s", bondNumber, financeYear);
        } catch (Exception ignored) {
            return "";
        }
    }

    private String padNumberWithZero(Integer previousInvoiceNumber) {
        return String.format("%02d", previousInvoiceNumber);
    }

    private int parsePreviousNumber(String financeYears) {
        return Integer.parseInt(financeYears) - 1;
    }

    private boolean isTheFirstInvoiceOfThisYear(Integer previousInvoiceNumber) {
        return previousInvoiceNumber <= 0;
    }


}
