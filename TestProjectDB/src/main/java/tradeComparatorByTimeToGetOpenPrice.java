import java.util.Comparator;

public class tradeComparatorByTimeToGetOpenPrice implements Comparator<Trade>{

	@Override
	public int compare(Trade trade1, Trade trade2) {
		return trade1.getTime().compareTo(trade2.getTime());
	}
}
