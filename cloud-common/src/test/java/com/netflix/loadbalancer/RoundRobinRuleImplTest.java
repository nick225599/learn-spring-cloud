package com.netflix.loadbalancer;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
public class RoundRobinRuleImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {


        List<Server> serverList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            Server server = new Server("server" + i);
            server.setAlive(true);
            server.setReadyToServe(true);
            serverList.add(server);
        }
        ILoadBalancer loadBalancer = mock(ILoadBalancer.class);
        when(loadBalancer.getReachableServers()).thenReturn(serverList);
        when(loadBalancer.getAllServers()).thenReturn(serverList);

        RoundRobinRule rule = new RoundRobinRule(loadBalancer);


        Field field = RoundRobinRule.class.getDeclaredField("nextServerCyclicCounter");
        field.setAccessible(true);
        field.set(rule, new AtomicInteger(Integer.MAX_VALUE - 10));

        for (int i = 0; i < 100; i++) {
            Object object = field.get(rule);
            AtomicInteger nextServerCyclicCounter = (AtomicInteger)object;
            log.info("nextServerCyclicCounter 值为 {}", nextServerCyclicCounter);
            Server server = rule.choose(null);
            String serverId = server.getId();

            log.info("第 {} 次请求，调用服务器 ID 为 {}", i, serverId);
        }

    }
}