package ch14.ex05;

public class CreateThread {

    private Sum sum;

    CreateThread() {
        sum = new Sum();
    }

    public void createThread(Runnable target) {
        Thread thread = new Thread(target);
        thread.start();
    }

    public void callSums() {
        for(int i = 0; i<5 ;i++) {
            createThread(new Runnable() {
                @Override
                public void run() {
                    Sum.addValue(2);
                }
            });
        }
        createThread(new Runnable() {
            @Override
            public void run() {
                sum.removeValue(3);
            }
        });
    }

    public static void main(String args[]){
        new CreateThread().callSums();
    }
}
