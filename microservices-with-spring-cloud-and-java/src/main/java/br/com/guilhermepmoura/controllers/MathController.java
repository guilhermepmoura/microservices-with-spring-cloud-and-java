package br.com.guilhermepmoura.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //localhost:8082/math/sum/numberOne/numberTwo
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric((numberTwo)))
            throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
        private Double convertToDouble(String strNumber) throws IllegalAccessException {
            if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value!");
            String number = strNumber.replace(",", "."); // pois no Brasil se utilizar "," para determinar centavos.
            return Double.parseDouble(number);
        }

        private static boolean isNumeric(String strNumber) {
            if(strNumber == null || strNumber.isEmpty()) return false;
            String number = strNumber.replace(",", "."); // pois no Brasil se utilizar "," para determinar centavos.
            return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
        }


    //localhost:8082/math/subtraction/numberOne/numberTwo
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    //localhost:8082/math/multiplication/numberOne/numberTwo
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    //localhost:8082/math/division/numberOne/numberTwo
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    //localhost:8082/math/mean/numberOne/numberTwo
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean (
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    //localhost:8082/math/squareRoot/numberOne
    @RequestMapping("/squareRoot/{numberOne}")
    public Double squareRoot (
            @PathVariable("numberOne") String numberOne
    ) throws Exception {
        if(!isNumeric(numberOne)) throw new UnsupportedOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(numberOne));
    }

}
