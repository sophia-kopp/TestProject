
import java.util.ArrayList;
import java.util.List;

public class Trade{
	String date;
	String time;
	String companyTicker;
	double price;
	int numberOfSecuritiesTraded;
	
	List<Trade> listOfTrades = new ArrayList<Trade>();

	public Trade(String date, String time, String companyTicker, double price, int numberOfSecuritiesTraded) {
		this.date = date;
		this.time = time;
		this.companyTicker = companyTicker;
		this.price = price;
		this.numberOfSecuritiesTraded = numberOfSecuritiesTraded;
	}

	public void addTradesToList(Trade trade) {
		listOfTrades.add(trade);
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCompanyTicker() {
		return companyTicker;
	}

	public void setCompanyTicker(String companyTicker) {
		this.companyTicker = companyTicker;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberOfSecuritiesTraded() {
		return numberOfSecuritiesTraded;
	}

	public void setNumberOfSecuritiesTraded(int numberOfSecuritiesTraded) {
		this.numberOfSecuritiesTraded = numberOfSecuritiesTraded;
	}

	public List<Trade> getListOfTrades() {
		return listOfTrades;
	}

	public void setListOfTrades(List<Trade> listOfTrades) {
		this.listOfTrades = listOfTrades;
	}

	




}
