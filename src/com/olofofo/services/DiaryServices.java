package services;

import data.models.Diary;
import data.models.Entry;
import dtos.request.*;

public interface DiaryServices {
    void register(RegisterUserRequest registerUserRequest);

    Diary save(String username, String password);

    Iterable<Diary> findAll();

    long count();
    void unlock(LoginRequest loginRequest);


    void lock(String username);


    void delete(String username, String password);

    void clear();

    Diary findBy(String username);

    void update(String username, String oldPassword, String newPassword);

    Entry addEntry(CreateEntryRequest createEntryRequest);


    FindEntryResponse findEntry(FindEntryRequest findEntryRequest);

}


