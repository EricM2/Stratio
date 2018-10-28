import src.main.algorithm.CostAlgorithm;
import src.main.log.LogFileReader;
import src.main.model.PhoneCall;

import java.util.List;

public class Main {

    public static void main(String[] args){
        LogFileReader logFileUtils = new LogFileReader();
        try {
            List<String> callLines = logFileUtils.genererateCallLinesFromLog();
           Long cost = CostAlgorithm.calculateCost(callLines);
           System.out.println("Total  Bill Cost:  "+ String.valueOf(cost) + " Cents");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
