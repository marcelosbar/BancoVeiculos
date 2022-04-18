package br.com.marcelosbar.BancoDeVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcelosbar.BancoDeVeiculos.model.Veiculo;

public interface VeiculosRepository extends JpaRepository<Veiculo, String> {

	
	
}
