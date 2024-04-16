package com.example.DatabaseUtility.servicer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseMetadataService {

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public DatabaseMetadataService(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public Map<String, Map<String, String>> getTableMetadata() {
//        Map<String, Map<String, String>> tableMetadata = new HashMap<>();
//
//        List<String> tableNames = jdbcTemplate.queryForList("SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = ?",
//                String.class, yourDatabaseName); // Replace with your database name
//
//        for (String tableName : tableNames) {
//            Map<String, String> columnMetadata = getTableColumnMetadata(tableName);
//            tableMetadata.put(tableName, columnMetadata);
//        }
//
//        return tableMetadata;
//    }
//
//    private Map<String, String> getTableColumnMetadata(String tableName) {
//        Map<String, String> columnMetadata = new HashMap<>();
//
//        String a = 'alien';
//        List<Map<String, Object>> columns = jdbcTemplate.queryForList(
//                "SELECT COLUMN_NAME, DATA_TYPE FROM information_schema.COLUMNS WHERE TABLE_NAME = ?",
//                String.class, a);
//
//        for (Map<String, Object> column : columns) {
//            columnMetadata.put((String) column.get("COLUMN_NAME"), (String) column.get("DATA_TYPE"));
//        }
//
//        return columnMetadata;
//    }
}