package br.com.marcelosbar.BancoDeVeiculos.consumer;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.marcelosbar.BancoDeVeiculos.model.Veiculo;
import br.com.marcelosbar.BancoDeVeiculos.repository.VeiculosRepository;
import br.com.marcelosbar.RabbitMqLibrary.controller.dto.VeiculoDto;
import br.com.marcelosbar.RabbitMqLibrary.model.RabbitMqQueues;

@Component
public class VeiculoConsumer {

	@Autowired
	private VeiculosRepository veiculosRepository;

	@RabbitListener(queues = "AIRPLANES")
	private void consume(VeiculoDto veiculo) {
		Optional<Veiculo> optional = veiculosRepository.findById(veiculo.getId());
			
		if (optional.isEmpty()) {
			veiculosRepository.
			save(	new Veiculo(
					veiculo.getId(),
					RabbitMqQueues.AIRPLANES.getType(),
					veiculo.getNome(),
					veiculo.getLatitude(),
					veiculo.getLongitude(),
					veiculo.getVelocidade(),
					veiculo.getRumo()
					));
			
			return;
		} 
		
		Veiculo v = optional.get();
		v.setLatitude(veiculo.getLatitude());
		v.setLongitude(veiculo.getLongitude());
		v.setRumo(veiculo.getRumo());
		v.setVelocidade(veiculo.getVelocidade());
		if (v.getNome().isBlank())
			v.setNome(veiculo.getNome());
		
		veiculosRepository.save(v);
	}
}
