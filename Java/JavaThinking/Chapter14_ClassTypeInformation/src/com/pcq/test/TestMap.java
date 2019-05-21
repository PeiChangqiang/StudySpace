package com.pcq.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    static Map<Integer, String> map = new HashMap<Integer, String>();

    public static void main(String[] args) {
        map.put(1, "呵呵");
        map.put(2, "哈哈");
        map.put(3, "嘻嘻");
        for(Integer i : map.keySet()) {
            String str = map.get(i);
            System.out.println(i + ":" + str);
        }
    }
}
