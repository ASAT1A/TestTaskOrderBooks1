package com.example.demo;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Map;

@Data
@SpringBootApplication
@ConfigurationPropertiesScan
public class LibraryApplication {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);

    }
}
