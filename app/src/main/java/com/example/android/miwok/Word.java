package com.example.android.miwok;

/**
 * Created by Panda on 12/22/2017.
 */

public class Word {
    private String defaultTranslation;
    private String miwokTranslation;
    private int imageID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_AUDIO_PROVIDED = -1;
    private int audioID = NO_AUDIO_PROVIDED;



//    public void setImageID(int imageID) {
//        this.imageID = imageID;
//    }

    public Word(String defaultTranslation, String miwokTranslation, int imageID, int audioID) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageID = imageID;
        this.audioID = audioID;
    }

    public Word(String defaultTranslation, String miwokTranslation,int audioID) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioID = audioID;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

//    public void setDefaultTranslation(String defaultTranslation) {
//        this.defaultTranslation = defaultTranslation;
//    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

//    public void setMiwokTranslation(String miwokTranslation) {
//        this.miwokTranslation = miwokTranslation;
//    }
    public Boolean hasImage(){
        return imageID!=NO_IMAGE_PROVIDED;
    }

    public int getImageID() {
        return imageID;
    }

    @Override
    public String toString() {
        return "Word{" +
                "defaultTranslation='" + defaultTranslation + '\'' +
                ", miwokTranslation='" + miwokTranslation + '\'' +
                ", imageID=" + imageID +
                ", audioID=" + audioID +
                '}';
    }

    public int getAudioID() {
        return audioID;
    }
}
