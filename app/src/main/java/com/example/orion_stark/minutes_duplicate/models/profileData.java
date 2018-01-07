package com.example.orion_stark.minutes_duplicate.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evan on 11/12/17.
 */

public class profileData {
    public String textProfileFrag;
    private int imgID;
    public static List<profileData> profileD = new ArrayList<>();
    public profileData(String textProfile, int locationImg){
        this.textProfileFrag = textProfile;
        this.imgID = locationImg;
    }
    public int getImgID() {
        return this.imgID;
    }
}
