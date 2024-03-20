package com.taskspring.task.util;

import com.taskspring.task.model.request.ProductDto;

public class QueryGenerator {
    public String createSearchQuery(ProductDto productDto) {
        StringBuilder queryString = new StringBuilder();
        boolean isFirstField = true;
        if (productDto.getId() != null) {
            appendFieldToQuery(queryString, "sku_id", productDto.getId(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getImage() != null) {
            appendFieldToQuery(queryString, "image", productDto.getImage(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getAdditional_image_link() != null) {
            appendFieldToQuery(queryString, "additional_image_link", productDto.getAdditional_image_link(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getStyle_id() != null) {
            appendFieldToQuery(queryString, "style_id", productDto.getStyle_id(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getClass_id() != null) {
            appendFieldToQuery(queryString, "class_id", productDto.getClass_id(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getColor() != null) {
            appendFieldToQuery(queryString, "color", productDto.getColor(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getColor_code() != null) {
            appendFieldToQuery(queryString, "color_code", productDto.getColor_code(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getColor_family() != null) {
            appendFieldToQuery(queryString, "color_family", productDto.getColor_family(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getSize_id() != null) {
            appendFieldToQuery(queryString, "size_id", productDto.getSize_id(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getDepartment_id() != null) {
            appendFieldToQuery(queryString, "department_id", productDto.getDepartment_id(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getDissection_code() != null) {
            appendFieldToQuery(queryString, "dissection_code", productDto.getDissection_code(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getHazmat() != null) {
            appendFieldToQuery(queryString, "hazmat", productDto.getHazmat(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getRedline() != null) {
            appendFieldToQuery(queryString, "redline", productDto.getRedline(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getPromoted() != null) {
            appendFieldToQuery(queryString, "promoted", productDto.getPromoted(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getTax_code() != null) {
            appendFieldToQuery(queryString, "tax_code", productDto.getTax_code(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getVendor() != null) {
            appendFieldToQuery(queryString, "vendor", productDto.getVendor(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getList_price() != null) {
            appendFieldToQuery(queryString, "list_price", productDto.getList_price(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getSale_price() != null) {
            appendFieldToQuery(queryString, "sale_price", productDto.getSale_price(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getSale_price_effective_date() != null) {
            appendFieldToQuery(queryString, "sale_price_effective_date", productDto.getSale_price_effective_date(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getCurrency() != null) {
            appendFieldToQuery(queryString, "currency", productDto.getCurrency(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getShoprunner_eligible() != null) {
            appendFieldToQuery(queryString, "shoprunner_eligible", productDto.getShoprunner_eligible(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getTitle() != null) {
            appendFieldToQuery(queryString, "title", productDto.getTitle(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getLink() != null) {
            appendFieldToQuery(queryString, "link", productDto.getLink(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getProd_description() != null) {
            appendFieldToQuery(queryString, "prod_description", productDto.getProd_description(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getStart_date() != null) {
            appendFieldToQuery(queryString, "start_date", productDto.getStart_date(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getFeatured_color() != null) {
            appendFieldToQuery(queryString, "featured_color", productDto.getFeatured_color(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getFeatured_color_category() != null) {
            appendFieldToQuery(queryString, "featured_color_category", productDto.getFeatured_color_category(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getRelated_products() != null) {
            appendFieldToQuery(queryString, "related_products", productDto.getRelated_products(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getPre_order() != null) {
            appendFieldToQuery(queryString, "pre_order", productDto.getPre_order(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getHandling_code() != null) {
            appendFieldToQuery(queryString, "handling_code", productDto.getHandling_code(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getVideo() != null) {
            appendFieldToQuery(queryString, "video", productDto.getVideo(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getProportion() != null) {
            appendFieldToQuery(queryString, "proportion", productDto.getProportion(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getProportion_products() != null) {
            appendFieldToQuery(queryString, "proportion_products", productDto.getProportion_products(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getMaster_style() != null) {
            appendFieldToQuery(queryString, "master_style", productDto.getMaster_style(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getCannot_return() != null) {
            appendFieldToQuery(queryString, "cannot_return", productDto.getCannot_return(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getGreat_find() != null) {
            appendFieldToQuery(queryString, "great_find", productDto.getGreat_find(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getWeb_exclusive() != null) {
            appendFieldToQuery(queryString, "web_exclusive", productDto.getWeb_exclusive(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getNy_deals() != null) {
            appendFieldToQuery(queryString, "ny_deals", productDto.getNy_deals(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getPromo_tagline() != null) {
            appendFieldToQuery(queryString, "promo_tagline", productDto.getPromo_tagline(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getPartially_promoted() != null) {
            appendFieldToQuery(queryString, "partially_promoted", productDto.getPartially_promoted(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getProduct_category() != null) {
            appendFieldToQuery(queryString, "product_category", productDto.getProduct_category(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getSort_order() != null) {
            appendFieldToQuery(queryString, "sort_order", productDto.getSort_order(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getQuantity_sold() != null) {
            appendFieldToQuery(queryString, "quantity_sold", productDto.getQuantity_sold(), isFirstField);
            isFirstField = false;
        }
        if (productDto.getAverage_rating() != null) {
            appendFieldToQuery(queryString, "average_rating", productDto.getAverage_rating(), isFirstField);
            isFirstField = false;
        }
        return queryString.toString();
    }

    private static void appendFieldToQuery(StringBuilder queryString, String fieldName, Object value, boolean isFirstField) {
        if (!isFirstField) {
            queryString.append(" AND ");
        }
        queryString.append(fieldName).append(":").append(value);
    }
}
