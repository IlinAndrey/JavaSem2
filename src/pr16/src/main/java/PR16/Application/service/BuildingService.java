package PR16.Application.service;

import PR16.Application.model.Address;
import PR16.Application.model.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class BuildingService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public BuildingService(SessionFactory sessionFactory) {
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

    public void addBuilding(Building building) {
        session.beginTransaction();
        session.saveOrUpdate(building);
        session.getTransaction().commit();
    }

    public void addBuilding(UUID id, Address address) {
        session.beginTransaction();

        Building t = session.load(Building.class, id);
        t.addPost(address);
        session.saveOrUpdate(t);

        session.getTransaction().commit();
    }

    public void removeBuilding(UUID id, Address address) {
        session.beginTransaction();

        Building t = session.load(Building.class, id);
        t.removePost(address);
        session.saveOrUpdate(t);

        session.getTransaction().commit();
    }

    public List<Building> getBuilding() {
        return session.createQuery("select u from Building u", Building.class).list();
    }

    public Building getBuilding(UUID id) {
        return session.createQuery("select u from Building u where u.id = p.id = '" + id + "'", Building.class).getSingleResult();
    }

    public void deleteBuilding(UUID id) {
        session.beginTransaction();

        Building t = session.load(Building.class, id);
        session.delete(t);

        session.getTransaction().commit();
    }
}
