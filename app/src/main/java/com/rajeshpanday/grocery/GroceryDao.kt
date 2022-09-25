package com.rajeshpanday.grocery


import androidx.room.*
import androidx.lifecycle.LiveData

@Dao
interface GroceryDao {
      @Insert(onConflict=OnConflictStrategy.REPLACE)
      suspend fun insert(item: GroceryItems)

      @Delete
     suspend fun delete(item: GroceryItems)

     @Query("SELECT * FROM grocerry_items")
     fun getAllGroceryItems(): LiveData<List<GroceryItems>>
}
