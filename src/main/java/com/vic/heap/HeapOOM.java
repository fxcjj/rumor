package com.vic.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * heap out of memory
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author 罗利华
 * date: 2020/3/26 19:39
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
