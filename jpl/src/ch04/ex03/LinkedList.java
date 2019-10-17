package ch04.ex03;

//回答＝interfaceであるべき

public class LinkedList implements ListInterface{
    private Object value;
    private LinkedList nextLinkedList;
    private static LinkedList firstLinkedList;//リストの最初
    private static LinkedList lastLinkedList;//リストの最後

    LinkedList(Object value) {
        this.value = value;
        if(firstLinkedList == null) {
            firstLinkedList = this;
            lastLinkedList = this;
        } else {
            lastLinkedList.nextLinkedList = this;
            lastLinkedList = this;
        }
    }

    public LinkedList clone() {
//        try {
            int i = 0;
            LinkedList currentList = firstLinkedList;
            while(currentList != this) {
                i++;
                currentList = currentList.nextLinkedList;
            }

            return currentList;
//        } catch (CloneNotSupportedException e) {
//            return null;
//        }
    }

    /**
     * count番目のvalueを取得するメソッド
     * 存在しない番号はnullを返す
     * */
    public Object getValue(int count) {
        LinkedList currentList = firstLinkedList;
        Object ret=null;
        for(int i = 0;i<count;i++) {
            if(currentList == null) {
                ret = null;
                break;
            } else {
                ret = currentList.value;
            }
            currentList = currentList.nextLinkedList;
        }
        return ret;
    }

    /**
     * リスト数を返すメソッド
     * */
    public int getListSize() {
        LinkedList currentList = firstLinkedList;
        int listCount = 0;
        while(currentList != null) {
            listCount++;
            currentList= currentList.nextLinkedList;
        }
        return listCount;
    }

    public static void main(String args[]){
        Vehicle car = new Vehicle("satoh");
        LinkedList list =new LinkedList(car);
        LinkedList cloneList = list.clone();
        System.out.println(cloneList.value.toString());

        Vehicle byke= new Vehicle("takahashi");
        new LinkedList(byke);

        Vehicle car2 = new Vehicle("jon");
        LinkedList list1 =  new LinkedList(car2);
        LinkedList cloneList1 = list1.clone();
        cloneList1.value = new Vehicle("jony");

        Vehicle byke2= new Vehicle("taka");
        LinkedList list2 =new LinkedList(byke2);

        System.out.println(list2.getValue(3).toString());
    }
}
