package com.fhmou.activity.book;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * package com.fhmou.activity.book
 * functional describe:
 *
 * @version 1.0 16-8-26 上午11:02
 * @auther luyanliang [765673481@qq.com]
 */
public class BookInfo implements Serializable {

    private String mTitle="";
    private Bitmap mBitmap;
    private String mAuthor="";
    private String mPublisher="";
    private String mPublishDate="";
    private String mISBN="";
    private String mSummary="";
    private String mISBN10="";
    private String mImage="";
    private String mPrice="";

    public String getISBN10() {
        return mISBN10;
    }
    public void setISBN10(String mISBN10) {
        this.mISBN10 = mISBN10;
    }
    public String getImage() {
        return mImage;
    }
    public void setImage(String mImage) {
        this.mImage = mImage;
    }
    public String getPrice() {
        return mPrice;
    }
    public void setPrice(String mPrice) {
        this.mPrice = mPrice;
    }
    public void setTitle(String Title)
    {
        mTitle=Title;
    }
    public void setBitmap(Bitmap bitmap)
    {
        mBitmap=bitmap;
    }
    public void setAuthor(String Author)
    {
        mAuthor=Author;
    }
    public void setISBN(String ISBN)
    {
        mISBN=ISBN;
    }
    public void setPublishDate(String PublishDate)
    {
        mPublishDate=PublishDate;
    }
    public void setPublisher(String Publisher)
    {
        mPublisher=Publisher;
    }
    public void setSummary(String Summary)
    {
        mSummary=Summary;
    }

    public String getTitle()
    {
        return mTitle;
    }
    public Bitmap getBitmap()
    {
        return mBitmap;
    }
    public String getAuthor()
    {
        return mAuthor;
    }

    public String getISBN()
    {
        return mISBN;
    }
    public String getPublishDate()
    {
        return mPublishDate;
    }
    public String getPublisher()
    {
        return mPublisher;
    }
    public String getSummary()
    {
        return mSummary;
    }

    public static final Parcelable.Creator<BookInfo> CREATOR = new Parcelable.Creator<BookInfo>() {
        public BookInfo createFromParcel(Parcel source) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.mTitle = source.readString();
            bookInfo.mBitmap = source.readParcelable(Bitmap.class.getClassLoader());
            bookInfo.mAuthor = source.readString();
            bookInfo.mPublisher = source.readString();
            bookInfo.mPublishDate = source.readString();
            bookInfo.mISBN = source.readString();
            bookInfo.mSummary = source.readString();
            return bookInfo;
        }
        public BookInfo[] newArray(int size) {
            return new BookInfo[size];
        }
    };
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeParcelable(mBitmap, flags);
        dest.writeString(mAuthor);
        dest.writeString(mPublisher);
        dest.writeString(mPublishDate);
        dest.writeString(mISBN);
        dest.writeString(mSummary);
    }

    public static BookInfo String2BookInfo(String jsonString){
        BookInfo info = null;
        try{
            info = JSON.parseObject(jsonString, BookInfo.class);
        }catch(Exception e){
            Log.e("book-info", e.getMessage(), e);
            return null;
        }

        return info;
    }
}
