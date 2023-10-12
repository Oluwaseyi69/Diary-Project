package services;

import data.models.Diary;
import data.models.Entry;
import dtos.request.CreateEntryRequest;
import dtos.request.FindEntryRequest;

public interface EntryServices {
    Entry addEntry(CreateEntryRequest createEntryRequest);

    Iterable<Diary> findAll();

    long count();





    void delete(String ownerName, String title);

    void clear();

    Entry findEntry(FindEntryRequest findEntryRequest);
}
