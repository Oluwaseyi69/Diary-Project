package controllers;

import data.models.Entry;
import dtos.request.LoginRequest;
import dtos.request.RegisterUserRequest;
import services.DiaryServiceImpl;
import services.DiaryServices;

public class DiaryController {
    private DiaryServices diaryServices = new DiaryServiceImpl();
    public String registerUser(RegisterUserRequest registerUserRequest){
        try {
            diaryServices.register(registerUserRequest);
            return "Registered Successful";
        }
        catch (Exception exception){
            return exception.getMessage();
        }
    }
    public String  unlockDiary(LoginRequest loginRequest){
        try {
            diaryServices.unlock(loginRequest);
            return "Diary Unlocked";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public String lockDiary(String username){
        try {
            diaryServices.lock(username);
            return "Locked";
        }
        catch (Exception exception){
            return exception.getMessage();
        }
    }
    public String findEntry(String username, String title){
        try {
            Entry entry = diaryServices.findEntry(username, title);
            return entry.toString();
        }
        catch (Exception exception){
           return exception.getMessage();
        }
    }
    public String createEntry(String username, String title, String body){
        try {
            diaryServices.addEntry(username, title, body);
            return "Entry Successfully Created";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
