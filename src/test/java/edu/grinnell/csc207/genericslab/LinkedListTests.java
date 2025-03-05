package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList l = new LinkedList();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10Nums() {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetSeveral() {
        LinkedList l = new LinkedList();
        int[] elements = new int[] {3, 8, 7, 'a', 6, 5, 0};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetOOB() {
        LinkedList l = new LinkedList();
        l.add(3);
        l.add(2);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        LinkedList l = new LinkedList();
        l.add(5);
        l.add(8);
        l.add('a');
        l.add(1);
        l.add(9);
        
        assertEquals('a', l.remove(2));
        assertEquals(8, l.get(1));
        assertEquals(1, l.get(2));
        
        assertEquals(5, l.remove(0));
        assertEquals(8, l.get(0));

        assertEquals(9, l.remove(2));
        assertEquals(1, l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedList l = new LinkedList();
        l.add(5);
        l.add(8);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }
    
    @Test
    public void toStringTest(){
        LinkedList l = new LinkedList();
        l.add(5);
        l.add(8);
        l.add('a');
        
        assertEquals("[5, 8, a]", l.toString());
    }
}
