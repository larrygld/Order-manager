package com.ctgu.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 */
@Data
public class Productleimu {

    @JsonProperty("id")
    private Integer categoryType;

    @JsonProperty("name")
    private String categoryName;


}
