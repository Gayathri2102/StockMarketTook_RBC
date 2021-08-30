package com.example.StockMarketTool.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.opencsv.bean.CsvDate;
import io.swagger.annotations.ApiModelProperty;


@Document(collection = "stocks")
public class StockModel {
	
	@Id
	private String id;
	
	@ApiModelProperty(required = true)
	private String quarter;
	@ApiModelProperty(required = true)
	private String symbol;
	@ApiModelProperty(required = true)
	@CsvDate(value = "yyyy-MM-dd")
	private LocalDate date;
	@ApiModelProperty(required = true)
	private double openPrice;
	@ApiModelProperty(required = true)
	private double highPrice;
	@ApiModelProperty(required = true)
	private double lowPrice;
	@ApiModelProperty(required = true)
	private double closePrice;	
	@ApiModelProperty(required = true)
	private int volume;
	
	private double percentChangePrice;
	private double percentChangeVol_lw;
	private double prevWeekVolume;
	private double futureOpenPrice;
	private double futureClosePrice;
	private double percentChangeNextWeekPrice;
	private int daysToNextDivident;
	private double percentReturnNextDivident;
	
	
	//constructors
	
	public StockModel() {}
	
	public StockModel(String quarter, String symbol, LocalDate date, double openPrice, double highPrice, double lowPrice, 
			double closePrice, int volume, double percentChangePrice, double percentChangeVol_lw, double prevWeekVolume, 
			double futureOpenPrice, double futureClosePrice, double percentChangeNextWeekPrice, 
			int daysToNextDivident, double percentReturnNextDivident) {
		
		this.quarter = quarter;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.percentChangePrice = percentChangePrice;
		this.percentChangeVol_lw = percentChangeVol_lw;
		this.prevWeekVolume = prevWeekVolume;
		this.futureOpenPrice = futureOpenPrice;
		this.futureClosePrice = futureClosePrice;
		this.percentChangeNextWeekPrice = percentChangeNextWeekPrice;
		this.daysToNextDivident = daysToNextDivident;
		this.percentReturnNextDivident = percentReturnNextDivident;
	}
	
	
	//Getters
	
	public String getId() {
		return id;
	}
	
	public String getQuarter() {
		return quarter;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public double getOpenPrice() {
		return openPrice;
	}
	
	public double getHighPrice() {
		return highPrice;
	}
	
	public double getLowPrice() {
		return lowPrice;
	}
	
	public double getClosePrice() {
		return closePrice;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public double getPercentChangePrice() {
		return percentChangePrice;
	}
	
	public double getPercentChangeVolLastWeek() {
		return percentChangeVol_lw;
	}
	
	public double getPreviousWeekVolume() {
		return prevWeekVolume;
	}
	
	public double getFutureOpenPrice() {
		return futureOpenPrice;
	}
	
	public double getFutureClosePrice() {
		return futureClosePrice;
	}
	
	public double getPercentChangeNextWeekPrice() {
		return percentChangeNextWeekPrice;
	}
	
	public double getNoOfDaysToNextDivident() {
		return daysToNextDivident;
	}
	
	public double getPercentReturnNextDivident() {
		return percentReturnNextDivident;
	}
	
	
	//Setters
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	
	public void setStockSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setDate(LocalDate dt) {
		this.date = dt;
	}
	
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void setPercentChangePrice(double percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}
	
	public void setpercentChangeVolLastWeek(double percentChangeVol_lw) {
		this.percentChangeVol_lw = percentChangeVol_lw;
	}
	
	public void setPrevWeekVolume(double prevWeekVolume) {
		this.prevWeekVolume = prevWeekVolume;
	}
	
	public void setFutureOpenPrice(double futureOpenPrice) {
		this.futureOpenPrice = futureOpenPrice;
	}
	
	public void setfutureClosePrice(double futureClosePrice) {
		this.futureClosePrice = futureClosePrice;
	}
	
	public void setPercentChangeNextWeekPrice(double percentChangeNextWeekPrice) {
		this.percentChangeNextWeekPrice = percentChangeNextWeekPrice;
	}
	
	public void setNoOfDaysToNextDivident(int daysToNextDivident) {
		this.daysToNextDivident = daysToNextDivident;
	}
	
	public void setPercentReturnNextDivident(double percentReturnNextDivident) {
		this.percentReturnNextDivident = percentReturnNextDivident;
	}
	
	@Override
	public String toString() {
		return "Stock [Quarter" + quarter + ", Symbol" + symbol + ", Date" + date + ", OpenPrice" + openPrice +
				", HighPrice" + highPrice + ", LowPrice" + lowPrice + ", ClosePrice" + closePrice + 
				", Quantity" + volume + ", ChangePrice%" + percentChangePrice + 
				", LastWeekChangeVolume%" + percentChangeVol_lw + ", PreviousWeekVolume" + prevWeekVolume + ", "+ 
				"FutureOpenPrice" + futureOpenPrice + "FutureClosePrice" + futureClosePrice + 
				"NextWeekPriceChange%" + percentChangeNextWeekPrice + "NoOfDaysToNextDevident" + daysToNextDivident + 
				"PercentReturnNextDivident" + percentReturnNextDivident + "]";
	}
}

