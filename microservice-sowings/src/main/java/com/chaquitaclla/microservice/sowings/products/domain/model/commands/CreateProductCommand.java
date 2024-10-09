package com.chaquitaclla.microservice.sowings.products.domain.model.commands;

import com.chaquitaclla.microservice.sowings.products.domain.model.valueobjects.ProductType;

public record CreateProductCommand(Long sowingId,
                                   String name,
                                   Long quantity,
                                   ProductType productType) {
}