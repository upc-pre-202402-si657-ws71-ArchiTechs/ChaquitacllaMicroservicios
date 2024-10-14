package com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.transform;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.aggregates.Sowing;
import com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.resources.SowingResource;

public class SowingResourceFromEntityAssembler {
    public static SowingResource fromEntity(Sowing sowing) {
        return new SowingResource(
                sowing.getId(),
                sowing.getDateRange(),
                sowing.getProfileId().profileId().intValue(),
                sowing.getAreaLand(),
                sowing.isStatus(),
                sowing.getCropId().cropId().intValue(),
                sowing.getPhenologicalPhase().ordinal()
        );
    }
}