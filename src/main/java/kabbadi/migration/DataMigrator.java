package kabbadi.migration;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class DataMigrator {

    final static private String[] adminHeaders = new String[] {
            "invoiceNumber",
            "STPIApprovalNumberAndDate",
            "descriptionOfGoods",
            "currency",
            "foreignCurrency",
            "amountSTPIApproval",
            "CIFValueInINR",
            "bondNumber",
            "bondDate",
            "billOfEntryNumber",
            "billOfEntryDate",
            "assessableValueInINR",
            "dutyExempt",
            "twentyFivePercentDF",
            "outrightPurchase",
            "loanBasis",
            "freeOfCharge",
            "cgApprovedInINR",
            "dutyForgone",
            "runningBalance"
    };

    final static private String[] financeHeaders = new String[] {
            "dateOfInvoice",
            "invoiceNumber",
            "dateOfCommissioning",
            "supplierNameAndAddress",
            "groupOfAssets",
            "assetWiseBreakup",
            "quantity",
            "location",
            "identificationNumber",
            "grossBlock",
            "deletion(2001-12)",
            "totalPurchaseValueOn31-Mar-11",
            "rateOfDepreciation",
            "april-11",
            "may-11",
            "june-11",
            "july-11",
            "august-11",
            "september-11",
            "october-11",
            "november-11",
            "december-11",
            "january-12",
            "february-12",
            "march-12",
            "deletionsDuringTheYear",
            "totalDepreciation31-Mar-2012",
            "netBlock",
            "costCentre"
    };

    private static String adminCSV = "migration/KabbadiAdmin.csv";
    private static String financeCSV = "migration/KabbadiFinance.csv";
    
    public static void main(String[] argv) throws Exception {
        CSVReader csvAdminReader = new CSVReader(new FileReader(adminCSV));
        CSVReader csvFinanceReader = new CSVReader(new FileReader(financeCSV));
        
        List<String[]> adminEntries = csvAdminReader.readAll();
        List<String[]> financeEntries = csvFinanceReader.readAll();
        
        List<Map<String, String>> adminMappedEntries = new ColumnMapper(adminHeaders, adminEntries).mappedList();
        List<Map<String, String>> financeMappedEntries = new ColumnMapper(financeHeaders, financeEntries).mappedList();
        
        List<Map<String, String>>combinedEntries = new InvoiceCreator(adminMappedEntries, financeMappedEntries).createJoinEntry();
        
        List<String> insertStatements =  new SQLGenerator(combinedEntries).createInsertStatements();

        FileWriter sqlOutput = new FileWriter("src/main/resources/import_migrated_data.sql");
        BufferedWriter sqlWriter = new BufferedWriter(sqlOutput);
        sqlWriter.write(StringUtils.join(insertStatements, "\n"));
        sqlWriter.close();
        sqlOutput.close();
    }
}
