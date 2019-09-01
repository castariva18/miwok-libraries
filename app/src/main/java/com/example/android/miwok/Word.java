package com.example.android.miwok;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

class Word implements Parcelable {
    private String miwokWord;
    private String defaultWord;
    private String image;


    protected Word(Parcel in) {
        miwokWord = in.readString();
        defaultWord = in.readString();
        image = in.readString();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    String getMiwokWord() {
        return miwokWord;
    }

    String getDefaultWord() {
        return defaultWord;
    }

    boolean hasImage() {
        return !TextUtils.isEmpty(image);
    }

    String getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(miwokWord);
        parcel.writeString(defaultWord);
        parcel.writeString(image);
    }
}
