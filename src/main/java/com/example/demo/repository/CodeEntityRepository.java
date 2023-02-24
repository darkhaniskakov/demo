package com.example.demo.repository;

import com.example.demo.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CodeEntityRepository extends JpaRepository<CodeEntity, String> {

    CodeEntity findFirstByOrderByCodeDesc();

}
