package src.main.model;

import src.main.Utils.CallLineUtil;

import java.util.UUID;

public class PhoneCall {
    UUID callId;
    private int hour;
    private int min ;
    private int ss;
    private String phoneNumber;

    public UUID getCallId() {
        return callId;
    }

    public void setCallId(UUID callId) {
        this.callId = callId;
    }

    public PhoneCall(String callLine, UUID id ){
        this.callId = id;
        this.hour= CallLineUtil.getHour(callLine);
        this.min= CallLineUtil.getMM(callLine);
        this.ss = CallLineUtil.getSS(callLine);
        this.phoneNumber= CallLineUtil.getPhoneNumber(callLine);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public long getCallDuration(){
        return Long.valueOf(this.getHour()*3600) + Long.valueOf(this.getMin()*60) + Long.valueOf(this.getSs());
    }
    public long getSartedMinutes(){
        long minutes = Long.valueOf(this.getHour()*60) + Long.valueOf(this.getMin());
        if (this.getSs()> 0)
            minutes++;
        return minutes;
    }
}
