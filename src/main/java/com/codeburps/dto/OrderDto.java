package com.codeburps.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class OrderDto {

    private int userId;
    private Set<ItemDto> items;
}
