package net.aya.hospital_app.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity @Table(name="PATIENTS")
@NoArgsConstructor @AllArgsConstructor @Getter
@Setter
@ToString @Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private Date datenaissance;
    private int score;
    private boolean malade;
}
