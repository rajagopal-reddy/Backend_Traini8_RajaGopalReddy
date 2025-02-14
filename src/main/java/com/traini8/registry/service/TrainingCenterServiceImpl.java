package com.traini8.registry.service;

import com.traini8.registry.exception.ResourceAlreadyExistsException;
import com.traini8.registry.exception.ResourceNotFoundException;
import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.repository.TrainingCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingCenterServiceImpl implements TrainingCenterService {

    private final TrainingCenterRepository repository;

    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        validateTrainingCenter(trainingCenter);

        if (repository.findByCenterCode(trainingCenter.getCenterCode()).isPresent()) {
            throw new ResourceAlreadyExistsException(
                    "Training Center with center code '" + trainingCenter.getCenterCode() + "' already exists"
            );
        }

        trainingCenter.setCreatedOn(Instant.now().toEpochMilli());
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = repository.findAll();
        if (trainingCenters.isEmpty()) {
            throw new ResourceNotFoundException("No training centers found");
        }
        return trainingCenters;
    }

    private void validateTrainingCenter(TrainingCenter trainingCenter) {
        if (trainingCenter == null) {
            throw new IllegalArgumentException("TrainingCenter object cannot be null");
        }
    }
}



