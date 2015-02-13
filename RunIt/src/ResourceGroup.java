/**
 * Created by Winniewlz on 10/23/14.
 */
public class ResourceGroup {
    private Resource[] resources;
    public ResourceGroup() {
        resources = new Resource[5];
        resources[0] = new Resource(160000,10000,1000000,0);
        resources[1] = new Resource(320000,20000,2000000,1);
        resources[2] = new Resource(240000,30000,3000000,2);
        resources[3] = new Resource(160000,10000,1000000,3);
        resources[4] = new Resource(320000,20000,2000000,4);
    }
    public Resource getResource(int res_num) {
        return resources[res_num];
    }
    public int getResourceCount() {
        return resources.length;
    }
    public void printAllServerReq() {
        for (Resource res : resources) {
            System.out.println("location:" + String.valueOf(res.getLocation()) + " requests:" + String.valueOf(res.getReqCount()));
        }
    }

    public void printAllServerUsedResource() {
        for (Resource res : resources) {
            System.out.println("location:" + String.valueOf(res.getLocation()) + " requests:\n" + " Ram: " +
                    String.valueOf(res.getUsedRam(res.getInitialRam()))+" CPU: "+String.valueOf(res.getUsedCpu(res.getInitialCpu()))+" Storage: " +String.valueOf(res.getUsedStorage(res.getInitialStorage())));
        }
    }



}
