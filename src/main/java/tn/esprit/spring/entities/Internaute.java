package tn.esprit.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idInternaute;
    String identifiant;
    @Enumerated(EnumType.STRING)
    TrancheAge trancheAge;
    @OneToMany(mappedBy = "internaute")
    List<Ticket> tickets;
}
