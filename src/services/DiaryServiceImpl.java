package services;

import data.models.Diary;
import data.repositories.DiaryRepo;
import data.repositories.DiaryRepoImplementation;

public class DiaryServiceImpl implements DiaryServices {
    DiaryRepo diaryRepo = new DiaryRepoImplementation();
    private String username;
    private String password;

    @Override
    public void register(String username, String password) {
        checkUsername(username);
        Diary diary = new Diary();
        diary.setUsername(username);
        diary.setPassword(password);
        diaryRepo.save(diary);
    }

    @Override
    public Diary save(String username, String password) {
        return null;
    }

    @Override
    public Iterable<Diary> findAll() {
        return null;
    }


    @Override
    public long count() {
        return diaryRepo.count();
    }

    @Override
    public void unlock(String username, String password) {
        Diary diary = diaryRepo.findBy(username);
        if(diary.getPassword().equals(password)) diary.setLocked(false);
        else throw new IllegalArgumentException("Incorrect Password");
        diaryRepo.save(diary);
    }


    @Override
    public void delete(String username, String password) {
        Diary diary = findBy(username);
        deleteDiary(password, diary);
    }
    private void deleteDiary(String password, Diary diary){
        if(diary.getPassword().equals(password)){
            diaryRepo.delete(diary);
        }
        else {
            throw new IllegalArgumentException("Invalid Password");
        }

    }

    @Override
    public void clear() {

    }

    @Override
    public Diary findBy(String username) {
        for(Diary diary : diaryRepo.findAll()){
            if(diary.getUsername().equals(username)){
                return diary;
            }
        }
        throw new IllegalArgumentException("Kindly input a correct Username");

    }


    private void checkUsername(String username) {
        for (Diary diary: diaryRepo.findAll()){
            if(diary.getUsername().equals(username)){
                throw new IllegalArgumentException("Kindly input a Unique Username");
            }
        }
    }

    @Override
    public void update(String username, String oldPassword, String newPassword) {
        Diary diary = findBy(username);
        if(diary.getPassword().equals(oldPassword)) diary.setPassword(newPassword);
        else throw new IllegalArgumentException("Kindly input the correct details");
    }

}
