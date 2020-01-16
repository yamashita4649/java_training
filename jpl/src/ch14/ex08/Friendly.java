package ch14.ex08;

public class Friendly {
    private Friendly partner;
    private String name;
    private static final Object lock = new Object();

    public Friendly(String name) {
        this.name = name;
    }

    public void hug() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " in " + name + ".hug() trying to invoke " + partner.name + " .hugBack()");
            partner.hugBack();
        }
    }

    private void hugBack() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " in " + name + ".hugBack()");
        }
    }

    public void becomeFriend(Friendly partner) {
        this.partner = partner;
    }

    public static void main (String[] args) {
        final Friendly jareth = new Friendly("jareth");
        final Friendly cory = new Friendly("cory");

        jareth.becomeFriend(cory);
        cory.becomeFriend(jareth);

        new Thread(new Runnable() {
            @Override
            public void run() {
                jareth.hug();
            }
        },"Threqad1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cory.hug();
            }
        },"Threqad2").start();

    }
}
