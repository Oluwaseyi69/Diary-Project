package com.olofofo.controllers;

import com.olofofo.dtos.request.request.*;
//import com.olofofo.request.*;
import com.olofofo.services.EntryServices;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.olofofo.services.DiaryServiceImpl;
import com.olofofo.services.DiaryServices;

@RestController
@RequestMapping("/Olofofo")
public class DiaryController {
    @Autowired
    private DiaryServices diaryServices;
//    @Autowired
//    private EntryServices entryServices;

    @PostMapping("/register")
    public String registerUser(RegisterUserRequest registerUserRequest){
        try {
            diaryServices.register(registerUserRequest);
            return "Registered Successful";
        }
        catch (Exception exception){
            return exception.getMessage();
        }
    }

    @PatchMapping("/unlock")
    public String  unlockDiary(LoginRequest loginRequest){
        try {
            diaryServices.unlock(loginRequest);
            return "Diary Unlocked";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    @PatchMapping("/lock")
    public String lockDiary(String username){
        try {
            diaryServices.lock(username);
            return "Locked";
        }
        catch (Exception exception){
            return exception.getMessage();
        }
    }
    @GetMapping ("Find Entry")
    public Object findEntry(String username){
        try {
            return diaryServices.findBy(username);
        }
        catch (Exception exception){
           return exception.getMessage();
        }
    }



//    @PostMapping("/create entry")
//    public String createEntry(AddEntryRequest addEntryRequest){
//        try {
//            entryServices.addEntry(addEntryRequest);
//            return "Entry Successfully Created";
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }

    @DeleteMapping("/Delete")
    public String delete(DeleteDiaryRequest deleteDiaryRequest){
        try {
            diaryServices.delete(deleteDiaryRequest);
            return "Successfully Deleted";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}

