package com.chaquitaclla.microservice.sowings.sowings.domain.model.commands;

public record UpdateSowingCommand(Long Id, Integer cropId, Integer areaLand) {
}