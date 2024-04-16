package com.example.DatabaseUtility.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/database")
public class DatabaseMetadataController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/tables")
    public List<String> getTables() {
        return jdbcTemplate.queryForList("SHOW TABLES", String.class);
    }

    @GetMapping("/metadata")
    public Map<String, Map<String, String>> getMetadata() {
        List<String> tables = getTables();
        Map<String, Map<String, String>> metadataMap = new HashMap<>();
        for (String table : tables) {
            List<Map<String, Object>> metadataList = jdbcTemplate.queryForList("SHOW COLUMNS FROM " + table);
            Map<String, String> tableMetadata = new HashMap<>();
            for (Map<String, Object> column : metadataList) {
                tableMetadata.put((String) column.get("Field"), (String) column.get("Type"));
            }
            metadataMap.put(table, tableMetadata);
        }
        return metadataMap;
    }


}



