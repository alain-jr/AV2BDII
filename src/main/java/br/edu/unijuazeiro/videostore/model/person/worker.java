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
public class worker {

    @Id // indica que CODE é o campo chave-primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_worker")
    @SequenceGenerator(sequenceName = "seq_worker", allocationSize = 1, initialValue = 1, name = "gen_worker")
    private Integer code;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    private Person person;

}
