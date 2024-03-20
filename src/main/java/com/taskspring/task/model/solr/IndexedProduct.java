package com.taskspring.task.model.solr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class IndexedProduct {

    @Field
    private Integer id;

    @Field
    private String image;

    @Field("additional_image_link")
    private String additionalImageLink;

    @Field("style_id")
    private Integer styleId;

    @Field("class_id")
    private Integer classId;

    @Field
    private String color;

    @Field("color_code")
    private Integer colorCode;

    @Field("color_family")
    private String colorFamily;

    @Field("size_id")
    private Integer sizeId;

    @Field("department_id")
    private Integer departmentId;

    @Field("dissection_code")
    private String dissectionCode;

    @Field
    private Boolean hazmat;

    @Field
    private Boolean redline;

    @Field
    private Boolean promoted;

    @Field("tax_code")
    private Double taxCode;

    @Field
    private Integer vendor;

    @Field("list_price")
    private Double listPrice;

    @Field("sale_price")
    private String salePrice;

    @Field("sale_price_effective_date")
    private String salePriceEffectiveDate;

    @Field
    private String currency;

    @Field("shoprunner_eligible")
    private Boolean shoprunnerEligible;

    @Field
    private String title;

    @Field
    private String link;

    @Field("prod_description")
    private String prodDescription;

    @Field("start_date")
    private Date startDate;

    @Field("featured_color")
    private Boolean featuredColor;

    @Field("featured_color_category")
    private String featuredColorCategory;

    @Field("related_products")
    private String relatedProducts;

    @Field("pre_order")
    private Boolean preOrder;

    @Field("handling_code")
    private String handlingCode;

    @Field
    private String video;

    @Field
    private String proportion;

    @Field("proportion_products")
    private String proportionProducts;

    @Field("master_style")
    private String masterStyle;

    @Field("cannot_return")
    private Boolean cannotReturn;

    @Field("great_find")
    private Boolean greatFind;

    @Field("web_exclusive")
    private Boolean webExclusive;

    @Field("ny_deals")
    private Boolean nyDeals;

    @Field("promo_tagline")
    private String promoTagline;

    @Field("partially_promoted")
    private Boolean partiallyPromoted;

    @Field("product_category")
    private String productCategory;

    @Field("sort_order")
    private String sortOrder;

    @Field("quantity_sold")
    private Integer quantitySold;

    @Field("average_rating")
    private Double averageRating;
}
