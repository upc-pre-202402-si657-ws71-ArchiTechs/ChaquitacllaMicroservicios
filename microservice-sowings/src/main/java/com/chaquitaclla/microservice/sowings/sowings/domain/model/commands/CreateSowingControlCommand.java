package com.chaquitaclla.microservice.sowings.sowings.domain.model.commands;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.valueobjects.SowingCondition;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.valueobjects.SowingSoilMoisture;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.valueobjects.SowingStemCondition;

public record CreateSowingControlCommand(Long sowingId,
                                         SowingCondition sowingCondition,
                                         SowingSoilMoisture sowingSoilMoisture,
                                         SowingStemCondition sowingStemCondition)
{
}