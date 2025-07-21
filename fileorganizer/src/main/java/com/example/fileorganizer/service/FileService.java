package com.example.fileorganizer.service;

import com.example.fileorganizer.model.FileDocument;
import com.example.fileorganizer.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void storeFile(MultipartFile file, String tags) throws IOException {
        FileDocument doc = new FileDocument();
        doc.setFileName(file.getOriginalFilename());
        doc.setFileType(file.getContentType());
        doc.setTags(tags);
        doc.setData(file.getBytes());
        fileRepository.save(doc);
    }

    public List<FileDocument> getAllFiles() {
        return fileRepository.findAll();
    }

    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }

    public List<FileDocument> searchByTag(String tag) {
        return fileRepository.findByTagsContainingIgnoreCase(tag);
    }
}
