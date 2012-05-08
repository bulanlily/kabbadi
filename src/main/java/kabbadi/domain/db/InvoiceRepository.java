package kabbadi.domain.db;

import kabbadi.domain.Invoice;
import kabbadi.domain.Location;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepository extends GenericRepository<Invoice> {

    public InvoiceRepository(SessionFactory sessionFactory, Class<Invoice> type) {
        super(sessionFactory, type);
    }

    public Invoice findInvoiceByPreviousInvoiceNumberAndLocation(String previousBondNumber, Location location) {
        return (Invoice) scoped()
                .add(Restrictions.eq("location", location))
                .add(Restrictions.like("bondNumber", previousBondNumber))
                .addOrder(Order.desc("bondNumber"))
                .setMaxResults(1)
                .uniqueResult();
    }
}
