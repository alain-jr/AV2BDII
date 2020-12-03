package br.edu.unijuazeiro.videostore.model.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_address")
    @SequenceGenerator(sequenceName = "seq_address", allocationSize = 1, initialValue = 1, name = "gen_address")
    private Integer code;

    private String street;

    private String number;

    private String city;

    private String neighborhood;

    private Double CEP;

}
