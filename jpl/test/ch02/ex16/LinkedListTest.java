import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void getListSize() {
        String[] str = null;
        LinkedList.main(str);
        assertEquals(2,LinkedList.getListSize());
    }


    @Test
    public void getValue() {
        String[] str = null;
        LinkedList.main(str);
        Vehicle car = (Vehicle) LinkedList.getValue(1);
        assertEquals("satoh",car.getOwnerName());
        assertEquals(0,car.getIdNumber());
        Vehicle byke = (Vehicle) LinkedList.getValue(2);
        assertEquals("takahashi",byke.getOwnerName());
        assertEquals(1,byke.getIdNumber());
        assertEquals(null,LinkedList.getValue(3));
    }

    @Test
    public void testToString() {
        String[] str = null;
        LinkedList.main(str);
    }

    @Test
    public void main() {
    }
}