package com.fhmou.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fhmou.activity.book.Book;
import com.fhmou.adapter.BookAdapter;
import com.fhmou.fragment.SearchFragment;
import com.fhmou.http.HttpAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * package com.fhmou.asyncTask
 * functional describe:
 *
 * @version 1.0 16-8-26 下午1:27
 * @auther luyanliang [765673481@qq.com]
 */
public class SearchTask extends AsyncTask<String, Integer, Integer> {

    private BookAdapter adapter;
    public HttpAgent httpAgent = new HttpAgent();
    private String title;
    private List<Book> bookList;
    public HashMap<String, Object> paras = new HashMap<String, Object>();
    private String msgCode = "";
    private SearchFragment search;

    public SearchTask(String _title, SearchFragment _serchFrament) {
        title = _title;
        search = _serchFrament;
    }

    /**
     * 执行任务后调用
     */
    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        if (!msgCode.equals("200")) {
            Toast.makeText(search.getActivity(), "网络错误", Toast.LENGTH_LONG).show();
        } else {
            search.setBookList(bookList);
            if (bookList == null || bookList.size() ==0) {
                Toast.makeText(search.getActivity(), "找不到", Toast.LENGTH_LONG).show();
            } else {
                search.linearLayout1.setVisibility(View.VISIBLE);
                search.linearLayout2.setVisibility(View.INVISIBLE);
                adapter = new BookAdapter(search, bookList);
                search.listView.setAdapter(adapter);
            }
        }

    }

    private List<Book> parseResult(String result)  {
        JSONArray msgBody = null;
        List<Book> infos = null;
        try {
            JSONObject JsonResult = JSONObject.parseObject(result);
            msgCode = JsonResult.getString("code");
            msgBody = JsonResult.getJSONArray("msg");
            infos = new ArrayList<Book>();
            for (int i = 0;  msgBody!=null &&i < msgBody.size(); i++) {
                Book info = Book.String2Book(msgBody.getJSONObject(i).toString());
                if(info!=null)
                    infos.add(info);
            }
        } catch (Exception e) {
            Log.e("book", e.getMessage(),e);
        }

        return infos;
    }

    /**
     * 执行任务之前调用
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        paras.put("title", title);
    }
    /**
     * 执行任务
     */
    @Override
    protected Integer doInBackground(String... arg0) {
        String result = httpAgent.request("api/app/books-for-query", paras, "");
        bookList = parseResult(result);
        return null;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
