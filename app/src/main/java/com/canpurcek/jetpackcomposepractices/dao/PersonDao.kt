package com.canpurcek.jetpackcomposepractices.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.canpurcek.jetpackcomposepractices.entity.PersonEntitiy


@Dao
interface PersonDao {

    //in this interface we have some methods and sql func for own database operations

    //this query getting all data from the db
    @Query("SELECT * FROM person")
    suspend fun allPerson(): List<PersonEntitiy>

    //this method adds person to db
    @Insert
    suspend fun personAdd(personEntitiy: PersonEntitiy)

    //this method delete data from the db
    @Delete
    suspend fun personDelete(personEntitiy: PersonEntitiy)

    //this query check data from the db with table entity
    @Query("SELECT count(*) FROM person WHERE name=:name")
    suspend fun signCheck(name: String): Int

    //this query get data from the db by id
    @Query("SELECT * FROM person WHERE name=:personId")
    suspend fun getPerson(personId: Int): PersonEntitiy

    //this query search data from the db
    @Query("SELECT * FROM person WHERE person_id like '%' || :searchWord || '%'")
    suspend fun personSearch(searchWord : String): List<PersonEntitiy>
}