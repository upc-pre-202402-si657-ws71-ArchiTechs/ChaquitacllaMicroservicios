package com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.transform;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.commands.UpdateSowingCommand;
import com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.resources.UpdateSowingResource;

public class UpdateSowingCommandFromResourceAssembler {
    public static UpdateSowingCommand fromResource(Long sowingId, UpdateSowingResource resource) {
        return new UpdateSowingCommand(
                sowingId,
                resource.cropId(),
                resource.areaLand()
        );
    }
}