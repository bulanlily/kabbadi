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
public class InvoiceService extends GenericService<Invoice>{

    @Autowired
    public InvoiceService(@Qualifier("repository") GenericRepository<Invoice> invoiceRepository) {
        super(invoiceRepository);
    }

    @Transactional
    public Invoice findByPreviousBondNumber(String previousBondNumber) {
        return (StringUtils.isNullOrEmpty(previousBondNumber))
                ? null :
                (Invoice) repository.scoped()
                        .add(Restrictions.like("bondNumber", previousBondNumber))
                        .addOrder(Order.desc("bondNumber"))
                        .setMaxResults(1)
                        .uniqueResult();
    }

    @Transactional
    public Invoice findBy(String invoiceNumber) {
        return repository.findBy(Invoice.INVOICE_NUMBER, invoiceNumber);
    }

    @Transactional
    public List<Invoice> findByLocation(String location){
        return repository.findAll("location", location);
    }
}
