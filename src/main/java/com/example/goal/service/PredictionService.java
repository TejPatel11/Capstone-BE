package com.example.goal.service;

import com.example.goal.dao.PredictionDao;
import com.example.goal.model.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PredictionService {
    private final PredictionDao predictionDao;

    @Autowired
    public PredictionService(@Qualifier("PredictionRepository") PredictionDao predictionDao) {
        this.predictionDao = predictionDao;
    }

    public int insertPrediction(Prediction prediction){
        return predictionDao.insertPrediction(prediction);
    }
    public int updatePrediction(int id, Prediction prediction){
        return predictionDao.updatePrediction(id,prediction);
    }
    public int deletePrediction(int id){
        return predictionDao.deletePrediction(id);
    }
    public List<Prediction> queryPrediction(){
        return predictionDao.queyPrediction();
    }
    public Optional<Prediction> queryPrediction(int id){
        return predictionDao.queryPrediction(id);
    }
}
