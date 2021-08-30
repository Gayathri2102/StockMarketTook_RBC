package com.example.StockMarketTool.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.StockMarketTool.model.StockModel;
import com.example.StockMarketTool.repository.StockRepository;
import com.example.StockMarketTool.service.StockService;


@RestController
@RequestMapping("/api")
public class StockController {

	@Autowired	
	StockRepository stockRepository;
	
	@Autowired
	StockService stockService;

	
	@PostMapping("/file-upload")
	public String uploadAllStocks(@RequestParam("file") MultipartFile file) {
		return stockService.uploadAllStocks(file);
	}
	
	@PostMapping("/stock")
	public String createStock(@RequestBody StockModel stock) {
		return stockService.createStock(stock);
	}
	
	
	@GetMapping("/stock/{symbol}")
	public List<StockModel> getAllStocks(@RequestParam(name = "symbol") String symbol) {
		return stockService.getAllStocks(symbol);
	}
	
}
