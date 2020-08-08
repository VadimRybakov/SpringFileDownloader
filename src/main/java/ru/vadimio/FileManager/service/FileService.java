package ru.vadimio.FileManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vadimio.FileManager.entities.File;
import ru.vadimio.FileManager.repository.FileRepository;

import java.util.List;

@Service
public class FileService {

    private FileRepository fileRepository;

    @Autowired
    public void setFileRepository(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public List<File> findAll() {
        return fileRepository.findAll();
    }
}
