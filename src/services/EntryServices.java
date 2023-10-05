package services;

import data.models.Diary;
import data.models.Entry;

public interface EntryServices {
    Entry addEntry(String ownerName, String title, String body);

    Iterable<Diary> findAll();

    long count();





    void delete(String ownerName, String title);

    void clear();

    Entry findEntry(String ownerName, String title);
}
