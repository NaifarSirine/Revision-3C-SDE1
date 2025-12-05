package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Internaute;
import tn.esprit.spring.entities.TrancheAge;

import java.time.LocalDate;
import java.util.List;

public interface InternauteRespository extends JpaRepository<Internaute, Long> {
    long countDistinctByTrancheAgeAndTicketsEvenementDateEvenementBetween(TrancheAge trancheAge, LocalDate min, LocalDate max);
}
