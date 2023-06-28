# TestProject for the Deutsche Bank in Berlin
The TestProject is a project for the assessment in which we have to calculate the daily value of trades for each Company Ticker and a Company Ticker Index.
The part of the Company Ticker Index is missing in this project.

## Technologies
The project is created with:  
- JavaSE 1.8
- Eclipse IDE Version: 2023-03

### The TestProject package
''src/main/java/Main.java''
''src/main/java/Trade.java''
''src/main/java/tradeComparatorByTimeToGetClosePrice.java''
''src/main/java/tradeComparatorByTimeToGetHighestPrice.java''
''src/main/java/tradeComparatorByTimeToGetLowestPrice.java''
''src/main/java/tradeComparatorByTimeToGetOpenPrice.java''

### Data
The historical market log:  
''test-market.csv''

### Dependencies  
''pom.xml''

### Description
The application calculates the following data for each ticker and each day:
-open price 
-close price
-highest price
-lowest price
-daily traded volume

The data was taken from an csv-file with the historical market log.
The data for the Ticker Index such as the testing is still missing.


### For the output
Run:   
''src/main/java/Main.java''

Output will be printed to your console in the following format:  

--TICKER1--
yyyy-mm-dd:
Opening price is:
Closing price is:
Highest price is:
Lowest price is:
Daily traded volume is:

yyyy-mm-dd:
.
.
.

--TICKER2--
yyyy-mm-dd:
.
.
.
