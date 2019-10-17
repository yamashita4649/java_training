package ch05.ex02;

public class BankAccount {
    private  long number;
    private long balance;
    private History mHistory = new History();

    public class Action {
        private String act;
        private long amount;
        Action(String act, long amount) {
            this.act = act;
            this.amount = amount;
        }
        public String toString() {
            return number + ": " + act + " " + amount;
        }
    }

    public void deposit(long amount) {
        balance += amount;
        mHistory.add(new Action("deposit",amount));
    }

    public void withdraw(long amount) {
        balance -= amount;
        mHistory.add(new Action("withdraw",amount));
    }

    public History getHistory() {
        return mHistory;
    }

    public class History {
        private static final int MAX_INDEX = 10;
        private Action[] mActionArray = new Action[MAX_INDEX];
        private int index = 0;
        private int currentIndex = 0;
        public void add(Action action) {
            if(index < MAX_INDEX) {
                mActionArray[index] = action;
            } else {
                for(int i = 0;i < MAX_INDEX-1; i ++) {
                    mActionArray[i] = mActionArray[i + 1];
                }
                mActionArray[MAX_INDEX-1] = action;
            }
            index++;
        }

        public Action next() {
            Action ret;
            if(currentIndex < MAX_INDEX) {
                ret = mActionArray[currentIndex];
            } else {
                ret = null;
            }
            currentIndex++;
            return ret;
        }
    }

    public static void main(String args[]){
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(101);
        bankAccount.withdraw(101);
        bankAccount.withdraw(102);
        bankAccount.withdraw(103);
        bankAccount.withdraw(104);
        bankAccount.deposit(102);
        bankAccount.deposit(103);
        bankAccount.deposit(104);
        bankAccount.deposit(105);
        bankAccount.deposit(106);
        bankAccount.withdraw(107);
        bankAccount.deposit(108);
        bankAccount.deposit(109);
        bankAccount.deposit(110);
        bankAccount.deposit(111);
        for(int i = 0;i < 12; i++) {
            System.out.println(bankAccount.getHistory().next());
        }



    }
}
