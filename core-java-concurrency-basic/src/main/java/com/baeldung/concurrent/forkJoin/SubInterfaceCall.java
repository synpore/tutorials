package com.baeldung.concurrent.forkJoin;

import java.util.concurrent.RecursiveTask;

public class SubInterfaceCall extends RecursiveTask<Integer> {



    @Override
    protected Integer compute() {
        try {
            Thread.currentThread().sleep(4000);
            System.out.println("SubInterfaceCall finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 8;
    }
}
