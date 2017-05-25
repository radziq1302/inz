package com.example.radzi.przewodnikmuzealny;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by radzi on 2017-05-19.
 */

public class kwestionariuszChangeValue extends StringRequest {
        private static final String reg_req_url = "http://tomeczki.000webhostapp.com/kwestionariuszChangeValue.php";
        private Map<String, String> params;


    kwestionariuszChangeValue (String username,  String password, Response.Listener<String> listener) {
        super(Method.POST, reg_req_url, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("kwestionariusz", 1 + "");


    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
    }





