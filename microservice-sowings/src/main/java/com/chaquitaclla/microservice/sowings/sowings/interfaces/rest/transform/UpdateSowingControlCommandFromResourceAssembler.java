package com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.transform;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.commands.UpdateSowingControlCommand;
import com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.resources.UpdateSowingControlResource;

public class UpdateSowingControlCommandFromResourceAssembler {
    public static UpdateSowingControlCommand fromResource(UpdateSowingControlResource resource, Long sowingId, Long sowingControlId ) {
        return new UpdateSowingControlCommand(
                sowingId,
                sowingControlId,
                resource.sowingCondition(),
                resource.sowingSoilMoisture(),
                resource.sowingStemCondition()
        );
    }
}