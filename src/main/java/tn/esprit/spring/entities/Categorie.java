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
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategorie;
    String codeCategorie;
    String nomCategorie;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    List<Evenement> evenements;
}
