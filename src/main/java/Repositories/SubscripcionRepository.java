package Repositories;

import Models.Subscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscripcionRepository extends JpaRepository<Subscripcion, UUID> {
}