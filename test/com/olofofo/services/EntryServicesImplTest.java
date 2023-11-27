package com.olofofo.services;

import com.olofofo.data.repositories.EntryRepo;
import com.olofofo.dtos.request.request.AddEntryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
public class EntryServicesImplTest {
    @Autowired
    private EntryServices entryServices;
    @Autowired
    private EntryRepo entryRepo;

    @Test
    public void testThatEntryCanBeAdded(){
        AddEntryRequest addEntryRequest = new AddEntryRequest();
        addEntryRequest.setUsername("Username");
        addEntryRequest.setBody("The lord is good");
        addEntryRequest.setTitle("Thank God");

        entryServices.addEntry(addEntryRequest);
        assertThat(entryRepo.count(), is(1L));

    }

//    @Test
//    public void testThatEntryCanBelongingToUserCanBeDeletedUsingTitle(){
//        entryServices.addEntry("username", "title","this body");
//        entryServices.addEntry("username", "title", "this body");
//        assertEquals(2, entryServices.count());
//
//        entryServices.delete("username", "title");
//        assertEquals(1, entryServices.count());
//
//    }
//    @Test
//    public void testThatDeleteEntryThrowsExceptionIfEntryNotFound(){
//        entryServices.addEntry("username", "title", "body");
//        entryServices.addEntry("username", "title", "body");
//        assertEquals(2, entryServices.count());
//
//        assertThrows(IllegalArgumentException.class, ()-> entryServices.delete("Owner Name", "NoTitle"));
//    }
//    @Test
//    public void testThatEntryServicesThrowsExceptionIfEntryNotFound(){
//        entryServices.addEntry("username", "title", "body");
//        entryServices.addEntry("username", "title", "body");
//        assertEquals(2, entryServices.count());
//        assertThrows(IllegalArgumentException.class, ()-> entryServices.findEntry(new FindEntryRequest()));
//
//    }




}
