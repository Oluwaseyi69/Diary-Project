package controllers;

import data.models.Entry;
import dtos.request.*;
import org.springframework.web.bind.annotation.RestController;
import services.DiaryServiceImpl;
import services.DiaryServices;

@RestController
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
    public Object findEntry(FindEntryRequest findEntryRequest){
        try {
            return diaryServices.findEntry(findEntryRequest);
        }
        catch (Exception exception){
           return exception.getMessage();
        }
    }
    public String createEntry(CreateEntryRequest createEntryRequest){
        try {
            diaryServices.addEntry(createEntryRequest);
            return "Entry Successfully Created";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
