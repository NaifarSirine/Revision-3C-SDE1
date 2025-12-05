package tn.esprit.spring.restcontrollers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.services.IAppService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class AppRestController {
    IAppService service;

    @GetMapping("test")
    void test() {
        service.test();
    }

    @PostMapping("ajouterInternaute")
    public Internaute ajouterInternaute(@RequestBody Internaute internaute) {
        return service.ajouterInternaute(internaute);
    }

    @PostMapping("ajouterEvenement")
    public Evenement ajouterEvenement(@RequestBody Evenement evenement) {
        return service.ajouterEvenement(evenement);
    }

    @GetMapping("nbInternauteParTrancheAgeEtDateEvenement")
    public Long nbInternauteParTrancheAgeEtDateEvenement(@RequestParam TrancheAge trancheAge, @RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd") LocalDate dateMin, @RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd") LocalDate dateMax) {
        return service.nbInternauteParTrancheAgeEtDateEvenement(trancheAge, dateMin, dateMax);
    }

    @PostMapping("ajouterTicketsEtAffecterAEvenementEtInternaute")
    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(@RequestBody List<Ticket> tickets, @RequestParam Long idEvenement, @RequestParam Long idInternaute) {
        return service.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets, idEvenement, idInternaute);
    }

    @GetMapping("montantRecupereParEvtEtTypeTicket")
    Double montantRecupereParEvtEtTypeTicket(@RequestParam String nomEvt, @RequestParam TypeTicket typeTicket) {
        return service.montantRecupereParEvtEtTypeTicket(nomEvt, typeTicket);
    }

    @GetMapping("internauteLePlusActif")
    String internauteLePlusActif(){
        return service.internauteLePlusActif();
    }
}
