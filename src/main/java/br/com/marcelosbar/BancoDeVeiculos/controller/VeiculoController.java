package br.com.marcelosbar.BancoDeVeiculos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.marcelosbar.BancoDeVeiculos.controller.dto.VeiculoDto;
import br.com.marcelosbar.BancoDeVeiculos.controller.form.AtualizarVeiculoForm;
import br.com.marcelosbar.BancoDeVeiculos.controller.form.CadastrarVeiculoForm;
import br.com.marcelosbar.BancoDeVeiculos.model.Veiculo;
import br.com.marcelosbar.BancoDeVeiculos.repository.VeiculosRepository;

@RestController
@CrossOrigin
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculosRepository veiculosRepository;

	@GetMapping
	public List<VeiculoDto> listarVeiculos() {
		List<Veiculo> veiculos = veiculosRepository.findAll();
		return VeiculoDto.converter(veiculos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VeiculoDto> listarVeiculosPorId(@PathVariable String id) {
		Optional<Veiculo> optional = veiculosRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new VeiculoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastrarVeiculo(@RequestBody CadastrarVeiculoForm form,
			UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = form.converter();
		veiculosRepository.save(veiculo);

		URI uri = uriBuilder.path("topicos/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> atualizarVeiculo(@PathVariable String id,
			@RequestBody AtualizarVeiculoForm form) {
		Optional<Veiculo> optional = veiculosRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(form.atualizar(id, veiculosRepository));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarVeiculo(@PathVariable String id) {
		Optional<Veiculo> optional = veiculosRepository.findById(id);
		if (optional.isPresent()) {
			veiculosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/count")
	public long count() {
		return veiculosRepository.count();
	}

}
