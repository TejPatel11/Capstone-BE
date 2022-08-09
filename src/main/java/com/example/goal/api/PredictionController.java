package com.example.goal.api;

import com.example.goal.model.Prediction;
import com.example.goal.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "predictions/")
public class PredictionController {
    private final PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    int insertPrediction(@RequestBody Prediction prediction){
        return predictionService.insertPrediction(prediction);
    }
    @PutMapping(value = "{id}")
    int updatePrediction(@PathVariable("id")int id, @RequestBody Prediction prediction){
        return predictionService.updatePrediction(id,prediction);
    }

    @DeleteMapping(value = "{id}")
    int deletePrediction(@PathVariable("id") int id){
        return predictionService.deletePrediction(id);
    }

    @GetMapping
    List<Prediction> queryPrediction(){
        return predictionService.queryPrediction();
    }

    @GetMapping(value = "{id}")
    Optional<Prediction>queryPrediction(@PathVariable("id") int id){
        return predictionService.queryPrediction(id);
    }
}
