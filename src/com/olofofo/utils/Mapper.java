package com.olofofo.utils;

import com.olofofo.data.models.Diary;
import com.olofofo.data.models.Entry;
import com.olofofo.dtos.request.request.CreateEntryRequest;
import com.olofofo.dtos.request.request.RegisterUserRequest;
import com.olofofo.dtos.request.response.RegisterUserResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
   public static Diary map(RegisterUserRequest registerUserRequest){
       Diary diary = new Diary();
        diary.setUsername(registerUserRequest.getUsername());
        diary.setPassword(registerUserRequest.getPassword());

       return diary;
   }

    public static RegisterUserResponse map(Diary diary){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUsername(diary.getUsername());
        registerUserResponse.setRegisterDate(DateTimeFormatter
                .ofPattern("EEE dd/MMM/yyyy HH:mm:ss a")
                .format(LocalDateTime.now()));
        return registerUserResponse;
    }

   public static Entry map(CreateEntryRequest createEntryRequest){
       Entry newEntry =new Entry();
       newEntry.setOwnerName(createEntryRequest.getOwnerName());
       newEntry.setTitle(createEntryRequest.getTitle());
       newEntry.setBody(createEntryRequest.getBody());
       return newEntry;
   }

}
