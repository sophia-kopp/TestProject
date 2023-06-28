import java.util.Comparator;

public class tradeComparatorByTimeToGetClosePrice implements Comparator<Trade>{
	
	@Override
	public int compare(Trade trade1, Trade trade2) {
		return trade2.getTime().compareTo(trade1.getTime());
	}
}
