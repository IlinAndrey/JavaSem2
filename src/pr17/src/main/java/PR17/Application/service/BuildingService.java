package PR17.Application.service;

import PR17.Application.model.Address;
import PR17.Application.model.Building;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class BuildingService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    private CriteriaBuilder builder;
    private CriteriaQuery<Building> phoneCriteriaQuery;
    private Root<Building> root;

    public BuildingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        phoneCriteriaQuery = builder.createQuery(Building.class);
        root = phoneCriteriaQuery.from(Building.class);
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

    public List<Building> getBuilding() {
        return session.createQuery("select p from Building p", Building.class).list();
    }

    public Address getAddress(UUID id) {
        return session.createQuery("from Phone where id = :id", Building.class)
                .setParameter("id",id).getSingleResult().getAddress();
    }

    public void deletePhones(Building building) {
        session.beginTransaction();

        List<Building> query = session.createQuery("select p from Building p where p.id = '" + building.getId() + "'", Building.class).list();
        for (Building p : query) {
            session.delete(p);
        }

        session.getTransaction().commit();
    }

    public List<Building> getByType() {
        phoneCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Building> query = session.createQuery(phoneCriteriaQuery);
        return query.getResultList();
    }

    public List<Building> getByDate() {
        phoneCriteriaQuery.select(root).orderBy(builder.asc(root.get("creationYear")));
        Query<Building> query = session.createQuery(phoneCriteriaQuery);
        return query.getResultList();
    }

    public void deleteBuilding(UUID id) {
        session.beginTransaction();

        Building t = session.load(Building.class, id);
        session.delete(t);

        session.getTransaction().commit();
    }
//    public void delete(Phone phone) {
//        session.beginTransaction();
//
//        List<Phone> query = session.createQuery("select s from Phone where name = '" +
//                phone.getName() + "' and creationYear = '" + phone.getCreationYear() + "'", Phone.class).list();
//        for (Phone lvl: query){
//            session.delete(lvl);
//        }
//
//        session.getTransaction().commit();
//    }
}
