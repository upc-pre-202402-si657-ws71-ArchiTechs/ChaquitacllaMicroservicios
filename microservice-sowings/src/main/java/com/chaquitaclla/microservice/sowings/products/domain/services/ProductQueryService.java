package com.chaquitaclla.microservice.sowings.products.domain.services;


import com.chaquitaclla.microservice.sowings.products.domain.model.aggregates.Product;
import com.chaquitaclla.microservice.sowings.products.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

public interface ProductQueryService {
    /*List<Product> handle(GetProductsBySowingIdQuery query);*/
    Optional<Product> handle(GetProductByIdQuery query);
}
