package com.example.h2repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MDFile {
    @Id
    Long id;
    String mdId;
    String fileName;
    String contents;
}
