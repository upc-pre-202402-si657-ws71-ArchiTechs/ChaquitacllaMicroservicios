package com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.transform;

import com.chaquitaclla.microservice.sowings.sowings.domain.model.commands.CreateSowingCommand;
import com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.resources.CreateSowingResource;

public class CreateSowingCommandFromResourceAssembler {
    public static CreateSowingCommand fromResource(CreateSowingResource resource) {
        return new CreateSowingCommand(
                resource.cropId(),
                resource.areaLand()
        );
    }
}