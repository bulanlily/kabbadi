package kabbadi.service;

import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class InvoiceService {

    private GenericRepository<Invoice> invoiceRepository;

    @Autowired
    public InvoiceService(@Qualifier("invoiceRepository") GenericRepository<Invoice> invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice findBy(String purchaseOrderNumber) {
        return invoiceRepository.findBy(Invoice.PURCHASE_ORDER_NUMBER, purchaseOrderNumber);
    }

    @Transactional
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Transactional
    public List<Invoice> list() {
        return invoiceRepository.list();
    }
}
