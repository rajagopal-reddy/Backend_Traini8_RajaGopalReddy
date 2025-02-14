package com.traini8.registry.service;

import com.traini8.registry.model.TrainingCenter;

import java.util.List;

public interface TrainingCenterService {

    TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);

    List<TrainingCenter> getAllTrainingCenters();
}
