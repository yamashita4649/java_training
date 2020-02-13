/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 * Copyright (C) 2019 Yoshiki Shibata. All rights reserved.
 */
package ch14.ex10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.<br><br>
 *
 * [Instruction]
 * <ul>
 *  <li> Implement one constructor and three methods. </li>
 *  <li> Don't forget to write a Test program to test this class. </li>
 *  <li> Pay attention to @throws tags in the javadoc. </li>
 *  <li> If needed, you can put "synchronized" keyword to methods. </li>
 *  <li> All classes for implementation must be private inside this class. </li>
 *  <li> Don't use java.util.concurrent package. </li>
 *  <li> Don't use {@link java.lang.Thread#interrupt}  method to stop a thread</li>
 *  </ul>
 *
 *  @author Yoshiki Shibata
 */
public class ThreadPool {

    List<executer> mThreadList = new ArrayList<executer>();
    private final int mQueueSize;
    private final int mThreadNum;
    private boolean isStarted = false;
    private int mCurrentThreadNum = 0;
    private Queue<Runnable> mRunnableQueue = new ArrayDeque<>();


    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) {
        if(queueSize < 1 || numberOfThreads < 1) {
            throw new IllegalArgumentException("ueueSize or numberOfThreads is less than 1");
        }

        mQueueSize = queueSize;
        mThreadNum = numberOfThreads;
        for(int i = 0;i < mThreadNum;i++) {
            mThreadList.add(new executer());
        }
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    synchronized public void start() {
        if(isStarted) {
            throw new IllegalStateException("threads has been already started");
        } else {
            isStarted = true;
            for(Thread t : mThreadList) {
                t.start();
            }
        }
    }

    /**
     * Stop all threads gracefully and wait for their terminations.
     * All requests dispatched before this method is invoked must complete
     * and this method also will wait for their completion.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() {
        if(isStarted) {
            isStarted = false;
            for(executer td : mThreadList) {
                try {
//                    synchronized (td.getLock()) {
//                        td.getLock().notify();
//                    }
                    td.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new IllegalStateException("hreads has not been started.");
        }
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
//    synchronized public void dispatch(Runnable runnable) {
//        if(runnable == null) {
//            throw new NullPointerException("runnable is null");
//        }
//        if(!isStarted) {
//            throw new IllegalStateException("pool has not been started yet");
//        }
//        int queSize;
//        while(true) {
//
//            synchronized (mRunnableQueue) {
//                queSize = mRunnableQueue.size();
//            }
//            if(queSize >= mQueueSize) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("MAX:" + queSize);
//            } else {
//                synchronized (mRunnableQueue) {
//                    mRunnableQueue.add(runnable);
//                }
//                for(executer t : mThreadList) {
//                    if(t.getState() == Thread.State.WAITING) {
//                        synchronized (t.getLock()) {
//                            System.out.println("WAITING:" + queSize);
//                            t.getLock().notify();
//                        }
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//
//    }
//
//    class executer extends Thread {
//        Object lock = new Object();
//
//        public Object getLock() {
//            return lock;
//        }
//
//        public void run() {
//            while (isStarted) {
//                synchronized (lock) {
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                Runnable run;
//                int count;
//                synchronized (mRunnableQueue) {
//                    run = mRunnableQueue.poll();
//                    count = mRunnableQueue.size();
//                }
//
//                if (run != null) {
//                    System.out.println("count:" +count);
//                    run.run();
//                }
//            }
//        }
//
//    }





    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    synchronized public void dispatch(Runnable runnable) {
        if(runnable == null) {
            throw new NullPointerException("runnable is null");
        }
        if(!isStarted) {
            throw new IllegalStateException("pool has not been started yet");
        }

        while(true) {
            int queSize;
            synchronized (mRunnableQueue) {
                queSize = mRunnableQueue.size();
            }
            if(queSize >= mQueueSize) {

            } else {
                synchronized (mRunnableQueue) {
                    mRunnableQueue.add(runnable);
                }


                break;
            }
        }

    }

    class executer extends Thread {
        public void run() {
            while(true) {
                Runnable run;
                synchronized (mRunnableQueue) {
                    run = mRunnableQueue.poll();
                }

                if(run != null) {
//                    System.out.println("count:");
                    run.run();
                } else {
                    if(!isStarted) {
                        break;
                    }
                }
            }
        }
    }
}