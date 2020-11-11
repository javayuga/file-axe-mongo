package br.dev.marcoalmeida.fileaxemongo.repository;

import br.dev.marcoalmeida.fileaxemongo.entity.FileProcess;
import org.springframework.data.repository.CrudRepository;

public interface FileProcessRepository extends CrudRepository<FileProcess, String> {
}
