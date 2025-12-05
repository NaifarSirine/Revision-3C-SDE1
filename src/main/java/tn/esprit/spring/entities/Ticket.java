package tn.esprit.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTicket;
    String codeTicket;
    Double prixTicket;
    @Enumerated(EnumType.STRING)
    TypeTicket typeTicket;
    @ManyToOne(cascade = CascadeType.ALL)
    Internaute internaute;
    @ManyToOne
    Evenement evenement;
}
