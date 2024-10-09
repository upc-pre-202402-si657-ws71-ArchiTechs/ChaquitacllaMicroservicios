package com.chaquitaclla.microservice.sowings.sowings.interfaces.rest.resources;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.valueobjects.SowingCondition;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.valueobjects.SowingSoilMoisture;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.valueobjects.SowingStemCondition;

public record UpdateSowingControlResource(SowingCondition sowingCondition,
                                          SowingSoilMoisture sowingSoilMoisture,
                                          SowingStemCondition sowingStemCondition) {
}
