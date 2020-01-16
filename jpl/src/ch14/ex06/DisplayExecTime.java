package ch14.ex06;

public class DisplayExecTime {

    Thread messageThread;
    Thread timeCountThread;

    DisplayExecTime() {
        messageThread = new MessageThread();
        timeCountThread = new TimeCountThread();
    }

    public void threadStart() {
        messageThread.start();
        timeCountThread.start();
    }

    public static void main(String args[]){
        new DisplayExecTime().threadStart();
    }

    class MessageThread extends Thread {

        String message;

        MessageThread() {
            message = "message";
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void displayMessage() {
            System.out.println(message);

        }

        @Override
        public void run() {
            while(true) {
                synchronized (this) {
                    try {
                        wait(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    displayMessage();
                }
            }
        }
    }

    class TimeCountThread extends Thread {

        long time;
        long startTime;

        TimeCountThread() {
            startTime = System.currentTimeMillis();
        }

        public void displayTime() {
            System.out.println(time + "ms");
        }

        @Override
        public void run() {
            while(true) {
                synchronized (this) {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    time = System.currentTimeMillis() - startTime;
                    displayTime();
                }
            }
        }
    }
}
