package org.scs.learn.spring.controllers;

import org.apache.dubbo.common.io.Bytes;

import java.util.Map;
import java.util.TreeMap;

public class Temp {
    public static void main(String[] args) {
        // Q: 怎么将 invokers 映射到 hash 环上？
        // A: 将每个 invoker 的地址计算 md5 值，再计算 hash 值，
        // 一个地址加随机数，算 {hash.nodes|160} 次 hash 值，放到一个 treeMap 中，成为一个 hash 环
        Map<Long, Object> virtualInvokers = new TreeMap<>();


        // 获取 hash.nodes 配置，默认 160
        int replicaNumber = 160 * 4 * 4 * 4 * 32;
        String address = "https://www.baidu.com";
        for (int i = 0; i < replicaNumber / 4; i++) {
            // 16 字节的 md5 码
            byte[] digest = Bytes.getMD5(address + i);
            for (int h = 0; h < 4; h++) {
                long m = hash(digest, h);
                // 取 16 位字节中的 0~3, 4~7, 8~11, 12~15 各计算一次 hash 值
                virtualInvokers.put(m, address);
            }
        }
        // 327680
        System.out.println(replicaNumber);
        // 327668 hash 冲突次数固定的
        System.out.println(virtualInvokers.size());
    }


    public static long hash(byte[] digest, int number) {
        return (
                ((long) (digest[3 + number * 4] & 0xFF) << 24)
                        | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                        | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                        | (digest[number * 4] & 0xFF)
        ) & 0xFFFFFFFFL;
    }

    public static void printMd5(byte[] md5bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : md5bytes) {
            builder.append(b).append("\t")
                    .append(Integer.toBinaryString(b)).append("\t")
                    .append(temp(b)).append("\n");
        }
        System.out.println(builder);
    }

    public static String temp(byte tByte) {
        String tString = Integer
                .toBinaryString((tByte & 0xFF) + 0x100)
                .substring(1);
        return tString;
    }


}
