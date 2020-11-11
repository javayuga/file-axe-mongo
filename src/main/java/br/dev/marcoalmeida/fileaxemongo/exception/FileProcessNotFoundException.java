package br.dev.marcoalmeida.fileaxemongo.exception;

public class FileProcessNotFoundException extends RuntimeException {
    public FileProcessNotFoundException(String message) {
        super(message);
    }
}
