package com.fhmou.activity.book;

import android.util.Log;

import java.io.Serializable;

/**
 * package com.fhmou.activity.book
 * functional describe:
 *
 * @version 1.0 16-8-26 上午11:16
 * @auther luyanliang [765673481@qq.com]
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    long id;
    private String authorName;
    private String  bookName;
    private String bookPress;
    private String bookPrice;
    private String bookVersion;
    private String imageUrl;
    private String isbn;
    private String lastUpdateDate;
    private Owner owner;
    private String publishDate;
    private String summary;
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookPress() {
        return bookPress;
    }
    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }
    public String getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
    public String getBookVersion() {
        return bookVersion;
    }
    public void setBookVersion(String bookVersion) {
        this.bookVersion = bookVersion;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public static Book String2Book(String jsonString){
        Book info = null;
        try{
//            info = JSON.parseObject(jsonString, Book.class);
        }catch(Exception e){
            Log.e("book", e.getMessage(), e);
            return null;
        }

        return info;
    }
}
