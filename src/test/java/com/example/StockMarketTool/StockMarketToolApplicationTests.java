package com.example.StockMarketTool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.StockMarketTool.model.StockModel;
import com.example.StockMarketTool.repository.StockRepository;
import com.example.StockMarketTool.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockMarketToolApplicationTests {
   
	@InjectMocks
	StockService mockedStockService;
	
	@Mock
	StockRepository mockedStockRepository;
	
	private List<StockModel> stocks;
	
	@BeforeEach
	public void setup()
	{
		stocks = new ArrayList<StockModel>();
		LocalDate today = LocalDate.of(2021, 8, 29);
		StockModel stock1 = new StockModel("1", "AATest", today, 11.12, 23.23, 10, 11.34,
				11, 23.34, 23.45, 12.34, 12.34, 0.18653, 56, 15, 1.974);
		StockModel stock2 = new StockModel("1", "AATest", today, 11.12, 23.23, 10, 11.34,
				11, 23.34, 23.45, 12.34, 12.34, 0.18653, 56, 15, 1.974);
		StockModel stock3 = new StockModel("1", "AATest", today, 11.12, 23.23, 10, 11.34,
				11, 23.34, 23.45, 12.34, 12.34, 0.18653, 56, 15, 1.974);
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
	}
	
	@Test
	public void getStockBySymbolTest() { 
		
		Mockito.when(mockedStockService.getAllStocks("AA")).thenReturn(stocks);
		
		List<StockModel> testStock = mockedStockRepository.findBySymbol("AA");
		assertEquals(3, testStock.size());
	}
	
	
	@Test
	public void instertStockTest() { 
		LocalDate today = LocalDate.of(2021, 8, 25);
		StockModel stock1 = new StockModel("1", "AATest2", today, 11.12, 23.23, 10, 11.34,
				11, 23.34, 23.45, 12.34, 12.34, 0.18653, 56, 15, 1.974);
		String response = mockedStockService.createStock(stock1); 
		assertEquals(response, "Saved-successfully");
	}
}
