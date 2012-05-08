package kabbadi.service;

import kabbadi.domain.Invoice;
import kabbadi.domain.InvoiceUtils;
import kabbadi.domain.Location;
import kabbadi.domain.db.InvoiceRepository;
import lombok.NoArgsConstructor;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@NoArgsConstructor
public class InvoiceService extends GenericService<Invoice> {

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        super(invoiceRepository);
    }

    @Transactional
    public Invoice findByPreviousBondNumber(String previousBondNumber, Location location) {
        return (StringUtils.isNullOrEmpty(previousBondNumber))
                ? null : ((InvoiceRepository) repository).findInvoiceByPreviousBondNumberAndLocation(previousBondNumber, location);
    }

    @Transactional
    public Invoice findBy(String invoiceNumber) {
        return repository.findBy(Invoice.INVOICE_NUMBER, invoiceNumber);
    }

    @Transactional
    public List<Invoice> findByLocation(Location location) {
        return repository.findAll("location", location);
    }

    @Transactional
    public List<Invoice> getInvoicesExcluding(String fieldName, String dataToExclude) {
        return repository.findAllNotEqualTo(fieldName, dataToExclude);
    }

    @Transactional
    public HashMap<String, List<Invoice>> getOldAndNewData(Location city) {
        List<Invoice> invoices = repository.findAll("location", city);
        return InvoiceUtils.separateOldAndNewData(invoices);
    }
}
