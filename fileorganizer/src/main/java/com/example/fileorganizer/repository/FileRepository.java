package com.example.fileorganizer.repository;

import com.example.fileorganizer.model.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FileRepository extends JpaRepository<FileDocument, Long> {

    // ✅ Add this method
    List<FileDocument> findByTagsContainingIgnoreCase(String tag);
}


