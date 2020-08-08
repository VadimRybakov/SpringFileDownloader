package ru.vadimio.FileManager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vadimio.FileManager.entities.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
