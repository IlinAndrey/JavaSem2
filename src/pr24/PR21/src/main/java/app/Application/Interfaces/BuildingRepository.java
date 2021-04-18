package app.Application.Interfaces;

import app.Application.Classes.Building;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository("BuildingRepository")
public interface BuildingRepository extends JpaRepository<Building,Long> {
    List<Building> findAllByType(String type);
    List<Building> findAllByCreationDate(LocalDateTime creationDate);

    @NotNull List<Building> findAll();
    void deleteById(UUID id);
}
