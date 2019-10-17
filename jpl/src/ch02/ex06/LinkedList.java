package ch02.ex06;

public class LinkedList {
    public Object value;
    public LinkedList nextLinkedList;
    public static LinkedList firstLinkedList;
    public static LinkedList lastLinkedList;


    public static void main(String args[]){
        Vehicle car = new Vehicle();
        car.idNumber = Vehicle.nextVehicleId++;
        car.ownerName = "satoh";
        LinkedList list1 =  new LinkedList();
        LinkedList.firstLinkedList = LinkedList.lastLinkedList = list1;
        list1.value = car;

        Vehicle byke= new Vehicle();
        byke.idNumber = Vehicle.nextVehicleId++;
        byke.ownerName = "takahashi";
        LinkedList list2 = new LinkedList();
        LinkedList.lastLinkedList.nextLinkedList = list2;
        LinkedList.lastLinkedList = list2;
        list2.value = byke;

    }
}
