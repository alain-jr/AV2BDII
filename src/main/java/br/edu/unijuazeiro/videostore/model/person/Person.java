package br.edu.unijuazeiro.videostore.model.person;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gets and sets
@NoArgsConstructor // construtor sem argumentos
@AllArgsConstructor // construtor com todos argumentos com base nos atributos da classe
@Entity // indica que essa classe representa uma ENTIDADE
public class Person {

    @Id // indica que CODE é o campo chave-primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_person")
    @SequenceGenerator(sequenceName = "seq_person", allocationSize = 1, initialValue = 1, name = "gen_person")
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String Password;

    @Column(nullable = false)
    private Integer CPF;

    @Column(nullable = false)
    private Double Telephone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Address address;

}
