package com.example.StockMarketTool.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.StockMarketTool.model.StockModel;
import com.example.StockMarketTool.repository.StockRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockRepository;
	
	
	public String uploadAllStocks(MultipartFile file) {
		
		if(file.isEmpty()) {
			return "File empty";
		} else {
			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				
				CsvToBean<StockModel> csvToBean = new CsvToBeanBuilder<StockModel>(reader).withType(StockModel.class)
						.withIgnoreLeadingWhiteSpace(true).withThrowExceptions(true).build();
				List<StockModel> newStocks = csvToBean.parse();
				
				stockRepository.saveAll(newStocks);
				
				return "file-upload-success";
				
			} catch (Exception e) { 
				return e.toString();
			}
		}
	}
	
	
	public String createStock(StockModel stock) {
		try {
			stockRepository.save(stock);
			return "Saved-successfully";
		}
		catch(Exception e) {
			return e.toString();
		}
	}
	
	
	public List<StockModel> getAllStocks(String symbol) {
		try {
			List<StockModel> stocks = new ArrayList<StockModel>();
			if (symbol == null) {
				stockRepository.findAll().forEach(stocks::add);
			} else {
				stockRepository.findBySymbol(symbol).forEach(stocks::add);
			}
			if(stocks.isEmpty()) {
				return null;
			}
			return stocks;
		} catch (Exception e) {
			return null;
		}
	}

}
