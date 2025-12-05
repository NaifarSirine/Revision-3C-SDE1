package tn.esprit.spring.services;

import tn.esprit.spring.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IAppService {
    void test();
    Internaute ajouterInternaute (Internaute internaute) ;
    Evenement ajouterEvenement(Evenement evenement);
    void listeEvenementsParCategorie() ;
    List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute );
    Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax);
    Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket);
    String internauteLePlusActif();
}
