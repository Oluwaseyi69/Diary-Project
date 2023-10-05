package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class EntryServicesImplTest {
    private EntryServices entryServices;
    @BeforeEach
    public void startWith(){
        entryServices = new EntryServicesImpl();
    }
    @Test
    public void testThatEntryCanBeAdded(){
        entryServices.addEntry("Owner Name", "title", "body");
        assertEquals(1, entryServices.count());
    }

    @Test
    public void testThatEntryCanBelongingToUserCanBeDeletedUsingTitle(){
        entryServices.addEntry("Owner Name", "title", "body");
        entryServices.addEntry("Owner Name", "titleOfEntry", "body");
        assertEquals(2, entryServices.count());

        entryServices.delete("Owner Name", "title");
        assertEquals(1, entryServices.count());

    }
    @Test
    public void testThatDeleteEntryThrowsExceptionIfEntryNotFound(){
        entryServices.addEntry("Owner Name", "title", "body");
        entryServices.addEntry("Owner Name", "titleOfEntry", "body");
        assertEquals(2, entryServices.count());

        assertThrows(IllegalArgumentException.class, ()-> entryServices.delete("Owner Name", "NoTitle"));
    }
    @Test
    public void testThatEntryServicesThrowsExceptionIfEntryNotFound(){
        entryServices.addEntry("Seyi Banwo", "title", "body");
        entryServices.addEntry("Seyi Banwo", "Header title", "body");
        assertEquals(2, entryServices.count());
        assertThrows(IllegalArgumentException.class, ()-> entryServices.findEntry("Owner Name", "NoTitle"));

    }




}
