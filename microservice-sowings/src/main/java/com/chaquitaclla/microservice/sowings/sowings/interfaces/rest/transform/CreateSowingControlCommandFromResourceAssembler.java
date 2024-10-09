package com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.transform;

import com.chaquitaclla.microservice.sowings.sowings.domain.model.commands.CreateSowingControlCommand;
import com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.resources.CreateSowingControlResource;

public class CreateSowingControlCommandFromResourceAssembler {
    public static CreateSowingControlCommand fromResource(Long sowingId, CreateSowingControlResource resource) {
        return new CreateSowingControlCommand(
                sowingId,
                resource.sowingCondition(),
                resource.sowingSoilMoisture(),
                resource.sowingStemCondition()
        );
    }
}