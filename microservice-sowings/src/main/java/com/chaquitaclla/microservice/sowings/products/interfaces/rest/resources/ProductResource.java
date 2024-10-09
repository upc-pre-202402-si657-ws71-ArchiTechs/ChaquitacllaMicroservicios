package com.chaquitaclla.microservice.sowings.products.interfaces.rest.resources;


import com.chaquitaclla.microservice.sowings.products.domain.model.valueobjects.ProductType;

import java.time.LocalDate;

public record ProductResource(Long id, Long sowingId, String name, Long quantity, LocalDate appliedDate,
                              ProductType productType) {
}
