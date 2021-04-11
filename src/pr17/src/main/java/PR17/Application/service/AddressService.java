package PR17.Application.service;

import PR17.Application.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.query.Query;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Address> manufactureCriteriaQuery;
    private Root<Address> root;

    public AddressService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        manufactureCriteriaQuery = builder.createQuery(Address.class);
        root = manufactureCriteriaQuery.from(Address.class);
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void addAddress(Address address) {
        session.beginTransaction();
        session.saveOrUpdate(address);
        session.getTransaction().commit();
    }

    public List<Address> getAddress() {
        return session.createQuery("select u from Address u", Address.class).list();
    }

    public Address getAddress(UUID id) {
        return session.createQuery("select p from Address u where u.id = p.id = '" + id + "'", Address.class).getSingleResult();
    }
    public List<Address> getByName() {
        manufactureCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Address> query = session.createQuery(manufactureCriteriaQuery);
        return query.getResultList();
    }

    public List<Address> getByAddress() {
        manufactureCriteriaQuery.select(root).orderBy(builder.asc(root.get("address")));
        Query<Address> query = session.createQuery(manufactureCriteriaQuery);
        return query.getResultList();
    }
    public void deleteManufacture(UUID id) {
        session.beginTransaction();

        Address t = session.load(Address.class, id);
        session.delete(t);

        session.getTransaction().commit();
    }
}
