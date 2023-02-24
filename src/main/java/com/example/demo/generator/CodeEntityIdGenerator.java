package com.example.demo.generator;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class CodeEntityIdGenerator implements IdentifierGenerator {

    private static final String FETCH_LAST_CODE_QUERY = "select code from code_entity order by code desc limit 1";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String currentCode = null;
        try {
            Connection connection = session.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(FETCH_LAST_CODE_QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                currentCode = rs.getString("code");
            }
        } catch (SQLException e) {
            log.error("Fetching current code failed", e);
            throw new RuntimeException(e);
        }

        if (currentCode == null || currentCode.trim().equals("")) {
            throw new RuntimeException("CurrentCode is null");
        }

        return GeneratorUtil.nextCode(currentCode);
    }
}
