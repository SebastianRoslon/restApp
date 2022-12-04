package pl.roslon.xCode.model;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@Setter
public class NumbersModel {

    @Nullable
    private Integer[] ints;
    private Order order;

}
