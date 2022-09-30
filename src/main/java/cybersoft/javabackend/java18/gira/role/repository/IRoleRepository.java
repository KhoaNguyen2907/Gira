package cybersoft.javabackend.java18.gira.role.repository;

import cybersoft.javabackend.java18.gira.role.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRoleRepository extends JpaRepository<RoleModel, UUID> {
    Optional<RoleModel> findByCode(String code);

    void deleteByCode(String code);

    Optional<RoleModel> findByName(String name);
}
