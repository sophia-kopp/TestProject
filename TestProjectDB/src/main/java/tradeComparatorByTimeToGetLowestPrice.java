import java.util.Comparator;

public class tradeComparatorByTimeToGetLowestPrice implements Comparator<Trade> {

//	@Override
//	public int compare(Trade trade1, Trade trade2) {
//	return  (int)trade2.getPrice()-(int)trade1.getPrice();
//	}
	
	@Override
	public int compare(Trade trade1, Trade trade2) {
	return  Integer.compare((int)trade2.getPrice(),(int)trade1.getPrice());
	}
	
}