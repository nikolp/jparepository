package com.example.h2repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
// @Table(name = "tutorials")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MDFile {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String mdId;
    // 	@Column(name = "file_name")
    String fileName;
    String contents;
    ZonedDateTime updateTime;
}
