package tn.esprit.spring.services;

import tn.esprit.spring.entities.Evenement;
import tn.esprit.spring.entities.Internaute;
import tn.esprit.spring.entities.Ticket;
import tn.esprit.spring.entities.TrancheAge;

import java.time.LocalDate;
import java.util.List;

public interface IAppService {
    void test();
    Internaute ajouterInternaute (Internaute internaute) ;
    Evenement ajouterEvenement(Evenement evenement);
    void listeEvenementsParCategorie() ;
    List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute );
    Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax);
}
