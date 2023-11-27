package com.olofofo.data.repositories;

import com.olofofo.data.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface DiaryRepo extends MongoRepository<Diary, String> {

    Optional<Diary> findDiaryByUsername(String username);

}
