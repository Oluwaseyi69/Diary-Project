package services;

import data.models.Diary;
import data.models.Entry;
import data.repositories.EntryRepo;
import data.repositories.EntryRepoImplementation;
import dtos.request.CreateEntryRequest;
import dtos.request.FindEntryRequest;

import static utils.Mapper.map;

public class EntryServicesImpl implements EntryServices {
    private EntryRepo entryRepo = new EntryRepoImplementation();



    @Override
    public Entry addEntry(CreateEntryRequest createEntryRequest) {
        Entry newEntry = map(createEntryRequest);
        entryRepo.save(newEntry);
        return newEntry;
    }

    @Override
    public void delete(String ownerName, String title) {
        FindEntryRequest findEntryRequest = new FindEntryRequest();
        findEntryRequest.setUsername(ownerName);
        findEntryRequest.setTitle(title);
        Entry foundEntry = findEntry(findEntryRequest);
        entryRepo.delete(foundEntry);
    }

    @Override
    public void clear() {

    }

//    @Override
//    public Entry findEntry(FindEntryRequest findEntryRequest) {
//        return null;
//    }

//    @Override
//    public Entry findEntry(FindEntryRequest findEntryRequest) {
//        return null;
//    }

    public Entry findEntry(FindEntryRequest findEntryRequest){
        Entry foundEntry = entryRepo.findByUsername(findEntryRequest.getUsername(), findEntryRequest.getTitle());
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

