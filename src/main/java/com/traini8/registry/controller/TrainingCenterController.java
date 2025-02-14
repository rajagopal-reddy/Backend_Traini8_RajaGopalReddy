package com.traini8.registry.controller;

import com.traini8.registry.exception.ResourceAlreadyExistsException;
import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.service.TrainingCenterService;
import com.traini8.registry.service.TrainingCenterServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/training-centers")
@RequiredArgsConstructor
public class TrainingCenterController {

    private final TrainingCenterService service;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        try {
            TrainingCenter savedCenter = service.createTrainingCenter(trainingCenter);
            return ResponseEntity.status(201).body(savedCenter);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(409).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        try {
            List<TrainingCenter> trainingCenters = service.getAllTrainingCenters();
            if (trainingCenters.isEmpty()) {
                return ResponseEntity.status(404).body(null);
            }
            return ResponseEntity.ok(trainingCenters);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

}