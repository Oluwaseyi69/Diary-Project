package com.olofofo.services;

import com.olofofo.data.models.Diary;
import com.olofofo.dtos.request.request.*;
import com.olofofo.dtos.request.response.RegisterUserResponse;

import java.util.Optional;

public interface DiaryServices {
    RegisterUserResponse register(RegisterUserRequest registerUserRequest);

//    Diary save(String username, String password);

//    Iterable<Diary> findAll();

//    long count();
    boolean unlock(LoginRequest loginRequest);


    boolean lock(String username);


    void delete(DeleteDiaryRequest deleteDiaryRequest);


    Optional<Diary> findBy(String username);


    void update(PasswordUpdate passwordUpdate, RegisterUserRequest registerUserRequest);

//    void addEntry(AddEntryRequest addEntryRequest);


//    FindEntryResponse findEntry(FindEntryRequest findEntryRequest);

}


