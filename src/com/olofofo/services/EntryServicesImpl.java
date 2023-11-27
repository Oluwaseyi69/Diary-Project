package com.olofofo.services;

import com.olofofo.data.models.Entry;
import com.olofofo.data.repositories.EntryRepo;
import com.olofofo.dtos.request.request.AddEntryRequest;
import com.olofofo.dtos.request.request.FindEntryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.olofofo.utils.Mapper.map;
@Service
public class EntryServicesImpl implements EntryServices {
    private EntryRepo entryRepo;

    private EntryServices entryServices;


    @Autowired
    public void setter(EntryRepo entryRepo){
        this.entryRepo = entryRepo;
    }

    @Override
    public Optional<Entry> addEntry(AddEntryRequest addEntryRequest) {
        Optional<Entry> entry=  validateEntry(addEntryRequest.getUsername());
        if(entry.isEmpty()){
            entryServices.addEntry(addEntryRequest);
        }
        return entry;
    }
    private Optional<Entry> validateEntry(String title){
        Optional<Entry> foundDiary = entryRepo.findEntryBy(title);
        return foundDiary;
    }


    @Override
    public void clear() {

    }



    public Optional<Entry>  findEntry(FindEntryRequest findEntryRequest){
        Optional<Entry> foundEntry = entryRepo.findEntryBy(findEntryRequest.getTitle());
        boolean entryIsNotFound = foundEntry.isEmpty();
        if(entryIsNotFound) throw new IllegalArgumentException("Entry is not found");
        return foundEntry;
    }



    @Override
    public long count(){
        return entryRepo.count();
    }

}

