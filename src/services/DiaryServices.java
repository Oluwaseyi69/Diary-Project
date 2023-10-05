package services;

import data.models.Diary;
import data.models.Entry;

public interface DiaryServices {
    void register(String username, String password);

    Diary save(String username, String password);

    Iterable<Diary> findAll();

    long count();
    void unlock(String username, String password);


    void delete(String username, String password);

    void clear();

    Diary findBy(String username);

    void update(String username, String oldPassword, String newPassword);

    interface EntryServices {

        Entry addEntry(String ownerName, String title, String body);

        void add(Diary diary);
        void delete(String ownerName, String title);


        void clear();

        Iterable<Diary> findAll();
        long count();
        void update(String username, String oldPassword, String newPassword);

    }
}


