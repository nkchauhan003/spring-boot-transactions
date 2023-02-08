package com.codeburps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ItemDto {
    private String name;
    private int price;
    private int availableQuantity;
}
