package services;

import data.models.Diary;
import data.models.Entry;
import data.repositories.DiaryRepo;
import data.repositories.DiaryRepoImplementation;
import dtos.request.LoginRequest;
import dtos.request.RegisterUserRequest;

import static utils.Mapper.map;

public class DiaryServiceImpl implements DiaryServices {
    DiaryRepo diaryRepo = new DiaryRepoImplementation();
    EntryServices entryServices = new EntryServicesImpl();
    private String username;
    private String password;

    @Override
    public void register(RegisterUserRequest registerUserRequest) {
        checkUsername(registerUserRequest.getUsername());
        Diary diary = new Diary();
        map(registerUserRequest, diary);
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
    public void unlock(LoginRequest loginRequest) {
        Diary diary = diaryRepo.findBy(loginRequest.getUsername());
        if(diary == null) throw new IllegalArgumentException("Diary Not Found");
        if(diary.getPassword().equals(loginRequest.getPassword())) diary.setLocked(false);
        else throw new IllegalArgumentException("Incorrect Password");
        diaryRepo.save(diary);
    }

    @Override
    public void lock(String username) {
         Diary foundDiary = findBy(username);
         foundDiary.setLocked(true);
         diaryRepo.save(foundDiary);
    }


    @Override
    public void delete(String username, String password) {
        Diary diary = findBy(username);
        if(diary.getPassword().equals(password)){
            diaryRepo.delete(diary);
        }
        else {
            throw new IllegalArgumentException("Invalid credentials");
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
        throw new IllegalArgumentException("Diary not Found");
    }


    private void checkUsername(String username) {
        for (Diary diary: diaryRepo.findAll()){
            if(diary.getUsername().equals(username)){
                throw new IllegalArgumentException("Kindly input the correct details");
            }
        }
    }

    @Override
    public void update(String username, String oldPassword, String newPassword) {
        Diary diary = findBy(username);
        if(diary.getPassword().equals(oldPassword)) diary.setPassword(newPassword);
        else throw new IllegalArgumentException("Kindly input the correct details");
    }

    @Override
    public Entry addEntry(String username, String title, String body) {
        validateUser(username);
        return entryServices.addEntry(username, title, body);
    }
    private void validateUser(String username){
        Diary foundDiary = diaryRepo.findBy(username);
        if(foundDiary == null)
            throw new IllegalArgumentException("Diary is not Found");
        if(foundDiary.isLocked())
            throw new IllegalArgumentException("Diary is Locked");

    }
    public Entry findEntry(String username, String password){
        Entry entry = entryServices.findEntry(username, password);
        return entry;
    }



}
