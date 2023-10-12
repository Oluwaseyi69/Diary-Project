package utils;

import data.models.Diary;
import data.models.Entry;
import dtos.request.CreateEntryRequest;
import dtos.request.RegisterUserRequest;

public class Mapper {
   public static void map(RegisterUserRequest registerUserRequest, Diary diary){
        diary.setUsername(registerUserRequest.getUsername());
        diary.setPassword(registerUserRequest.getPassword());
   }

   public static Entry map(CreateEntryRequest createEntryRequest){
       Entry newEntry =new Entry();
       newEntry.setOwnerName(createEntryRequest.getOwnerName());
       newEntry.setTitle(createEntryRequest.getTitle());
       newEntry.setBody(createEntryRequest.getBody());
       return newEntry;
   }

}
