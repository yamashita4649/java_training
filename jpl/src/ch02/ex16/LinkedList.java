public class LinkedList {
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

    /**
     * count番目のvalueを取得するメソッド
     * 存在しない番号はnullを返す
     * */
    public static Object getValue(int count) {
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
    public static int getListSize() {
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
        LinkedList list =  new LinkedList(car);

        Vehicle byke= new Vehicle("takahashi");
        new LinkedList(byke);


    }
}
