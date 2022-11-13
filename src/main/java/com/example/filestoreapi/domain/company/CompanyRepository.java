package com.example.filestoreapi.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findById(Integer id);

    @Transactional
    void deleteById(Integer id);
}
