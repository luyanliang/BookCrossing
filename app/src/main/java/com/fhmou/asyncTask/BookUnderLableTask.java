package com.fhmou.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fhmou.entity.Book;
import com.fhmou.ui.adapter.BookAdapter;
import com.fhmou.fragment.BookUnderLabelFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * package com.fhmou.asyncTask
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:30
 * @auther luyanliang [765673481@qq.com]
 */
public class BookUnderLableTask extends AsyncTask<String, Integer, List<Book>> {

    int code = 500;
    private BookUnderLabelFragment fragment;
    public BookUnderLableTask(BookUnderLabelFragment bookUnderLabelFragment) {
        fragment = bookUnderLabelFragment;
    }

    @Override
    protected List<Book> doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(List<Book> result) {
        super.onPostExecute(result);

        if(code==500){
            Toast.makeText(fragment.getActivity(), "获取书籍失败", Toast.LENGTH_LONG).show();
        }else{
            if(result==null || result.size()==0)
                Toast.makeText(fragment.getActivity(), "该标签下还没有书籍，赶快把你的标签分享出去吧", Toast.LENGTH_LONG).show();
            else{
                fragment.setBookList(result);
                BookAdapter adapter = new BookAdapter(fragment, result);
                fragment.bookListView.setAdapter(adapter);
            }
        }
    }

    private List<Book> parseJsonResult(String result) {
        List<Book> bookList = new ArrayList<Book>();
        try {
            JSONObject mess = JSONObject.parseObject(result);
            code = mess.getIntValue("code");
            if(code==500)return null;
            bookList = JSON.parseArray(mess.getString("msg"), Book.class);
        } catch (Exception e) {
            Log.e("book", e.getMessage(), e);
        }
        return bookList;
    }
}
