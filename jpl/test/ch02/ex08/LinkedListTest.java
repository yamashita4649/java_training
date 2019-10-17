package ch02.ex08;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void main() {
        Vehicle car = new Vehicle();
        car.idNumber = Vehicle.nextVehicleId++;
        car.ownerName = "satoh";
        LinkedList list =  new LinkedList(car);

        assertEquals(LinkedList.firstLinkedList.value,car);
        assertEquals(LinkedList.lastLinkedList.value,car);

        Vehicle byke= new Vehicle();
        byke.idNumber = Vehicle.nextVehicleId++;
        byke.ownerName = "takahashi";
        LinkedList list2 = new LinkedList(byke);

        assertEquals(LinkedList.firstLinkedList.value,car);
        assertEquals(LinkedList.lastLinkedList.value,byke);
        assertEquals(list.nextLinkedList,list2);
    }
}