package com.example.goal.dao;

import com.example.goal.model.Prediction;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface PredictionDao {
    int insertPrediction(int id, Prediction prediction);
    default int insertPrediction(Prediction prediction){
        Random rand = new Random();
        int id=rand.nextInt();
        return insertPrediction(id, prediction);
    }
    int updatePrediction(int id, Prediction prediction);
    int deletePrediction(int id);
    List<Prediction> queyPrediction();
    Optional<Prediction> queryPrediction(int id);

}
