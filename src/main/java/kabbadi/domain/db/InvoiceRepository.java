package kabbadi.domain.db;

import kabbadi.domain.Invoice;
import kabbadi.domain.Location;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class InvoiceRepository extends GenericRepository<Invoice> {

    @Autowired
    public InvoiceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Invoice.class);
    }

    public Invoice findInvoiceByPreviousBondNumberAndLocation(String previousBondNumber, Location location) {
        return (Invoice) scoped()
                .add(Restrictions.eq("location", location))
                .add(Restrictions.like("bondNumber", previousBondNumber))
                .addOrder(Order.desc("bondNumber"))
                .setMaxResults(1)
                .uniqueResult();
    }

    public List<Invoice> findAllMatchingInvoiceNumberAndLocation(String oldData, Location bangalore) {
        return null;
    }
}
