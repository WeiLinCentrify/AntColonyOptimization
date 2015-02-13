/**
 * Created by Winniewlz on 10/23/14.
 */
import java.lang.System;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class Resource {
    private int ram = 0; // higher num = more ram
    private int cpu = 0;
    private int storage = 0;
    private int location = 0;
    private ArrayList<Request> requests;
    private int initial_ram = 0;
    private int initial_cpu = 0;
    private int initial_storage = 0;

    public Resource(int ram_, int cpu_, int storage_, int location_) {
        initial_cpu = cpu_;
        initial_ram = ram_;
        initial_storage = storage_;
        ram = ram_;
        cpu = cpu_;
        storage = storage_;
        location = location_;
        requests = new ArrayList<Request>();
    }
    public int getInitialRam() {
        return initial_ram;
    }
    public int getInitialCpu() {
        return initial_cpu;
    }
    public int getInitialStorage() {
        return initial_storage;
    }
    public int getRam() {
        return ram;
    }
    public int getCpu() {
        return cpu;
    }
    public int getStorage() {
        return storage;
    }
    public int getLocation() {
        return location;
    }
    public int getReqCount() {
        return requests.size();
    }

    public int getUsedRam(int initial_ram){return initial_ram - ram;}
    public int getUsedCpu(int initial_cpu){return initial_cpu - cpu;}
    public int getUsedStorage(int initial_storage){return initial_storage - storage;}

    public boolean accept(Request req) {
        if (req.getRamNeeded() > ram || req.getCpuNeeded() > cpu || req.getStorageNeeded() > storage) {
            return false;
        }
        requests.add(req);
        ram -= req.getRamNeeded();
        cpu -= req.getCpuNeeded();
        storage -= req.getStorageNeeded();
        System.out.println("Accepted request #" + String.valueOf(req.reqNum()) + " at: " + System.currentTimeMillis());
        return true;
    }

    public String toString() {
        return "ram: " + String.valueOf(ram) + "\n cpu: " + String.valueOf(cpu) + "\n stroage: " +String.valueOf(storage);
    }

}
