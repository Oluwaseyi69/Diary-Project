package data.repositories;

import data.models.Entry;

public interface EntryRepo {
    long count();

    Entry findBy(String ownerName, String title);

    Entry findByUsername(String ownerName, String title);

    void delete(Entry foundEntry);

    void clear();

    Entry findById(int id);

    Entry save(Entry entry);
}
