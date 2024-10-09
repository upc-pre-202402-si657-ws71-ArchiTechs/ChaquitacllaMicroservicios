package com.chaquitaclla.microservice.sowings.sowings.domain.services;


import com.chaquitaclla.microservice.sowings.sowings.domain.model.aggregates.Sowing;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.commands.CreateSowingCommand;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.commands.DeleteSowingCommand;
import com.chaquitaclla.microservice.sowings.sowings.domain.model.commands.UpdateSowingCommand;

import java.util.Optional;

public interface SowingCommandService {
    Long handle(CreateSowingCommand command);
    Optional<Sowing> handle(UpdateSowingCommand command);
    void handle(DeleteSowingCommand command);

}
