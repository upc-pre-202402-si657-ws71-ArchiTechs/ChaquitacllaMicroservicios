package com.chaquitaclla.microservice.sowings.products.interfaces.rest.resources;


import com.chaquitaclla.microservice.sowings.products.domain.model.valueobjects.ProductType;

public record CreateProductResource(Long sowingId, String name, Long quantity, ProductType productType) {
}
