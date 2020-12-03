package br.edu.unijuazeiro.videostore.model.DVD;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class DVD {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_dvd")
    @SequenceGenerator(sequenceName = "seq_dvd", allocationSize = 1, 
        initialValue = 1, name = "gen_dvd")
    private Integer code;

    private String title;

    private String category;
    
    private Timestamp duration;

    private double price;

}
