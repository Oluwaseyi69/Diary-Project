package com.olofofo.services;

import com.olofofo.data.models.Entry;
import com.olofofo.dtos.request.request.AddEntryRequest;
import com.olofofo.dtos.request.request.FindEntryRequest;

import java.util.Optional;

public interface EntryServices {
    Optional<Entry> addEntry(AddEntryRequest addEntryRequest);


    long count();





//    void delete(DeleteEntryRequest deleteEntryRequest);

    void clear();

    Optional<Entry> findEntry(FindEntryRequest findEntryRequest);
}
