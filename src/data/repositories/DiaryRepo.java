package data.repositories;

import data.models.Diary;

public interface DiaryRepo {
    Diary getBy(int id);
    Diary save (Diary diary);
    void add(Diary diary);
    void delete(Diary diary);
    void clear(Diary diary);

    Iterable<Diary> findAll();
     long count();

    Diary findBy(String username);
}
