public class LinkedList {
    public Object value;
    public LinkedList nextLinkedList;
    public static LinkedList firstLinkedList;
    public static LinkedList lastLinkedList;

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

    public static void main(String args[]){
        Vehicle car = new Vehicle("satoh");
        LinkedList list =  new LinkedList(car);

        Vehicle byke= new Vehicle("takahashi");
        LinkedList list2 = new LinkedList(byke);

    }
}
