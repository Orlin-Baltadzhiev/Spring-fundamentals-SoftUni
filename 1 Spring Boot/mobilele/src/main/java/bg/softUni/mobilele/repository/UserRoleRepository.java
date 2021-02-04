package bg.softUni.mobilele.repository;

import bg.softUni.mobilele.model.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

@Repository
public interface UserRoleRepository  extends JpaRepository <UserRoleEntity, Long> {
}
