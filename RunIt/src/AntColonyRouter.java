import java.util.*;
/**
 * Created by Winniewlz on 10/23/14.
 */
public class AntColonyRouter {
    // reference to some resources that will accept the requests
    ResourceGroup group;
    int[] pheromone;  // indices correspond to res number
    int[] costs;      // indices correspond to res num
    int[] Path;       //history path.
    AntColonyRouter(ResourceGroup group_) {
        group = group_;
        pheromone = new int[group.getResourceCount()];
        costs = new int[group.getResourceCount()];

        for (int i = 0; i < pheromone.length; ++i){
            pheromone[i]=1;
        }
    }

    public void Route(Request req) {
       Resource res;
       do {
           res = group.getResource(antFoundResource());
       } while (!res.accept(req));
        System.out.println("Server I choose: #" + String.valueOf(res.getLocation()));
       long dif_timestamp_ms = req.getDifTimeStamp_ms(System.currentTimeMillis());
       int new_cost = computeCost(res);
       costs[res.getLocation()] = new_cost;
        // update phero
       pheromone[res.getLocation()] += 1;
       EvaporatePhero();
       System.out.print("Pheromone left at path to each server: ");
       for (int i = 0; i < pheromone.length; ++i) {
           System.out.print("#"+ i + ": " + pheromone[i] + "  ");
       }
       System.out.println();
    }

    private void EvaporatePhero() {
        for (int i = 0; i < pheromone.length; ++i) {
            int cost = costs[i];
            int pheromone_ = pheromone[i];
            if ((pheromone_ - cost)>0) {
                pheromone[i] = pheromone_ - cost/6;
            }
        }
    }

    private int antFoundResource() {
        Random rand = new Random();
        int sum = 0;
        for (int i = 0; i < pheromone.length; ++i) {
            sum += pheromone[i];
        }
        int rand_n = rand.nextInt(sum);
        rand_n++;

        int k = 0;

        while (rand_n>0 && k <(pheromone.length)){
            rand_n -= pheromone[k];
            k+=1;
        }
        k--;
        return k;
    }

    private int computeCost(Resource res) {
        //System.out.print("Cost of chosen path: ");
        //System.out.println(6000 + res.getLocation() - res.getRam() - res.getCpu()  - res.getStorage());
        //return 6000 + res.getLocation() - res.getRam() - res.getCpu()  - res.getStorage();
        return res.getLocation()*2 + (int)(240000/(res.getRam()+1) + 20000/(res.getCpu()+1) + 2000000/(res.getStorage()+1));
    }

}
