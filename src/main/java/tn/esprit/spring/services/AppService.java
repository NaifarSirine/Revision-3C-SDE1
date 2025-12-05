package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.CategorieRepository;
import tn.esprit.spring.repositories.EvenementRepository;
import tn.esprit.spring.repositories.InternauteRespository;
import tn.esprit.spring.repositories.TicketRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AppService implements IAppService {

    InternauteRespository internauteRespository;
    EvenementRepository evenementRepository;
    CategorieRepository categorieRepository;
    TicketRepository ticketRepository;

    @Override
    public void test() {
        System.out.println("Hello from here !");
    }

    @Override
    public Internaute ajouterInternaute(Internaute internaute) {
        return internauteRespository.save(internaute);
    }

    @Override
    public Evenement ajouterEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void listeEvenementsParCategorie() {
        List<Categorie> categories = categorieRepository.findAll();
        for (Categorie cat : categories) {
            log.info("Categorie: " + cat.getNomCategorie());
            for (Evenement ev : cat.getEvenements()) {
                log.info("Evenement: " + ev.getNomEvenement() + " planifié le: " + ev.getDateEvenement());
            }
        }
    }

    @Override
    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute) {
        Evenement evenement = evenementRepository.findById(idEvenement).get();
        if (tickets.size() > evenement.getNbPlacesRestants()) {
            throw new java.lang.UnsupportedOperationException("nombre de places demandées indisponibe");
        } else {
            Internaute internaute = internauteRespository.findById(idInternaute).get();
            // Internaute (Child) -- Ticket (Parent) et Ticket n'appartient pas à la Bd -> Cascade possible
            for (Ticket t : tickets) {
                t.setInternaute(internaute);
                t.setEvenement(evenement);
                evenement.setNbPlacesRestants(evenement.getNbPlacesRestants() - 1);
            }
            // Evenement (Child) -- Ticket (Parent) et Ticket n'appartient pas à la Bd -> Cascade possible
            return ticketRepository.saveAll(tickets);
        }
    }

    @Override
    public Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax) {
        return internauteRespository.countDistinctByTrancheAgeAndTicketsEvenementDateEvenementBetween(trancheAge, dateMin, dateMax);
    }
}
