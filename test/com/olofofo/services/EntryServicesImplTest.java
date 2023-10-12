package services;

import dtos.request.CreateEntryRequest;
import dtos.request.FindEntryRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntryServicesImplTest {
    private EntryServices entryServices;
    private CreateEntryRequest createEntryRequest;
    @BeforeEach
    public void startWith(){
        entryServices = new EntryServicesImpl();

        createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setOwnerName("Username");
        createEntryRequest.setBody("Body");
        createEntryRequest.setTitle("Title");

    }
    @Test
    public void testThatEntryCanBeAdded(){
        entryServices.addEntry(createEntryRequest);
        assertEquals(1, entryServices.count());
    }

    @Test
    public void testThatEntryCanBelongingToUserCanBeDeletedUsingTitle(){
        entryServices.addEntry(createEntryRequest);
        entryServices.addEntry(createEntryRequest);
        assertEquals(2, entryServices.count());

        entryServices.delete("Owner Name", "title");
        assertEquals(1, entryServices.count());

    }
    @Test
    public void testThatDeleteEntryThrowsExceptionIfEntryNotFound(){
        entryServices.addEntry(createEntryRequest);
        entryServices.addEntry(createEntryRequest);
        assertEquals(2, entryServices.count());

        assertThrows(IllegalArgumentException.class, ()-> entryServices.delete("Owner Name", "NoTitle"));
    }
    @Test
    public void testThatEntryServicesThrowsExceptionIfEntryNotFound(){
        entryServices.addEntry(createEntryRequest);
        entryServices.addEntry(createEntryRequest);
        assertEquals(2, entryServices.count());
        assertThrows(IllegalArgumentException.class, ()-> entryServices.findEntry(new FindEntryRequest()));

    }




}
