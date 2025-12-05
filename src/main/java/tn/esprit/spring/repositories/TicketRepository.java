package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.Ticket;
import tn.esprit.spring.entities.TypeTicket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("select SUM(t.prixTicket) from Ticket t where t.evenement.nomEvenement=?2 and t.typeTicket=?1")
    Double montantRecupereParEvtEtTypeTicket(TypeTicket typeTicket, String nomEvent);
    int countByInternauteIdInternaute(Long idInternaute);

}
