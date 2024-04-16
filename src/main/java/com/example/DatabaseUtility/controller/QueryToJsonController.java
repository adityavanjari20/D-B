package com.example.DatabaseUtility.controller;

import com.example.DatabaseUtility.servicer.DaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("query")
public class QueryToJsonController {

    @Autowired
    DaoService daoService;

    @GetMapping("/getResult")
    public Map<String,List<Map<String, Object>>> invokeQueryAndGetResponseInJsonFormate() throws JsonProcessingException {
        Map<String,List<Map<String, Object>>> queryResult = daoService.getQueryResult();

        ObjectMapper mapper = new ObjectMapper();
        String resultInJSonFormat = mapper.writeValueAsString(queryResult);

        System.out.println(resultInJSonFormat);

        return queryResult;
    }
}
