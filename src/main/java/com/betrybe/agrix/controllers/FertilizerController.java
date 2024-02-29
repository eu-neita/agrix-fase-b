package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller.
 */
@Controller
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * create.
   */
  @PostMapping()
  public ResponseEntity<FertilizerDto> createFertilizer(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerService.create(fertilizerDto.toFertilizer());

    FertilizerDto dto = new FertilizerDto(fertilizer.getId(), fertilizer.getName(),
        fertilizer.getBrand(), fertilizer.getComposition());
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }
}