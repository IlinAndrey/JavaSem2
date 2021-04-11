package PR16.Application.service;

import PR16.Application.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public AddressService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
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

    public List<Address> getAddresses() {
        return session.createQuery("select p from Address p", Address.class).list();
    }

    public List<Address> getAddress(UUID id) {
        return session.createQuery("select p from Address p where p.id ='" + id + "'", Address.class).list();
    }

    public void deletePosts(Address address) {
        session.beginTransaction();

        List<Address> query = session.createQuery("select p from Address p where p.id = '" + address.getId() + "'", Address.class).list();
        for (Address p : query) {
            session.delete(p);
        }

        session.getTransaction().commit();
    }

    public void deleteAddress(UUID id) {
        session.beginTransaction();

        Address t = session.load(Address.class, id);
        session.delete(t);

        session.getTransaction().commit();
    }
}
