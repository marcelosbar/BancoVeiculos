package br.com.marcelosbar.BancoDeVeiculos.controller.form;

import br.com.marcelosbar.BancoDeVeiculos.model.Veiculo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CadastrarVeiculoForm {
	private String id;
	private int tipo;
	private String nome;
	private Double latitude;
	private Double longitude;
	private Double velocidade;
	private Double rumo;

	public Veiculo converter() {
		return new Veiculo(id, tipo, nome, latitude, longitude, velocidade, rumo);
	}
	
}
