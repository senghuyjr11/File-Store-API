package com.example.filestoreapi.domain.fileapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAppRepository extends JpaRepository<FileApp, Long> {
}
