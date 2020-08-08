package ru.vadimio.FileManager.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vadimio.FileManager.entities.File;
import ru.vadimio.FileManager.service.FileService;

import java.security.Principal;
import java.util.List;

@Controller
public class FileController {

    private FileService fileService;

    @Autowired
    public void setFileService(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String showFiles(Model model, Principal principal){
        List<File> list = fileService.findAll();
        model.addAttribute("list", list);
        return "index";
    }

}
