package com.taskspring.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    @Id
    private Integer id;

    @Column(columnDefinition = "text")
    private String image;

    @Column(columnDefinition = "text")
    private String additionalImageLink;

    private Integer styleId;
    private Integer classId;
    private String color;
    private Integer colorCode;
    private String colorFamily;
    private Integer sizeId;
    private Integer departmentId;
    private String dissectionCode;

    @Builder.Default
    private Boolean hazmat = false;
    @Builder.Default
    private Boolean redline = false;
    @Builder.Default
    private Boolean promoted = false;

    private Double taxCode;
    private Integer vendor;
    private Double listPrice;
    private String salePrice;
    private String salePriceEffectiveDate;
    private String currency;

    @Builder.Default
    private Boolean shoprunnerEligible = false;

    private String title;
    private String link;

    @Column(columnDefinition = "text")
    private String prodDescription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Builder.Default
    private Boolean featuredColor = false;

    private String featuredColorCategory;
    private String relatedProducts;
    @Builder.Default
    private Boolean preOrder = false;

    private String handlingCode;
    private String video;
    private String proportion;
    private String proportionProducts;
    private String masterStyle;

    @Builder.Default
    private Boolean cannotReturn = false;
    @Builder.Default
    private Boolean greatFind = false;
    @Builder.Default
    private Boolean webExclusive = false;
    @Builder.Default
    private Boolean nyDeals = false;

    private String promoTagline;

    @Builder.Default
    private Boolean partiallyPromoted = false;
    @Column(columnDefinition = "text")
    private String productCategory;
    private String sortOrder;

    private Integer quantitySold;
    @Builder.Default
    private Double averageRating = 0.0;
}