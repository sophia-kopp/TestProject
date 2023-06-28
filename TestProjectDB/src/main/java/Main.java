import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Read in the data
		List<Trade> listOfTrades = new ArrayList<Trade>();

		File datei = new File("test-market.csv");
		Scanner scan = null;
		try {
			scan = new Scanner(datei);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}

		//Assign Data to Trade Attributes
		while(scan.hasNext()) {	
			String newTrade = scan.nextLine();
			String[] splittedTrade = newTrade.split(";");
			
			String dateAndTime = splittedTrade[0];
			String[] splittedDateAndTime = dateAndTime.split(" ");
			String date = splittedDateAndTime[0];
			String time = splittedDateAndTime[1];
			
			String companyTicker = splittedTrade[1];
			
			String priceWithComma = splittedTrade[2].replace(",", ".");
			double price = Double.parseDouble(priceWithComma);
			
			int numberOfSecuritiesTraded = Integer.parseInt(splittedTrade[3]);
			
			Trade trade = new Trade(date, time, companyTicker, price, numberOfSecuritiesTraded);
			
			listOfTrades.add(trade);
			
		}

		//Sort per Ticker
		String TickerABC = "ABC";
		String TickerMEGA = "MEGA";
		String TickerNGL = "NGL";
		String TickerTRX = "TRX";
		
		List<Trade> TradesPerABC = new ArrayList<Trade>();
		List<Trade> TradesPerMEGA = new ArrayList<Trade>();
		List<Trade> TradesPerNGL = new ArrayList<Trade>();
		List<Trade> TradesPerTRX = new ArrayList<Trade>();
		
		for (Trade trade : listOfTrades) {
			if (trade.getCompanyTicker().equals(TickerABC)){
				TradesPerABC.add(trade);
			} else if
			(trade.getCompanyTicker().equals(TickerMEGA))
				{TradesPerMEGA.add(trade);
			} else if
				(trade.getCompanyTicker().equals(TickerNGL)){
				TradesPerNGL.add(trade);
			}else if
				(trade.getCompanyTicker().equals(TickerTRX)){
				TradesPerTRX.add(trade);	
			}
		}


		//Values to be returned
		double openPrice = 0;
		double closePrice = 0;
		double highestPrice = 0;
		double lowestPrice = 0;
		double dailyTradedVolume = 0;
		
		//Preparation for calculating ABC
		List<List> ABCPerDate = new ArrayList<List>();
		List<Trade> currentTradesPerDate1 = new ArrayList<Trade>();
		String currentDate1 = "";
		for (Trade trade : TradesPerABC) {
			if (currentDate1.equals(trade.getDate())) {
				currentTradesPerDate1.add(trade);
			} else {
				currentDate1 = trade.getDate();
				List<Trade> newTradesPerDate = new ArrayList<Trade>();
				currentTradesPerDate1 = newTradesPerDate;
				ABCPerDate.add(currentTradesPerDate1);
			}
		}
	
		//Calculating ABC
		System.out.println("--ABC--");
		for (List<Trade> tradeList : ABCPerDate) {
			
			//Opening Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetOpenPrice());
			openPrice = tradeList.get(0).getPrice();
			
			//Closing Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetClosePrice());
			closePrice = tradeList.get(0).getPrice();
			
			//HighestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetHighestPrice());
			highestPrice = tradeList.get(0).getPrice();
			
			//LowestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetLowestPrice());
			lowestPrice = tradeList.get(tradeList.size()-1).getPrice();
			
			//dailyTradedVolume
			for (Trade trade: tradeList) {
				dailyTradedVolume += (trade.getNumberOfSecuritiesTraded()*trade.getPrice());
			}
			System.out.println(
					tradeList.get(0).getDate() + ":"
					+ "\nOpening Price is: "+ openPrice
					+ "\nClosing Price is: " + closePrice
					+ "\nHighest Price is: " + highestPrice
					+ "\nLowest Price is: " + lowestPrice
					+ "\nDaily Traded Volume is: " + dailyTradedVolume
					+ "\n");
		}
		
		//Preparation for calculating MEGA
		List<List> MEGAPerDate = new ArrayList<List>();
		List<Trade> currentTradesPerDate2 = new ArrayList<Trade>();
		String currentDate2 = "";
		for (Trade trade : TradesPerMEGA) {
			if (currentDate2.equals(trade.getDate())) {
				currentTradesPerDate2.add(trade);
			} else {
				currentDate2 = trade.getDate();
				List<Trade> newTradesPerDate = new ArrayList<Trade>();
				currentTradesPerDate2 = newTradesPerDate;
				MEGAPerDate.add(currentTradesPerDate2);
			}
		}
		
		//Calculating MEGA
		System.out.println("--MEGA--");
		for (List<Trade> tradeList : MEGAPerDate) {
			
			//Opening Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetOpenPrice());
			openPrice = tradeList.get(0).getPrice();
			
			//Closing Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetClosePrice());
			closePrice = tradeList.get(0).getPrice();
			
			//HighestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetHighestPrice());
			highestPrice = tradeList.get(0).getPrice();
			
			//LowestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetLowestPrice());
			lowestPrice = tradeList.get(tradeList.size()-1).getPrice();
			
			//dailyTradedVolume
			for (Trade trade: tradeList) {
				dailyTradedVolume += (trade.getNumberOfSecuritiesTraded()*trade.getPrice());
			}
			System.out.println(
					tradeList.get(0).getDate() + ":"
					+ "\nOpening Price is: "+ openPrice
					+ "\nClosing Price is: " + closePrice
					+ "\nHighest Price is: " + highestPrice
					+ "\nLowest Price is: " + lowestPrice
					+ "\nDaily Traded Volume is: " + dailyTradedVolume
					+ "\n");
		}
		
		
		//Preparation for calculating NGL
		List<List> NGLPerDate = new ArrayList<List>();
		List<Trade> currentTradesPerDate3 = new ArrayList<Trade>();
		String currentDate3 = "";
		for (Trade trade : TradesPerNGL) {
			if (currentDate3.equals(trade.getDate())) {
				currentTradesPerDate3.add(trade);
			} else {
				currentDate3 = trade.getDate();
				List<Trade> newTradesPerDate = new ArrayList<Trade>();
				currentTradesPerDate3 = newTradesPerDate;
				NGLPerDate.add(currentTradesPerDate3);
			}
		}
		
		System.out.println("--NGL--");
		for (List<Trade> tradeList : NGLPerDate) {
			
			//Opening Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetOpenPrice());
			openPrice = tradeList.get(0).getPrice();
			
			//Closing Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetClosePrice());
			closePrice = tradeList.get(0).getPrice();
			
			//HighestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetHighestPrice());
			highestPrice = tradeList.get(0).getPrice();
			
			//LowestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetLowestPrice());
			lowestPrice = tradeList.get(tradeList.size()-1).getPrice();
			
			//dailyTradedVolume
			for (Trade trade: tradeList) {
				dailyTradedVolume += (trade.getNumberOfSecuritiesTraded()*trade.getPrice());
			}
			System.out.println(
					tradeList.get(0).getDate() + ":"
					+ "\nOpening Price is: "+ openPrice
					+ "\nClosing Price is: " + closePrice
					+ "\nHighest Price is: " + highestPrice
					+ "\nLowest Price is: " + lowestPrice
					+ "\nDaily Traded Volume is: " + dailyTradedVolume
					+ "\n");
		}
		
		//Preparation for calculating TRX
		List<List> TRXPerDate = new ArrayList<List>();
		List<Trade> currentTradesPerDate4 = new ArrayList<Trade>();
		String currentDate4 = "";
		for (Trade trade : TradesPerTRX) {
			if (currentDate4.equals(trade.getDate())) {
				currentTradesPerDate4.add(trade);
			} else {
				currentDate4 = trade.getDate();
				List<Trade> newTradesPerDate = new ArrayList<Trade>();
				currentTradesPerDate4 = newTradesPerDate;
				TRXPerDate.add(currentTradesPerDate4);
			}
		}
		
		System.out.println("--TRX--");
		for (List<Trade> tradeList : TRXPerDate) {
			
			//Opening Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetOpenPrice());
			openPrice = tradeList.get(0).getPrice();
			
			//Closing Price
			Collections.sort(tradeList, new tradeComparatorByTimeToGetClosePrice());
			closePrice = tradeList.get(0).getPrice();
			
			//HighestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetHighestPrice());
			highestPrice = tradeList.get(0).getPrice();
			
			//LowestPrice
			Collections.sort(tradeList, new tradeComparatorByTimeToGetLowestPrice());
			lowestPrice = tradeList.get(tradeList.size()-1).getPrice();
			
			//dailyTradedVolume
			for (Trade trade: tradeList) {
				dailyTradedVolume += (trade.getNumberOfSecuritiesTraded()*trade.getPrice());
			}
			System.out.println(
					tradeList.get(0).getDate() + ":"
					+ "\nOpening Price is: "+ openPrice
					+ "\nClosing Price is: " + closePrice
					+ "\nHighest Price is: " + highestPrice
					+ "\nLowest Price is: " + lowestPrice
					+ "\nDaily Traded Volume is: " + dailyTradedVolume
					+ "\n");
		}
		
		
		//Preparation to calculate per TickerIndex
//		String currentIndex = "";
//		for (Trade trade: listOfTrades) {
//			if (currentIndex.equals(trade.getCompanyTicker())) {
//				currentTradesPerIndex.add(trade);
//			} else {
//				currentIndex = trade.getCompanyTicker();
//				List<Trade> newTradesPerIndex = new ArrayList<Trade>();
//				currentTradesPerIndex = newTradesPerIndex;
//				listOfAllListsPerIndex.add(currentTradesPerIndex);
//			}
//		}
//	}
	//Sort for calculating per TickerIndex
	
//		per Index
		/*
		 * All the same, BUT
		 * Go trough list allTrades
		 * Make an array per Index
		 * then per date sort by price in descending order
		 * .get[0]
		 */

}
}
