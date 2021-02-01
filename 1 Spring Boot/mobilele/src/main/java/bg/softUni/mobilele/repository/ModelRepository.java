package bg.softUni.mobilele.repository;

import bg.softUni.mobilele.model.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository <ModelEntity,Long> {
}