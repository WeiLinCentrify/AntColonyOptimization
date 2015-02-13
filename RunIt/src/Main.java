import java.util.*;
public class Main {
    static int req_num = 0;
    public static final Request RandReq() {
        Random rand = new Random();
        int r = rand.nextInt(4);
        int[][] types = new int[][]{{2, 1, 32},{6,2,128},{12,4,256},{64,4,64},{32,16,64}};
        return new Request(System.currentTimeMillis(), types[r][0], types[r][1], types[r][2], req_num++);
    }

    public static void main(String[] args) {
        long generate_Timestamp = System.currentTimeMillis();
        ResourceGroup group = new ResourceGroup();
        AntColonyRouter router = new AntColonyRouter(group);
        for (int i = 0; i < 1000; ++i) {
            Request r = RandReq();
            System.out.println(r.toString());
            router.Route(r);
        }
        long accept_Timestamp = System.currentTimeMillis();
        long different_time = accept_Timestamp - generate_Timestamp;
        System.out.println("Average processing time is: " + String.valueOf(different_time));
        group.printAllServerReq();
        System.out.println();
        group.printAllServerUsedResource();
    }
}
