package ch02.ex07;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void main() {
        Vehicle car = new Vehicle();
        car.idNumber = Vehicle.nextVehicleId++;
        car.ownerName = "satoh";
        LinkedList list1 =  new LinkedList();
        LinkedList.firstLinkedList = LinkedList.lastLinkedList = list1;
        list1.value = car;

        assertEquals(LinkedList.firstLinkedList.value,car);
        assertEquals(LinkedList.lastLinkedList.value,car);

        Vehicle byke= new Vehicle();
        byke.idNumber = Vehicle.nextVehicleId++;
        byke.ownerName = "takahashi";
        LinkedList list2 = new LinkedList();
        LinkedList.lastLinkedList.nextLinkedList = list2;
        LinkedList.lastLinkedList = list2;
        list2.value = byke;

        assertEquals(LinkedList.firstLinkedList.value,car);
        assertEquals(LinkedList.lastLinkedList.value,byke);
        assertEquals(list1.nextLinkedList,list2);
    }
}