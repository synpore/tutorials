package com.baeldung.concurrent.forkJoin;

import java.util.concurrent.RecursiveTask;

public class SubInterfaceCall2 extends RecursiveTask<String> {


    @Override
    protected String compute() {
        try {
            Thread.currentThread().sleep(8000);
            System.out.println("SubInterfaceCall2 finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
