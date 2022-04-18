package br.com.marcelosbar.BancoDeVeiculos.controller.form;

import br.com.marcelosbar.BancoDeVeiculos.controller.dto.VeiculoDto;
import br.com.marcelosbar.BancoDeVeiculos.model.Veiculo;
import br.com.marcelosbar.BancoDeVeiculos.repository.VeiculosRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarVeiculoForm {

	private String nome;
	private Double latitude;
	private Double longitude;
	private Double velocidade;
	private Double rumo;

	public VeiculoDto atualizar(String id, VeiculosRepository veiculosRepository) {

		Veiculo veiculo = veiculosRepository.getById(id);
		veiculo.setNome(nome);
		veiculo.setLatitude(latitude);
		veiculo.setLongitude(longitude);
		veiculo.setVelocidade(velocidade);
		veiculo.setRumo(rumo);
		return new VeiculoDto(veiculo);

	}

}
