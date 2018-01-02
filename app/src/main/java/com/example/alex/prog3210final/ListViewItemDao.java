package com.example.alex.prog3210final;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Alex on 2018-01-01.
 */

@Dao
public interface ListViewItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addItem(ListViewItem item);

    @Query("select * from ListViewItem")
    public List<ListViewItem> getAllItems();

    @Query("delete from ListViewItem")
    void removeAllItems();
}
