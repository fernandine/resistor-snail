package com.api_challenge.resistor.controller;

import com.api_challenge.resistor.dto.ResistorDto;
import com.api_challenge.resistor.service.ResistorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/resistors")
@RequiredArgsConstructor
public class ResistorController {

    private final ResistorService service;

    @GetMapping("/{value}")
    public ResistorDto getResistor(@PathVariable BigDecimal value) {
        return service.getResistor(value);
    }

    @GetMapping("/color-code/{ohms}")
    public String getColorCode(@PathVariable String ohms) {
        return service.convertToColorCode(ohms);
    }
}
