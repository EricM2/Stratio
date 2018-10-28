package src.main.log;

import src.main.Utils.CallLineUtil;
import src.main.model.PhoneCall;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class LogFileReader {


    public  List<String> genererateCallLinesFromLog() throws  Exception {


        List<String> callLines = new ArrayList<String>();

        ClassLoader classLoader = getClass().getClassLoader();
        File callLogs = new File(classLoader.getResource("call.log").getFile());
       FileInputStream fileInputStream = new FileInputStream(callLogs);
       String newLine ="";
       int counter = 0;
       int r;
       while ((r = fileInputStream.read()) != -1) {
           if(r != 10 && counter ==0){
               newLine = String.valueOf((char)r);
               counter++;

           }
           else if(counter> 0 && r!=10){
               newLine += String.valueOf((char)r);
           }
           else {
               callLines.add(newLine);
               counter=0;
           }


        }

        return callLines;

    }


    public static List<PhoneCall> generatePhoneCall(List<String> callLines){

        List<PhoneCall> phoneCalls = callLines.stream().map(callLine -> new PhoneCall(callLine,UUID.randomUUID())).collect(Collectors.toList());


        return phoneCalls;
    }
}
