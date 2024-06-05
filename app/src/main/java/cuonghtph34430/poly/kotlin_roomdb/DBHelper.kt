package cuonghtph34430.poly.kotlin_roomdb

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Database(entities = [StudentModel::class], version = 1)
abstract class StudentDB: RoomDatabase() {
    abstract fun studentDAO() : StudentDAO
}

@Dao
interface  StudentDAO {
    @Query("SELECT * FROM StudentModel")
    fun getAll(): List<StudentModel>

    @Query("SELECT * FROM StudentModel WHERE uId IN (:userInt)")
    fun loadAllId(userInt: IntArray): List<StudentModel>

    @Insert
    fun insert(vararg user: StudentModel)

    @Delete
    fun delete(user: StudentModel)

    @Query("SELECT * FROM StudentModel WHERE uId = :uId")
    fun getId(uId: Int): StudentModel

    @Update
    fun update(user: StudentModel)
}