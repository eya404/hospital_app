package net.aya.hospital_app;

import net.aya.hospital_app.entities.Patient;
import net.aya.hospital_app.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;
import java.util.List;

@SpringBootApplication

class HospitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalAppApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(PatientRepository patientRepository) {
        return arg -> {
            Patient p1 = new Patient(); //NoArgsConstructor
            p1.setNom( "Aya ");
            p1.setPrenom("LESTOUN");
            p1.setScore(100);
            p1.setMalade(false);
            p1.setDatenaissance(new Date());
            Patient p2 = new Patient(10, "hajar", "Ouiam", new Date(), 1200, false); //AllArgsConstructor
            Patient p3 = Patient.builder()
                    .nom ("Imane")
                    .datenaissance(new Date() )
                    .build();
            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);

            List<Patient> patients = patientRepository.findAll();
            patients.forEach(p->{
                System.out.println(p.toString());
            });


        };
    }
}
