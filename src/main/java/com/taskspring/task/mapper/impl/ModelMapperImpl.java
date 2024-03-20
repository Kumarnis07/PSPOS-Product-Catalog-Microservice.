package com.taskspring.task.mapper.impl;

import com.taskspring.task.mapper.ModelMapper;
import com.taskspring.task.model.Product;
import com.taskspring.task.model.solr.IndexedProduct;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperImpl implements ModelMapper {
    @Override
    public Product rowToModelMapper(Row row) {
        return Product.builder().id(row.getAs("sku_id")).image(getOrDefault(row.getAs("image"), "")).additionalImageLink(getOrDefault(row.getAs("additional_image_link"), "")).styleId(getOrDefault(row.getAs("style_id"), null)).classId(getOrDefault(row.getAs("class_id"), null)).color(getOrDefault(row.getAs("color"), "")).colorCode(getOrDefault(row.getAs("color_code"), null)).colorFamily(getOrDefault(row.getAs("color_family"), "")).sizeId(getOrDefault(row.getAs("size_id"), null)).departmentId(getOrDefault(row.getAs("department_id"), null)).dissectionCode(getOrDefault(row.getAs("dissection-code"), "")).hazmat(getOrDefault(row.getAs("hazmat"), false)).redline(getOrDefault(row.getAs("redline"), false)).promoted(getOrDefault(row.getAs("promoted"), false)).taxCode(getOrDefault(row.getAs("tax_code"), null)).vendor(getOrDefault(row.getAs("vendor"), null)).listPrice(getOrDefault(row.getAs("list_price"), null)).salePrice(getOrDefault(row.getAs("sale_price"), "")).salePriceEffectiveDate(getOrDefault(row.getAs("sale_price_effective_date"), "")).currency(getOrDefault(row.getAs("currency"), "")).shoprunnerEligible(getOrDefault(row.getAs("shoprunner_eligible"), false)).title(getOrDefault(row.getAs("title"), "")).link(getOrDefault(row.getAs("link"), "")).prodDescription(getOrDefault(row.getAs("prod_description"), "")).startDate(getOrDefault(row.getAs("start_date"), null)).featuredColor(getOrDefault(row.getAs("featured_color"), false)).featuredColorCategory(getOrDefault(row.getAs("featured_color_category"), "")).relatedProducts(getOrDefault(row.getAs("related_products"), "")).preOrder(getOrDefault(row.getAs("pre_order"), false)).handlingCode(getOrDefault(row.getAs("handling_code"), "")).video(getOrDefault(row.getAs("video"), "")).proportion(getOrDefault(row.getAs("proportion"), "")).proportionProducts(getOrDefault(row.getAs("proportion_products"), "")).masterStyle(getOrDefault(row.getAs("master_style"), "")).cannotReturn(getOrDefault(row.getAs("cannot_return"), false)).greatFind(getOrDefault(row.getAs("great_find"), false)).webExclusive(getOrDefault(row.getAs("web_exclusive"), false)).nyDeals(getOrDefault(row.getAs("ny_deals"), false)).promoTagline(getOrDefault(row.getAs("promo_tagline"), "")).partiallyPromoted(getOrDefault(row.getAs("partially_promoted"), false)).productCategory(getOrDefault(row.getAs("product_category"), "")).sortOrder(getOrDefault(row.getAs("sort_order"), "")).quantitySold(getOrDefault(row.getAs("quantity_sold"), null)).averageRating(getOrDefault(row.getAs("average_rating"), 0.0)).build();
    }

    @Override
    public IndexedProduct productToIndexedProductMapper(Product product) {
        return IndexedProduct.builder().id(product.getId()).image(product.getImage()).additionalImageLink(product.getAdditionalImageLink()).styleId(product.getStyleId()).classId(product.getClassId()).color(product.getColor()).colorCode(product.getColorCode()).colorFamily(product.getColorFamily()).sizeId(product.getSizeId()).departmentId(product.getDepartmentId()).hazmat(product.getHazmat()).redline(product.getRedline()).promoted(product.getPromoted()).taxCode(product.getTaxCode()).vendor(product.getVendor()).listPrice(product.getListPrice()).salePriceEffectiveDate(product.getSalePriceEffectiveDate()).currency(product.getCurrency()).shoprunnerEligible(product.getShoprunnerEligible()).title(product.getTitle()).link(product.getLink()).prodDescription(product.getProdDescription()).startDate(product.getStartDate()).featuredColor(product.getFeaturedColor()).featuredColorCategory(product.getFeaturedColorCategory()).relatedProducts(product.getRelatedProducts()).preOrder(product.getPreOrder()).handlingCode(product.getHandlingCode()).video(product.getVideo()).proportion(product.getProportion()).proportionProducts(product.getProportionProducts()).masterStyle(product.getMasterStyle()).cannotReturn(product.getCannotReturn()).greatFind(product.getGreatFind()).webExclusive(product.getWebExclusive()).nyDeals(product.getNyDeals()).promoTagline(product.getPromoTagline()).partiallyPromoted(product.getPartiallyPromoted()).productCategory(product.getProductCategory()).sortOrder(product.getSortOrder()).quantitySold(product.getQuantitySold()).averageRating(product.getAverageRating()).build();
    }

    private <T> T getOrDefault(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
}
