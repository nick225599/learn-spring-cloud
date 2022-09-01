package scs.learn.common;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRoundRule implements IRule {

    private final AtomicInteger count;

    ILoadBalancer iLoadBalancer;

    public MyRoundRule() {
        count = new AtomicInteger(0);
        count.incrementAndGet();
    }

    @Override
    public Server choose(Object o) {
        List<Server> reachableServers = iLoadBalancer.getReachableServers();
        int reachableServersNum = reachableServers.size();
        List<Server> allServers = iLoadBalancer.getAllServers();
        int allServersNum = allServers.size();
        int nextIndex = incrementAndModel(allServersNum);
        return allServers.get(nextIndex);
    }

    private int incrementAndModel(int allServersNum) {
        while (true) {
            int l = count.get();
            int index = (l + 1) % allServersNum;
            if (count.compareAndSet(l, l + 1)) {
                return index;
            }
        }
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return iLoadBalancer;
    }

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        double s = i/1000.0;
        double min = s/60;
        double h = min/60;
        double day = h/24;
        System.out.println("day: "+day);
    }
}
