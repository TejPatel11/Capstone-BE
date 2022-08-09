package com.example.goal.dao;

import com.example.goal.model.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("UserRepository")
public class PredictionRepository implements PredictionDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insertPrediction(int id, Prediction prediction) {
        String sql="INSERT INTO PREDICTION(EXPENSES,INCOME,INTRESTRATE)VALUES(?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{prediction.getExpenses(),prediction.getIncome(),prediction.getIntrestRate()});
    }

    @Override
    public int updatePrediction(int id, Prediction prediction) {
        String sql = "UPDATE PREDICTION SET EXPENSES=?,INCOME=?,INTRESTRATE=? WHERE ID=? ";

        return jdbcTemplate.update(sql, new Object[]{prediction.getExpenses(),prediction.getIncome(),prediction.getIntrestRate(),id});
    }

    @Override
    public int deletePrediction(int id) {
        String sql="DELETE FROM PREDICTION WHERE ID=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Prediction> queyPrediction() {
        String sql="SELECT * FROM PREDICTION";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Prediction.class));
    }

    @Override
    public Optional<Prediction> queryPrediction(int id) {
        Prediction prediction = null;
        try{
            String sql = "SELECT * FROM PREDICTION WHERE ID=?";
            prediction=jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Prediction.class),id);
            return Optional.ofNullable(prediction);
        }catch (IncorrectResultSizeDataAccessException e){
            return Optional.ofNullable(null);
        }

    }
}
