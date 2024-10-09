package com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.transform;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.entities.SowingControl;
import com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.resources.SowingControlResource;

public class SowingControlResourceFromEntityAssembler {
    public static SowingControlResource toResourceFromEntity(SowingControl entity) {
        return new SowingControlResource(
                entity.getId(),
                entity.getSowing().getId(),
                entity.getControlDate(),
                entity.getSowingCondition(),
                entity.getSowingSoilMoisture(),
                entity.getSowingStemCondition());
    }
}