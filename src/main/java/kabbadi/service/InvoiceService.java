package kabbadi.service;

import kabbadi.domain.Invoice;
import kabbadi.domain.User;
import kabbadi.domain.db.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {

    private GenericRepository<Invoice> invoiceRepository;

    @Deprecated
    public InvoiceService() {}

    @Autowired
    public InvoiceService(@Qualifier("invoiceRepository") GenericRepository<Invoice> invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice getInvoice(String invoiceNumber) {
        return invoiceRepository.findBy(Invoice.INVOICE_NUMBER_PROPERTY, invoiceNumber);
    }

    @Transactional
    public void addAndSave(Invoice invoice) {
                  invoiceRepository.save(invoice);
    }
}
