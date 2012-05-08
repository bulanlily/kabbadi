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
            "foreignValue",
            "amountSTPIApproval",
            "CIFValueInINR",
            "bondNumber",
            "bondDate",
            "billOfEntryNumber",
            "billOfEntryDate",
            "assessableValueInINR",
            "dutyExempt",
            "twentyFivePercentDF",
            "importType",
            "cgApprovedInINR",
            "dutyForgone",
            "location",
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
            "location","identificationNumber",
            "Type",
            "grossBlock",
            "openingPurchaseValueAsOnApril01,2011",
            "additionsDuringTheYear",
            "deletionsDuringTheYear",
            "totalPurchaseValueAsOnDecember31,2011",
            "openingBalanceAsOnApril01,2011",
            "rateOfDepreciation",
            "noOfDays",
            "depn-TillMar12",
            "deletions-TillMar12",
            "totalDepreciationAsOnMarch31,2012",
            "closingNetBlock",
            "openingNetBlock",
            "costCentre",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December",
            "January",
            "February",
            "March",
            "Total"
    };

    private static String
            adminCSV = "migration/All For Upload.csv";
    private static String financeCSV = "migration/financial datars.csv";
    
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
        sqlWriter.write("set datestyle to European;\n");
        sqlWriter.write(StringUtils.join(insertStatements, "\n"));
        sqlWriter.close();
        sqlOutput.close();
    }
}
