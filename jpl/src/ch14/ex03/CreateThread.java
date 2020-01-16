package ch14.ex03;

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

                    sum.addValue(2);
                }
            });
        }
    }

    public static void main(String args[]){
        new CreateThread().callSums();
    }
}
