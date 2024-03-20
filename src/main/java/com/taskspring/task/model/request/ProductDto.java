package com.taskspring.task.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductDto {
    private Integer id;
    private String image;
    private String additional_image_link;
    private Integer style_id;
    private Integer class_id;
    private String color;
    private Integer color_code;
    private String color_family;
    private Integer size_id;
    private Integer department_id;
    private String dissection_code;
    private Boolean hazmat;
    private Boolean redline;
    private Boolean promoted;
    private Double tax_code;
    private Integer vendor;
    private Double list_price;
    private String sale_price;
    private String sale_price_effective_date;
    private String currency;
    private Boolean shoprunner_eligible;
    private String title;
    private String link;
    private String prod_description;
    private Date start_date;
    private Boolean featured_color;
    private String featured_color_category;
    private String related_products;
    private Boolean pre_order;
    private String handling_code;
    private String video;
    private String proportion;
    private String proportion_products;
    private String master_style;
    private Boolean cannot_return;
    private Boolean great_find;
    private Boolean web_exclusive;
    private Boolean ny_deals;
    private String promo_tagline;
    private Boolean partially_promoted;
    private String product_category;
    private String sort_order;
    private Integer quantity_sold;
    private Double average_rating;
}
