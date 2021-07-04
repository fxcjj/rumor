package com.vic.concurrency.kuangshen.multithread.v24;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerTest {


}


class Producer extends Thread {

    Storage storage;

    Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        List<String> data = storage.getData();
        if(data.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            data.add("haha");

        }
    }
}


class Storage {
    private List<String> data = new ArrayList<>();

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

