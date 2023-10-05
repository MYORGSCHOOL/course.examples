package ru.springdata.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    private long id;

    private String model;
}
