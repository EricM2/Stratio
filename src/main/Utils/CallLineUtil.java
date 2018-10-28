package src.main.Utils;

public class CallLineUtil {
    public static  int getHour( String callLine){
        String[] parts = callLine.split(":");
        return  ConvertDigits.getValueFromDigits(parts[0]);

    }
    public static  int getMM( String callLine){
        String[] parts = callLine.split(":");
        return  ConvertDigits.getValueFromDigits(parts[1]);

    }
    public static  int getSS( String callLine){
        String[] parts = callLine.split(",");
        String[] parts1 = parts[0].split(":");
        return  ConvertDigits.getValueFromDigits(parts1[2]);

    }
    public static  String getPhoneNumber( String callLine){
        String[] parts = callLine.split(",");
        return  parts[1];

    }


}
