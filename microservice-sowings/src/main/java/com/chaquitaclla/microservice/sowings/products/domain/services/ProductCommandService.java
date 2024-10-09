package com.chaquitaclla.microservice.sowings.products.domain.services;

import com.chaquitaclla.microservice.sowings.products.domain.model.commands.CreateProductCommand;
import com.chaquitaclla.microservice.sowings.products.domain.model.commands.DeleteProductCommand;

public interface ProductCommandService {
    Long handle(CreateProductCommand command);
    void handle(DeleteProductCommand command);
}
