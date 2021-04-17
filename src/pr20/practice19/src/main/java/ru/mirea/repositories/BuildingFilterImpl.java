package ru.mirea.repositories;

import org.springframework.stereotype.Component;
import ru.mirea.models.Address;
import ru.mirea.models.Building;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingFilterImpl implements BuildingFilter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Building> findBuildingsByAddressName(String groupName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Building> cq = cb.createQuery(Building.class);

        Root<Building> building = cq.from(Building.class);
        List<Predicate> predicates = new ArrayList<>();

        if (groupName != null) {
            predicates.add(cb.equal(building.get("group").get("groupName"), groupName));
        }
        cq.orderBy(cb.asc(building.get("lastName")));
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Building> findBuildingsByFirstNameAndLastName(String cDate, String lName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Building> cq = cb.createQuery(Building.class);

        Root<Building> building = cq.from(Building.class);
        List<Predicate> predicates = new ArrayList<>();

        if (cDate != null) {
            predicates.add(cb.equal(building.get("creationDate"), cDate));
        }
        if (lName != null) {
            predicates.add(cb.equal(building.get("lastName"), lName));
        }
        cq.orderBy(cb.asc(building.get("address").get("addressName")));
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

}
