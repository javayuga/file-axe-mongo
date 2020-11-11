package br.dev.marcoalmeida.fileaxemongo.controller;

import java.time.LocalDateTime;
import java.util.List;

import br.dev.marcoalmeida.fileaxemongo.entity.FileProcess;
import br.dev.marcoalmeida.fileaxemongo.exception.FileProcessNotFoundException;
import br.dev.marcoalmeida.fileaxemongo.repository.FileProcessRepository;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/fileaxe")
@Validated
class FileProcessController {

	private final static String NOT_FOUND = "could not find FileProcess with id %s";

	private final FileProcessRepository repository;

	FileProcessController(FileProcessRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/FileProcess")
	ResponseEntity<List<FileProcess>> findAll() {
		return ResponseEntity.ok(Lists.newArrayList(repository.findAll()));
	}

	@PostMapping("/FileProcess")
	ResponseEntity<?> newFileProcess(@RequestBody FileProcess fileProcess) {
		fileProcess.setCreated(LocalDateTime.now());
		return ResponseEntity.ok(repository.save(fileProcess));
	}

	@GetMapping("/FileProcess/{id}")
	ResponseEntity<FileProcess> findOne(@PathVariable String id) {
		return ResponseEntity.ok(repository.findById(id)
				.orElseThrow(() -> new FileProcessNotFoundException(String.format(NOT_FOUND,id))));
	}

	@PutMapping("/FileProcesss/{id}")
	ResponseEntity<?> updateFileProcess(@RequestBody FileProcess newFileProcess, @PathVariable String id) {
		return ResponseEntity.ok(
				repository.findById(id)
				.map(fileProcess -> {
					fileProcess.setFileName(newFileProcess.getFileName());
					return repository.save(fileProcess);
				})
				.orElseGet(() -> {
					newFileProcess.setId(id);
					return repository.save(newFileProcess);
				}));

	}

	@DeleteMapping("/FileProcesss/{id}")
	void deleteFileProcess(@PathVariable String id) {
		repository.deleteById(id);
	}

}
