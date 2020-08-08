package ru.vadimio.FileManager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vadimio.FileManager.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Short> {
    <T> T findOneByName(String role_user);
}
