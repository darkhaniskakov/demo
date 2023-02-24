package com.example.demo.service;

import com.example.demo.entity.CodeEntity;
import com.example.demo.generator.GeneratorUtil;
import com.example.demo.repository.CodeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CodeEntityService {

    @Autowired
    private CodeEntityRepository codeEntityRepository;

    @Transactional
    public String nextCode() {
        return codeEntityRepository.save(new CodeEntity()).getCode();
    }

}
