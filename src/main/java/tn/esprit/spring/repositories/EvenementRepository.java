package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
}
