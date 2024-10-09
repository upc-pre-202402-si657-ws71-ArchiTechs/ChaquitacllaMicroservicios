package com.chaquitaclla.microservice.sowings.sowings.domain.model.queries;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.valueobjects.PhenologicalPhase;

public record GetSowingsByPhenologicalPhaseQuery(PhenologicalPhase phase) {
}