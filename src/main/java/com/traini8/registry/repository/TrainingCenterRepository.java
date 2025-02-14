package com.traini8.registry.repository;

import com.traini8.registry.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    Optional<TrainingCenter> findByCenterCode(String centerCode);
}

