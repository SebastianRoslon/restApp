package pl.roslon.xCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.roslon.xCode.model.CurrencyModel;
import pl.roslon.xCode.model.NumbersModel;
import pl.roslon.xCode.service.Service;

import java.net.URI;
import java.util.Arrays;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/status/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok().body("pong");
    }

    @PostMapping(value = "/numbers/sort-command")
    @ResponseStatus()
    public ResponseEntity<String> getSortNumbers(@RequestBody NumbersModel numbersModel) {
        Integer[] array = service.getIntegers(numbersModel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/numbers/sort-command")
                .buildAndExpand((Object) array)
                .toUri();
        return ResponseEntity.created(location).body(Arrays.toString(array));
    }

    @PostMapping(value = "/currencies/get-current-currency-value-command")
    public ResponseEntity<String> getCurrentCurrencyValue(@RequestBody CurrencyModel currencyModel) {
        String currencyString = service.printCurrencyValue(currencyModel.getCurrencyCode());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/currencies/get-current-currency-value-command")
                .buildAndExpand(currencyString)
                .toUri();
        return ResponseEntity.created(location).body(currencyString);
    }
}





