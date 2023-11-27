package com.olofofo.services;

import com.olofofo.data.models.Diary;
import com.olofofo.data.models.Entry;
import com.olofofo.data.repositories.DiaryRepo;
import com.olofofo.data.repositories.EntryRepo;
import com.olofofo.dtos.request.request.*;
import com.olofofo.dtos.request.response.RegisterUserResponse;
import com.olofofo.exception.DiaryExistException;
import com.olofofo.exception.IncorrectDetailsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.olofofo.utils.Mapper.map;

@Service
public class DiaryServiceImpl implements DiaryServices {
   private DiaryRepo diaryRepo;

   @Autowired
   public void setter (DiaryRepo diaryRepo){
       this.diaryRepo = diaryRepo;
   }



    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        checkUsername(registerUserRequest);
        return map(diaryRepo.save(map(registerUserRequest)));
    }


    @Override
    public boolean unlock(LoginRequest loginRequest) {
        Optional<Diary> diary = findBy(loginRequest.getUsername());
        if(diary.isEmpty()) throw new IllegalArgumentException("Diary Not Found");
        if(!diary.get().getUsername().equals(loginRequest.getUsername()) ||
                !diary.get().getPassword().equals(loginRequest.getPassword()))
            throw new IncorrectDetailsException("Incorrect Credentials");

        diary.get().setLocked(false);
        return true;
    }

    @Override
    public boolean lock(String username) {
         Optional<Diary> diary = findBy(username);
         if (diary.isPresent())diary.get().setLocked(true);

        return true;
    }

    @Override
    public void delete(DeleteDiaryRequest deleteDiaryRequest) {
        Optional<Diary> diary = findBy(deleteDiaryRequest.getUsername());
        if(diary.isPresent())diary.get().getPassword().equals(deleteDiaryRequest.getPassword());

    }

    public Optional<Diary> findBy(String username) {
       Optional<Diary> diary = diaryRepo.findDiaryByUsername(username);
        return diary;
    }
    private void  checkUsername(RegisterUserRequest registerUserRequest) {
        Optional<Diary> diary = findBy(registerUserRequest.getUsername());
        if(diary.isPresent())
            throw new DiaryExistException("Dairy Exist");
    }

    @Override
    public void  update(PasswordUpdate passwordUpdate, RegisterUserRequest registerUserRequest) {
        if(registerUserRequest.getPassword().equals(passwordUpdate
                .getOldPassword())) registerUserRequest
                .setPassword(passwordUpdate.getNewPassword());
        else throw new IllegalArgumentException("Kindly input the correct details");
    }



}
