package com.example.fileorganizer.controller;

import com.example.fileorganizer.model.FileDocument;
import com.example.fileorganizer.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("tags") String tags,
                             Model model) {
        try {
            fileService.storeFile(file, tags);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "File upload failed: " + e.getMessage());
        }
        return "upload";
    }

    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        List<FileDocument> files = fileService.getAllFiles();
        model.addAttribute("files", files);
        return "dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/search")
    public String searchFiles(@RequestParam("tag") String tag, Model model) {
        List<FileDocument> files = fileService.searchByTag(tag);
        model.addAttribute("files", files);
        return "dashboard";
    }
}
