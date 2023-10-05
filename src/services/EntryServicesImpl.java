package services;

import data.models.Diary;
import data.models.Entry;
import data.repositories.EntryRepo;
import data.repositories.EntryRepoImplementation;

public class EntryServicesImpl implements EntryServices {
    private EntryRepo entryRepo = new EntryRepoImplementation();



    @Override
    public Entry addEntry(String ownerName, String title, String body) {
        Entry newEntry = new Entry();
        newEntry.setOwnerName(ownerName);
        newEntry.setTitle(title);
        newEntry.setBody(body);
        entryRepo.save(newEntry);
        return newEntry;
    }

    @Override
    public void delete(String ownerName, String title) {
        Entry foundEntry = findEntry(ownerName, title);
        entryRepo.delete(foundEntry);
    }

    @Override
    public void clear() {

    }

    public Entry findEntry(String ownerName, String title){
        Entry foundEntry = entryRepo.findByUsername(ownerName, title);
        boolean entryIsNotFound = foundEntry == null;
        if(entryIsNotFound) throw new IllegalArgumentException("Entry is not found");
        return foundEntry;
    }


    @Override
    public Iterable<Diary> findAll() {
        return null;
    }

    @Override
    public long count(){
        return entryRepo.count();
    }

}

