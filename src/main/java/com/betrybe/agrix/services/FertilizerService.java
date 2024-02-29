package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FertilizerService.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  @Autowired

  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * create.
   */
  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }
}
