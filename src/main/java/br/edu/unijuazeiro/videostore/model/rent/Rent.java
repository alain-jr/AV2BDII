package br.edu.unijuazeiro.videostore.model.rent;

import java.util.List;
//import br.edu.unijuazeiro.videostore.model.DVD.DVD;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gets and sets
@NoArgsConstructor // construtor sem argumentos
@Entity(name = "tb_order")
public class Rent {

    @Id // indica que CODE é o campo chave-primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_rent")
    @SequenceGenerator(sequenceName = "seq_rent", allocationSize = 1, initialValue = 1, name = "gen_rent")
    private Long code;

    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    //public void sumTotal() {
   //     total = 0.0;
   //     for (Item item : items) {
    //        try {
   //             total += item.getQuantity() * item.getDVD().getPrice();
    //        } catch (NullPointerException e) {
  // TODO: handle exception
    //        }
     //   }
  //  }

}