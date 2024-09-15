package com.api_challenge.resistor.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ResistorServiceTest {

    @InjectMocks
    private ResistorService resistorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convertToColorCode_withSimpleOhmsValue_returnsColorCode() {
        String result = resistorService.convertToColorCode("47 ohms");
        assertEquals("amarelo violeta preto dourado", result);
    }

    @Test
    void convertToColorCode_withKiloOhmsValue_returnsColorCode() {
        String result = resistorService.convertToColorCode("4.7k ohms");
        assertEquals("amarelo violeta vermelho dourado", result);
    }

    @Test
    void convertToColorCode_withMegaOhmsValue_returnsColorCode() {
        String result = resistorService.convertToColorCode("1M ohms");
        assertEquals("marrom preto verde dourado", result);
    }

    @Test
    void convertToColorCode_withTwoDigitValue_returnsColorCode() {
        String result = resistorService.convertToColorCode("10 ohms");
        assertEquals("marrom preto preto dourado", result);
    }

    @Test
    void convertToColorCode_withThreeDigitValue_returnsColorCode() {
        String result = resistorService.convertToColorCode("100 ohms");
        assertEquals("marrom preto marrom dourado", result);
    }
}