/**
 * Created by Winniewlz on 10/23/14.
 */
public class Request {
    private long timestamp_ms = 0;
    private int ramNeeded = 0;
    private int cpuNeeded = 0;
    private int storageNeeded = 0;
    private int req_num = 0;
    public Request(long timestamp, int ram, int cpu, int storage, int req_num_) {
        timestamp_ms = timestamp;
        cpuNeeded = cpu;
        storageNeeded = storage;
        req_num = req_num_;
        ramNeeded = ram;
;
    }

    public int reqNum() {
       return req_num;
    }

    public long getTimestamp_ms(){ return timestamp_ms; }

    public long getDifTimeStamp_ms(long acceptTimestamp){return acceptTimestamp - timestamp_ms; }

    public int getCpuNeeded() {
        return cpuNeeded;
    }

    public int getStorageNeeded() {
        return storageNeeded;
    }

    public int getRamNeeded() {
        return ramNeeded;
    }

    public String toString() {
        return "##########\nRam needed:" + String.valueOf(ramNeeded) +" Storage needed:" + String.valueOf(storageNeeded)+" Cpu needed:" + String.valueOf(cpuNeeded)+ "\nTimestamp:" + String.valueOf(timestamp_ms);
    }

}
