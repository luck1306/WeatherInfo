package com.weather.infoapp.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weather.infoapp.dto.MessageDto;
import com.weather.infoapp.service.TestService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestService testService;

    @CrossOrigin
    @GetMapping("/")
    public MessageDto<ArrayList<String>> getIdx() {
        return new MessageDto<>(testService.getTableList());
    }

    @CrossOrigin
    @GetMapping("/table/{tableName}")
    public MessageDto<String> selectTable(@PathVariable String tableName) {
        return new MessageDto<String>(tableName);
    }
}
