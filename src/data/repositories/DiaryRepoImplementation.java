package data.repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class DiaryRepoImplementation implements DiaryRepo{
    private long counter;
    List<Diary> diaries = new ArrayList<>();


    public DiaryRepoImplementation() {
        this.counter = 0;
    }

    @Override
    public Diary getBy(int id) {
        for(Diary diary :diaries){
            if(diary.getId()== id){
                return diary;
            }
        }
        throw new InputMismatchException("Invalid Id");
    }

    private void saveNew(Diary diary) {
        diary.setId(generateId());
        diaries.add(diary);
        this.counter++;
    }

    private void update(Diary diary) {
        Diary updatedDiary = getBy(diary.getId());
        updatedDiary.setUsername(diary.getUsername());
    }

    @Override
    public Diary save(Diary diary) {
        boolean diaryDoesNotExist = diary.getId() == 0;
        if (diaryDoesNotExist) saveNew(diary);
        else update(diary);
        return null;
    }

    @Override
    public void add(Diary diary) {
        diary.setId(generateId());
        diaries.add(diary);
    }

    public int generateId() {
        return diaries.size() +1;
    }

    @Override
    public void delete(Diary diary) {
        Diary newDiary = getBy(diary.getId());
        diaries.remove(newDiary);
    }

    @Override
    public void clear(Diary diary) {
    counter -= diaries.size();
    diaries.clear();
    }

    @Override
    public Iterable<Diary> findAll() {
        return diaries;
    }

    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public Diary findBy(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equalsIgnoreCase(username))
                return diary;
        }
        return null;
    }

}
