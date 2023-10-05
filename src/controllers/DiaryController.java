package controllers;

import data.models.Diary;
import services.DiaryServiceImpl;
import services.DiaryServices;

public class DiaryController {
    private DiaryServices diaryServices = new DiaryServiceImpl();
    public String registerUser(String username, String password){
        diaryServices.register(username, password);
        return "Registered Successful";
    }
    public String unlockDiary(String username, String password){
        diaryServices.unlock(username, password);
        return "Diary Unlocked";
    }
    public String lockDiary(){

        return "Locked";
    }
    public Diary findDiary(String username){
        diaryServices.findBy(username);
        return null;
    }
}
