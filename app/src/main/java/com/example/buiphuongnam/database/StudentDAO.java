package com.example.buiphuongnam.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface StudentDAO {
    @Insert(onConflict = REPLACE)
    long insertStudent(Student student);


    @Query("Select * from student")
    List<Student> getAllStudent();
}
