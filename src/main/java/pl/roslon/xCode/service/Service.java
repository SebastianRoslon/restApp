package pl.roslon.xCode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import pl.roslon.xCode.model.NumbersModel;
import pl.roslon.xCode.model.Order;
import pl.roslon.xCode.dto.CurrencyDto;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@org.springframework.stereotype.Service
public class Service {

    public Integer[] getIntegers(NumbersModel numbersModel) {
        Integer[] array = numbersModel.getInts();
        if (numbersModel.getOrder() == Order.ASC)
            Arrays.sort(array);
        if (numbersModel.getOrder() == Order.DESC)
            Arrays.sort(array, Collections.reverseOrder());
        return array;
    }

    RestTemplate restTemplate = new RestTemplate();

    public CurrencyDto getCurrencyFromJson() {
        CurrencyDto[] currencyDto = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A?format=json", CurrencyDto[].class);
        assert currencyDto != null;
        return CurrencyDto.builder()
                .rates(currencyDto[0].getRates())
                .build();
    }

    public String printCurrencyValue(String currency) {
        double currencyValue = 0;
        for (int i = 0; i < getCurrencyFromJson().getRates().size(); i++) {
            if (getCurrencyFromJson().getRates().get(i).getCode().equals(currency)) {
                currencyValue = getCurrencyFromJson().getRates().get(i).getMid();
                log.info(String.valueOf(currencyValue));
            }
        }
        return "value: " + currencyValue;
    }

}
