package com.baeldung.concurrent.forkJoin;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;

//major service task
public class MajorServiceTask  extends RecursiveTask<String> {

    private MajorService majorService;

    public MajorServiceTask(MajorService majorService) {
    }

    @Override
    protected String compute() {

        //interface1 call
        SubInterfaceCall subInterfaceCall = new SubInterfaceCall();
        subInterfaceCall.fork();

        SubInterfaceCall2 subInterfaceCall2 = new SubInterfaceCall2();
        subInterfaceCall2.fork();
        //majorService do something;

        return subInterfaceCall.join() + subInterfaceCall2.join() + "@final result";
    }

    public static void main(String[] args) {
        try {
            Stopwatch stopwatch=Stopwatch.createStarted();
            ForkJoinPool forkJoinPool = new ForkJoinPool(4);
            ForkJoinTask<String> result = forkJoinPool.submit(new MajorServiceTask(()->{
            }));

            System.out.println(result.get());

            System.out.println("totally cost "+stopwatch.elapsed(TimeUnit.SECONDS)+" s");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
