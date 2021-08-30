package com.example.StockMarketTool.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.example.StockMarketTool.model.*;


public interface StockRepository extends MongoRepository<StockModel, String> {
	
	List<StockModel> findBySymbol(String symbol);
	
	
}

