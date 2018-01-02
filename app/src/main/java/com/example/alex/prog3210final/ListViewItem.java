package com.example.alex.prog3210final;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alex on 2018-01-01.
 */

@Entity
public class ListViewItem {

    @PrimaryKey(autoGenerate = true)
    long id;
    private String BigText;
    private String SmallText;


    public ListViewItem(String BigText,String SmallText){
        this.setBigText(BigText);
        this.setSmallText(SmallText);
    }


    public String getBigText() {
        return BigText;
    }

    public void setBigText(String bigText) {
        BigText = bigText;
    }

    public String getSmallText() {
        return SmallText;
    }

    public void setSmallText(String smallText) {
        SmallText = smallText;
    }
}
