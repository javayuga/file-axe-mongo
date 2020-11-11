package br.dev.marcoalmeida.fileaxemongo.service;

import br.dev.marcoalmeida.fileaxemongo.entity.FileProcess;
import br.dev.marcoalmeida.fileaxemongo.repository.FileProcessRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import br.dev.marcoalmeida.fileaxemongo.service.interfaces.FileAxeServiceFacade;

@Service
@Lazy
public class FileAxeService implements FileAxeServiceFacade{
    private FileProcessRepository fileProcessRepository;

    public FileAxeService(FileProcessRepository fileProcessRepository){
        this.fileProcessRepository = fileProcessRepository;
    }

    @Override
    public void createFileService(String fileName){
        FileProcess fp = new FileProcess();
        fp.setFileName(fileName);
        fileProcessRepository.save(fp);
    }
}
