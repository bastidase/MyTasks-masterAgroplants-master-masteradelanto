package com.jonmid.mytasks.Parser;

import com.jonmid.mytasks.Models.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Json {
    public static List<User> parserJsonUser(String content) throws Exception {
        JSONArray myArray = new JSONArray(content);
        List<User> myUserList = new ArrayList<>();

        for (int i=0; i<myArray.length(); i++){
            JSONObject item = myArray.getJSONObject(i);
            User usuario = new User();
            usuario.setName(item.getString("name"));
            usuario.setEmail(item.getString("email"));
            myUserList.add(usuario);
        }

        return myUserList;
    }
}
