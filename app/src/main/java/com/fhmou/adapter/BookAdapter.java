package com.fhmou.adapter;

import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhmou.activity.R;
import com.fhmou.entity.Book;
import com.fhmou.asyncTask.BitmapTask;

import java.util.List;

/**
 * package com.fhmou.adapter
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:31
 * @auther luyanliang [765673481@qq.com]
 */
public class BookAdapter extends BaseAdapter {

    private Fragment fragment;
    private static LayoutInflater inflater = null;
    private List<Book> booklist;

    public BookAdapter(Fragment _fragment, List<Book> booklist) {
        fragment = _fragment;
        this.booklist = booklist;
        inflater = (LayoutInflater) fragment.getActivity().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return booklist.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.item_book, null);


        TextView title = (TextView) vi.findViewById(R.id.title); // 标题
        TextView author = (TextView) vi.findViewById(R.id.artist);
        TextView owner =  (TextView) vi.findViewById(R.id.owner);
        ImageView imageView = (ImageView) vi.findViewById(R.id.list_image); // 缩略图

        Book book = booklist.get(position);
        if (book.getBookName() != null)
            title.setText(book.getBookName());
        if (book.getAuthorName() != null)
            author.setText("     作者:    " + book.getAuthorName());
        if(book!=null&&book.getOwner()!=null &&book.getOwner().getUserName()!=null)
            owner.setText("     拥有者:  " + book.getOwner().getUserName());
        if(book.getImageUrl()!=null){
            BitmapTask task = new BitmapTask(imageView, book.getImageUrl(),fragment.getActivity());
            task.execute();
        }

        return vi;
    }
}
