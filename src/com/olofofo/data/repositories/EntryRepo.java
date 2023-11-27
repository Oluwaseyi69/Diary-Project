package com.olofofo.data.repositories;

import com.olofofo.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EntryRepo extends MongoRepository<Entry, String> {
   Optional<Entry> findEntryBy(String title);

//    void delete(Optional<Entry> foundEntry);
    //    long count();
//
//    Entry findBy(String ownerName, String title);
//
//    Entry findByUsername(String ownerName, String title);
//
//    void delete(Entry foundEntry);
//
//    void clear();
//
//    Entry findById(int id);
//
//    Entry save(Entry entry);
}
