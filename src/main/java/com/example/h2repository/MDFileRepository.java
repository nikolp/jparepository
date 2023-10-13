package com.example.h2repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MDFileRepository extends CrudRepository<MDFile, Long> {

}
