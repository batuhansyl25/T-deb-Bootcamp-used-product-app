package com.batuhan.staffsale.app.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdDTO {
    private String title;
    private String description;
    private String category;
    private double price;
    private Long userId;
}
