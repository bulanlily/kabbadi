package kabbadi.domain;

public class InvoiceUtils {

    public static final String ANYTHING = "%";

    public static String getPreviousBondNumber(String currentBondNumber) {

        try {
            String[] invoiceNumberAndYears = currentBondNumber.split("/");
            Integer previousInvoiceNumber = parsePreviousNumber(invoiceNumberAndYears[0]);

            String bondNumber = formatNumber(previousInvoiceNumber);
            String financeYear = invoiceNumberAndYears[1];

            if (isTheFirstInvoiceOfThisYear(previousInvoiceNumber)) {
                String newFinanceYear = financeYear.split("-")[0];

                int startingYear = parsePreviousNumber(newFinanceYear);
                financeYear = formatNumber(startingYear) + "-" + newFinanceYear;

                bondNumber = ANYTHING;
            }


            return String.format("%s/%s", bondNumber, financeYear);
        } catch (Exception ignored) {
            return "";
        }
    }

    private static String formatNumber(Integer previousInvoiceNumber) {
        return String.format("%02d", previousInvoiceNumber);
    }

    private static int parsePreviousNumber(String financeYears) {
        return Integer.parseInt(financeYears) - 1;
    }

    private static boolean isTheFirstInvoiceOfThisYear(Integer previousInvoiceNumber) {
        return previousInvoiceNumber <= 0;
    }
}
