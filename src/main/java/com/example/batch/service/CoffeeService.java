package com.example.batch.service;

import com.example.batch.repository.CoffeeRepository;
import com.example.batch.repository.entity.Coffee;
import com.example.batch.dto.CoffeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    // 모든 커피 정보를 가져와 CoffeeDto 로 변환하여 반환
    public List<CoffeeDto> getAllCoffees() {
        // 데이터베이스에서 모든 커피 정보를 가져옴
        List<Coffee> coffeeList = coffeeRepository.findAll();

        // 각 Coffee 엔티티를 CoffeeDto로 변환하여 리스트로 반환
        return coffeeList.stream()
                .map(CoffeeDto::toCoffeeDto) // 이 부분을 변경하여 매핑
                .collect(Collectors.toList());
    }
}
