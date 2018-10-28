package src.main.algorithm;

import src.main.log.LogFileReader;
import src.main.model.PhoneCall;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class CostAlgorithm {


    private static Map<String,Long>  getPhoneCallWithTotalDuration(List<PhoneCall> calls){
        Set<String> phoneNumbers =calls.stream().map(call -> call.getPhoneNumber()).collect(Collectors.toSet());
        Map<String,Long> phoneDurationsTotal = new HashMap<>();
               phoneNumbers.stream().forEach(number->{
            List<PhoneCall> groupedCalls = calls.stream().filter(call-> call.getPhoneNumber()==number).collect(Collectors.toList());
            List<Long> durations = groupedCalls.stream().map(call ->call.getCallDuration()).collect(Collectors.toList());
            Long totalDuration = durations.stream().reduce((x,y)-> x+y).get();
            phoneDurationsTotal.put(number,totalDuration);



        });
               return phoneDurationsTotal;


    }






    public static Long calculateCost(List<String> callLines){
        LogFileReader logFileReader = new LogFileReader();
        AtomicReference<Long> callCost = new AtomicReference<>(0l);

        try{

            PhoneCall promotedCall =null;
            List<PhoneCall> calls = logFileReader.generatePhoneCall(callLines);
            List<Long> callDurations = calls.stream().map(call-> call.getCallDuration()).collect(Collectors.toList());
            Long mostLongCallTimes = Collections.max(callDurations);
            List<PhoneCall> mostLongCalls = calls.stream().filter(phoneCall -> phoneCall.getCallDuration()== mostLongCallTimes).collect(Collectors.toList());
            if(mostLongCalls.size()>=1){
                Map<String,Long> phonecallWithDur = getPhoneCallWithTotalDuration(mostLongCalls);
                Long maxDurValues =Collections.max( phonecallWithDur.values());
                String maxDurPhoneNumber = phonecallWithDur.entrySet().stream().filter(entry ->
                    entry.getValue()== maxDurValues
                ).collect(Collectors.toList()).iterator().next().getKey();

                promotedCall = mostLongCalls.stream().filter(call -> call.getPhoneNumber().equals(maxDurPhoneNumber)).collect(Collectors.toList()).get(0);

                PhoneCall finalPromotedCall = promotedCall;
                calls.stream().forEach(call -> {


                    if(!call.getCallId().equals(finalPromotedCall.getCallId())){
                        Long callDuration = call.getCallDuration();
                        if(callDuration< 300l){
                            callCost.set( callCost.get() + 3 * call.getCallDuration());
                        }
                        else{
                            callCost.set( callCost.get() + 150 * call.getSartedMinutes());
                        }
                    }

                });

            }





        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return  callCost.get();

    }
}
