package pl.roslon.xCode.dto;

import lombok.*;

import java.util.ArrayList;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyDto {

    ArrayList<RatesDto> rates;

}
