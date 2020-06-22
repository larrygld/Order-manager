package com.ctgu.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 */
@Data
public class Productcaidan {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("thumb")
    private String productThumb;

    @JsonProperty("imageUrl")
    private String productIcon;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("unit")
    private String productUnit;

    @JsonProperty("catid")
    private Integer productType;

    @JsonProperty("sales")
    private Integer productSales;

    @JsonProperty("note")
    private String productDescription;

    @JsonProperty("quantity")
    private Integer productNumb1;
}
