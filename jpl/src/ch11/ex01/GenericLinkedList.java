package ch11.ex01;

public class GenericLinkedList<E> {
    private E value;
    private GenericLinkedList nextLinkedList;
    private static GenericLinkedList firstLinkedList;//リストの最初
    private static GenericLinkedList lastLinkedList;//リストの最後

    GenericLinkedList(E value) {
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
    public E getValue(int count) {
        GenericLinkedList currentList = firstLinkedList;
        E ret=null;
        for(int i = 0;i<count;i++) {
            if(currentList == null) {
                ret = null;
                break;
            } else {
                ret = (E) currentList.value;
            }
            currentList = currentList.nextLinkedList;
        }
        return ret;
    }

    /**
     * リスト数を返すメソッド
     * */
    public static int getListSize() {
        GenericLinkedList currentList = firstLinkedList;
        int listCount = 0;
        while(currentList != null) {
            listCount++;
            currentList= currentList.nextLinkedList;
        }
        return listCount;
    }

    public static void main(String args[]){

        GenericLinkedList list =  new GenericLinkedList<String>("aaaaa");

        new GenericLinkedList("ttttt");
        System.out.println(list.getValue(0));
        System.out.println(list.getValue(1));
        System.out.println(list.getValue(2));


    }
}
