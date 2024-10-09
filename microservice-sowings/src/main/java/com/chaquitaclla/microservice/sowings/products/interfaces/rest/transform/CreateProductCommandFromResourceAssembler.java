package com.chaquitaclla.microservice.sowings.products.interfaces.rest.transform;


import com.chaquitaclla.microservice.sowings.products.domain.model.commands.CreateProductCommand;
import com.chaquitaclla.microservice.sowings.products.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(Long sowingId, CreateProductResource resource) {
        return new CreateProductCommand(
                sowingId,
                resource.name(),
                resource.quantity(),
                resource.productType());
    }
}
