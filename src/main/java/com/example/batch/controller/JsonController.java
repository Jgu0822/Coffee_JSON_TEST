package com.example.batch.controller;

import com.example.batch.repository.CoffeeRepository;
import com.example.batch.repository.entity.Coffee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonController {

    private final CoffeeRepository coffeeRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonController(CoffeeRepository coffeeRepository, ObjectMapper objectMapper) {
        this.coffeeRepository = coffeeRepository;
        this.objectMapper = objectMapper;
    }

    // JSON 데이터를 반환하는 엔드포인트
    @GetMapping("/getJsonData")
    public ResponseEntity<String> getJsonData() {
        // CoffeeRepository 를 사용하여 모든 Coffee 객체를 가져옴
        List<Coffee> coffeeList = coffeeRepository.findAll();

        try {
            // 가져온 Coffee 객체 리스트를 JSON 문자열로 변환
            String jsonData = objectMapper.writeValueAsString(coffeeList);
            return ResponseEntity.ok(jsonData);
        } catch (Exception e) {
            // 변환 과정에서 오류가 발생한 경우 에러 응답 반환
            return ResponseEntity.status(500).body("Error converting data to JSON.");
        }
    }
}
