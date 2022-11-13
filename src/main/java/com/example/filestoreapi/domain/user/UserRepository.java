package com.example.filestoreapi.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Integer id);
    @Transactional
    void deleteById(Integer id);
    @Query(value = "select * from users where company_id = :#{#id}", nativeQuery = true)
    List<Integer> getUsersByCompanyId(@Param("id") Integer id);
}
