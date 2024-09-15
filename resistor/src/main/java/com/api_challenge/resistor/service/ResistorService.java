package com.api_challenge.resistor.service;

import com.api_challenge.resistor.dto.ResistorDto;
import com.api_challenge.resistor.entities.Resistor;
import com.api_challenge.resistor.entities.enums.ColorCode;
import com.api_challenge.resistor.repository.ResistorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ResistorService {

    private final ResistorRepository resistorRepository;

    public ResistorDto getResistor(BigDecimal value) {
        var colorSequence = convertToColorCode(value.toPlainString() + " ohms");
        Resistor resistor = new Resistor(null, value, colorSequence);
        resistorRepository.save(resistor);
        return new ResistorDto(resistor.getId(), value.toPlainString() + " ohms", colorSequence);
    }

    public String convertToColorCode(String ohmsValue) {
        var parts = ohmsValue.split(" ");
        String valueStr = parts[0];
        BigDecimal value;

        if (valueStr.endsWith("k")) {
            value = new BigDecimal(valueStr.replace("k", "")).multiply(new BigDecimal("1000"));
        } else if (valueStr.endsWith("M")) {
            value = new BigDecimal(valueStr.replace("M", "")).multiply(new BigDecimal("1000000"));
        } else {
            value = new BigDecimal(valueStr);
        }

        var stringValue = value.setScale(0, RoundingMode.DOWN).toPlainString();
        int firstDigit = Character.getNumericValue(stringValue.charAt(0));
        int secondDigit = stringValue.length() > 1 ? Character.getNumericValue(stringValue.charAt(1)) : 0;
        int multiplier = stringValue.length() - 2;

        var firstColor = ColorCode.fromValue(firstDigit);
        var secondColor = ColorCode.fromValue(secondDigit);
        var multiplierColor = ColorCode.fromValue(multiplier);
        var toleranceColor = ColorCode.DOURADO;

        return firstColor.getColor() + " " + secondColor.getColor() + " " + multiplierColor.getColor() + " " + toleranceColor.getColor();
    }
}