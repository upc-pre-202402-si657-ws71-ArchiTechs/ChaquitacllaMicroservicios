package com.chaquitaclla.microservice.products.sowings.application.internal.commandservices;

import com.chaquitaclla.microservice.products.sowings.domain.model.aggregates.Sowing;
import com.chaquitaclla.microservice.products.sowings.domain.model.commands.CreateSowingCommand;
import com.chaquitaclla.microservice.products.sowings.domain.model.commands.DeleteSowingCommand;
import com.chaquitaclla.microservice.products.sowings.domain.model.commands.UpdateSowingCommand;
import com.chaquitaclla.microservice.products.sowings.domain.model.valueobjects.CropId;
import com.chaquitaclla.microservice.products.sowings.domain.services.SowingCommandService;
import com.chaquitaclla.microservice.products.sowings.infrastructure.persistence.jpa.repositories.SowingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SowingCommandServiceImpl implements SowingCommandService {
    private final SowingRepository sowingRepository;

    public SowingCommandServiceImpl(SowingRepository sowingRepository) {
        this.sowingRepository = sowingRepository;
    }

    @Override
    public Long handle(CreateSowingCommand command) {
        var cropId = new CropId(Long.valueOf(command.cropId()));

        var sowing = new Sowing(cropId, command.areaLand());
        sowingRepository.save(sowing);
        return sowing.getId();
    }

    @Override
    public Optional<Sowing> handle(UpdateSowingCommand command) {
        if (!sowingRepository.existsById(command.Id()))
            throw new IllegalArgumentException("Sowing does not exist");

        var sowingToUpdate = sowingRepository.findById(command.Id()).get();
        Integer cropIdInteger = command.cropId();
        CropId cropId = new CropId(Long.valueOf(cropIdInteger));
        sowingToUpdate.setCropId(cropId);
        sowingToUpdate.setAreaLand(command.areaLand());
        var updatedSowing = sowingRepository.save(sowingToUpdate);

        return Optional.of(updatedSowing);
    }

    @Override
    public void handle(DeleteSowingCommand command) {
        if (!sowingRepository.existsById(command.sowingId()))
            throw new IllegalArgumentException("Sowing does not exist");

        sowingRepository.deleteById(command.sowingId());
    }
}
