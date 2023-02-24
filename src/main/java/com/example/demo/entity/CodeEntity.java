package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "code_entity")
@Getter
@Setter
public class CodeEntity {

    @Id
    @GeneratedValue(generator = "code_sequence")
    @GenericGenerator(name = "code_sequence", strategy = "com.example.demo.generator.CodeEntityIdGenerator")
    private String code;
}
