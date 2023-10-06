package services;

import data.models.Diary;
import data.models.Entry;

public interface DiaryServices {
    void register(String username, String password);

    Diary save(String username, String password);

    Iterable<Diary> findAll();

    long count();
    void unlock(String username, String password);

    void lock(String username);


    void delete(String username, String password);

    void clear();

    Diary findBy(String username);

    void update(String username, String oldPassword, String newPassword);

    Entry addEntry(String username, String title, String body);
    Entry findEntry(String username, String title);

}


