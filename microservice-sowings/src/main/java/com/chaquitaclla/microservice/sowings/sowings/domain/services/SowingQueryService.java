package com.chaquitaclla.microservice.sowings.sowings.domain.services;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.aggregates.Sowing;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.queries.GetAllSowingsQuery;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.queries.GetSowingByIdQuery;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.queries.GetSowingsByPhenologicalPhaseQuery;

import java.util.List;
import java.util.Optional;

public interface SowingQueryService {
    List<Sowing> handle(GetAllSowingsQuery query);
    Optional<Sowing> handle(GetSowingByIdQuery query);
    List<Sowing> handle(GetSowingsByPhenologicalPhaseQuery query);
}
