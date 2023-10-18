package com.example.h2repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface MDFileRepository extends CrudRepository<MDFile, Long> {
    List<MDFile> findByUpdateTime(ZonedDateTime updateTime);
}
