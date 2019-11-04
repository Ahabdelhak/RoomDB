package com.example.surveyapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface UserDAO {

    @Insert
    long insert(User user);


    @Query("select distinct Name from Users ")
    List<String> selectUsers();


//    @Insert
//    void insert(Question...  films);

//    @Update
//    int update(Question film);
//
//    @Query("select distinct question_content from Questions ")
//    List<String> selectGenres();

    /*

    @Query("select name from films where genre=:genre")
    List<String> selectNamesByGenre(String genre);

    @Query("select * from films where name=:name")
    List<Film> selectFilm(String name);
*/

}
