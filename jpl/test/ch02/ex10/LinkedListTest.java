package ch02.ex10;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void main() {
        Vehicle car = new Vehicle("satoh");
        LinkedList list =  new LinkedList(car);

        assertEquals(LinkedList.firstLinkedList.value,car);
        assertEquals(LinkedList.lastLinkedList.value,car);

        Vehicle byke= new Vehicle("takahashi");
        LinkedList list2 = new LinkedList(byke);

        assertEquals(LinkedList.firstLinkedList.value,car);
        assertEquals(LinkedList.lastLinkedList.value,byke);
        assertEquals(list.nextLinkedList,list2);
    }
}