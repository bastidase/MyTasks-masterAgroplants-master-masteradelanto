package com.jonmid.mytasks.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jonmid.mytasks.Models.User;
import com.jonmid.mytasks.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickdavid on 05/06/2017.
 */

public class AdapterUser  extends BaseAdapter{

    List<User> userList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;


    public AdapterUser (Context context, List<User> userList){

        this.context = context;
        this.userList = userList;
        layoutInflater = LayoutInflater.from(this.context);

    }



    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User user = getItem(position);
        viewHolder.name.setText(user.getName());
        viewHolder.email.setText(user.getEmail());

        return convertView;

    }

    public class ViewHolder{
        TextView name;
        TextView email;

        public ViewHolder(View item) {
            name = (TextView) item.findViewById(R.id.id_item_name);
            email = (TextView) item.findViewById(R.id.id_item_email);
        }
    }
}
