package com.example.fileorganizer.model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    private String tag;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;  // ✅ Use byte[] for binary file content

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }

    public byte[] getData() { return data; }
    public void setData(byte[] data) { this.data = data; }
}

