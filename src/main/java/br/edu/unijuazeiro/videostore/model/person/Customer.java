package br.edu.unijuazeiro.videostore.model.person;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gets and sets
@NoArgsConstructor // construtor sem argumentos
@AllArgsConstructor // construtor com todos argumentos com base nos atributos da classe
@Entity // indica que essa classe representa uma ENTIDADE
public class Customer {

    @Id // indica que CODE é o campo chave-primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_customer")
    @SequenceGenerator(sequenceName = "seq_customer", allocationSize = 1, initialValue = 1, name = "gen_customer")
    private Integer code;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    private Person person;

}
