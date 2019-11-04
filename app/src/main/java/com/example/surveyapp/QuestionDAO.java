package com.example.surveyapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Insert
    long insert(Question question);

    @Insert
    void insert(Question...  films);

    @Update
    int update(Question film);

    @Query("select distinct question_content from Questions LIMIT 4 OFFSET 1 ")
    List<String> selectGenres();

    /*

    @Query("select name from films where genre=:genre")
    List<String> selectNamesByGenre(String genre);

    @Query("select * from films where name=:name")
    List<Film> selectFilm(String name);
*/

}
