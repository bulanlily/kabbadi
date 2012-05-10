package kabbadi.domain;

import com.sun.org.apache.xml.internal.utils.StringComparable;
import org.apache.commons.lang.ObjectUtils;
import org.h2.util.StringUtils;
import org.joda.time.DateTimeComparator;

import java.awt.datatransfer.StringSelection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SortableInvoiceList {
    private List<Invoice> invoices;

    public SortableInvoiceList(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> sortByInvoiceDate() {
        Collections.sort(invoices, new Comparator<Invoice>() {
            @Override
            public int compare(Invoice invoice, Invoice invoice1) {
                return DateTimeComparator.getInstance().compare(invoice1.getDateOfInvoice(), invoice.getDateOfInvoice());
            }
        });
        return invoices;
    }

    public List<Invoice> sortByBondNumber() {
        Collections.sort(invoices, new Comparator<Invoice>() {
            @Override
            public int compare(Invoice invoice, Invoice invoice1) {


                Pattern bondNumberRegex = Pattern.compile("(\\d+)/(\\d{2})-\\d{2}");
                Matcher matcher1, matcher2;
                try {
                    matcher1 = bondNumberRegex.matcher(invoice.getBondNumber());}
                catch (Exception e){
                    return 1;
                }
                try{
                    matcher2 = bondNumberRegex.matcher(invoice1.getBondNumber());
                }
                catch (Exception e) {
                    return -1;
                }
                try {
                if (Integer.parseInt(matcher1.group(2)) < Integer.parseInt(matcher2.group(2))) return -1;
                if (Integer.parseInt(matcher1.group(2)) > Integer.parseInt(matcher2.group(2))) return 1;

                if (Integer.parseInt(matcher1.group(1)) < Integer.parseInt(matcher2.group(1))) return -1;
                if (Integer.parseInt(matcher1.group(1)) > Integer.parseInt(matcher2.group(1))) return 1;}
                catch (Exception e) {}
                return 0;
                //return ObjectUtils.compare(invoice1.getBondNumber(), invoice.getBondNumber());
            }
        });
        return invoices;
    }
}
