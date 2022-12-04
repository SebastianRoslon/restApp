package pl.roslon.xCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import pl.roslon.xCode.controller.Controller;
import pl.roslon.xCode.model.CurrencyModel;
import pl.roslon.xCode.model.NumbersModel;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private Controller controller;
    @Autowired
    private NumbersModel numbersModel;
    @Autowired
    private CurrencyModel currencyModel;


    @Test
    public void shouldReturnOkStatusPing(){
        ResponseEntity<String> request = controller.ping();
        Assertions.assertTrue(request.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void shouldReturnOkStatusNumbers(){
        ResponseEntity<String> response = controller.getSortNumbers(numbersModel);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void shouldReturnOkStatusCurrencyValue(){
        ResponseEntity<String>response = controller.getCurrentCurrencyValue(currencyModel);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}
