package src.main.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertDigits {
    private static List<String> zeroDigits = Arrays.asList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09");

    public static  int getValueFromDigits ( String digits){
        if(zeroDigits.contains(digits))
            return getFromzeroDigit(digits);
        else
            return Integer.valueOf(digits);
    }


    private static int getFromzeroDigit(String digit) {

        if (digit.equals("00")) return 0;
        if (digit.equals("01")) return  1;
        if (digit.equals("02")) return 2;
        if (digit.equals("03")) return  3;
        if (digit.equals("04")) return  4;
        if (digit.equals("05")) return  5;
        if (digit.equals("06")) return  6;
        if (digit.equals("07")) return  7;
        if (digit.equals("08")) return  8;
        if (digit.equals("09")) return 9;
        else return 0;



    }
}
