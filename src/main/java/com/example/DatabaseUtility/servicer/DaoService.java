package com.example.DatabaseUtility.servicer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DaoService {

    private static final String TABLE_NAME = "empinfo";
    private static String Query = "select * from "+TABLE_NAME;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Map<String,List<Map<String, Object>>> getQueryResult(){
        Map<String,List<Map<String, Object>>> jsonResultMap = new HashMap<>();

        long startTime = System.currentTimeMillis();
        List<Map<String, Object>> result = jdbcTemplate.queryForList(Query);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Query execution time: " + executionTime + " ms");

        jsonResultMap.put(TABLE_NAME,result);
        return jsonResultMap;
    }
}
