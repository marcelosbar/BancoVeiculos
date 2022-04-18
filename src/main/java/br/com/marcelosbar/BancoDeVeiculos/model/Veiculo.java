package br.com.marcelosbar.BancoDeVeiculos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "veiculos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

	@Id
	@Column(unique = true)
	private String id;
	private int tipo;
	@Setter
	private String nome;
	@Setter
	private Double latitude;
	@Setter
	private Double longitude;
	@Setter
	private Double velocidade;
	@Setter
	private Double rumo;

}
