package kabbadi.service;

import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import lombok.NoArgsConstructor;
import org.h2.util.StringUtils;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
    public Invoice findBy(String invoiceNumber) {
        return invoiceRepository.findBy(Invoice.INVOICE_NUMBER, invoiceNumber);
    }

    @Transactional
    public void saveOrUpdate(Invoice invoice) {
        invoiceRepository.saveOrUpdate(invoice);
    }

    @Transactional
    public List<Invoice> list() {
        return invoiceRepository.list();
    }

    @Transactional(readOnly = true)
    public Invoice get(Integer id) {
        return invoiceRepository.get(id);
    }

    @Transactional
    public Invoice findByPreviousBondNumber(String previousBondNumber) {
        return (StringUtils.isNullOrEmpty(previousBondNumber))
                ? null :
                (Invoice) invoiceRepository.scoped()
                        .add(Restrictions.like("bondNumber", previousBondNumber))
                        .addOrder(Order.desc("bondNumber"))
                        .setMaxResults(1)
                        .uniqueResult();
    }
}
