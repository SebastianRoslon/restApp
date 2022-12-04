package pl.roslon.xCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.roslon.xCode.model.CurrencyModel;
import pl.roslon.xCode.model.NumbersModel;
import pl.roslon.xCode.service.Service;

import java.util.Arrays;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/status/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

    @PostMapping(value = "/numbers/sort-command")
    @ResponseStatus()
    public ResponseEntity<String> getSortNumbers(@RequestBody NumbersModel numbersModel) {
        Integer[] array = service.getIntegers(numbersModel);
        return new ResponseEntity<String>(Arrays.toString(array), HttpStatus.CREATED);
    }

    @PostMapping(value = "/currencies/get-current-currency-value-command")
    public ResponseEntity<String> getCurrentCurrencyValue(@RequestBody CurrencyModel currencyModel) {
        return new ResponseEntity<String>(service.printCurrencyValue(currencyModel.getCurrencyCode()), HttpStatus.CREATED);
    }
}





