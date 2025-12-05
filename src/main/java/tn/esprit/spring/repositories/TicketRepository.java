package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
