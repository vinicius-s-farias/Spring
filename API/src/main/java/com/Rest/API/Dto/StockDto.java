package com.Rest.API.Dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockDto {

    private String stock_symbol;
    private String stock_name;
    private Double ask_min;
    private Double ask_max;
    private Double bid_min;
    private Double bid_max;
}
