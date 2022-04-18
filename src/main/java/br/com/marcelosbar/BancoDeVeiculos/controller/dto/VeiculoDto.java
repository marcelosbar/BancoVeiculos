package br.com.marcelosbar.BancoDeVeiculos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.marcelosbar.BancoDeVeiculos.model.Veiculo;
import lombok.Getter;

@Getter
public class VeiculoDto {

	private String id;
	private String nome;
	private Double latitude;
	private Double longitude;
	private Double velocidade;
	private Double rumo;

	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.nome = veiculo.getNome();
		this.latitude = veiculo.getLatitude();
		this.longitude = veiculo.getLongitude();
		this.velocidade = veiculo.getVelocidade();
		this.rumo = veiculo.getRumo();
	}

	public static List<VeiculoDto> converter(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());
	}

}
