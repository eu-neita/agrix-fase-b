package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   * create fertilizers.
   */
  @PostMapping()
  public ResponseEntity<FertilizerDto> createFertilizer(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerService.create(fertilizerDto.toFertilizer());

    FertilizerDto dto = new FertilizerDto(fertilizer.getId(), fertilizer.getName(),
        fertilizer.getBrand(), fertilizer.getComposition());
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }

  /**
   * getAll fertilizers.
   */
  @GetMapping()
  public ResponseEntity<Iterable<FertilizerDto>> getAll() {
    return ResponseEntity.ok(FertilizerDto.toListDto(fertilizerService.getAll()));
  }

  /**
   * getById fertilizers.
   */
  @GetMapping("/{id}")
  public ResponseEntity<FertilizerDto> getById(@PathVariable Long id) {
    Fertilizer fertilizer = fertilizerService.getById(id);
    FertilizerDto dto = new FertilizerDto(fertilizer.getId(), fertilizer.getName(),
        fertilizer.getBrand(), fertilizer.getComposition());
    return ResponseEntity.ok(dto);
  }
}