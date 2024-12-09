package mx.edu.utez.gpdsautos.repository;


import mx.edu.utez.gpdsautos.model.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovilRepository extends JpaRepository<Automovil, Long> {
}
