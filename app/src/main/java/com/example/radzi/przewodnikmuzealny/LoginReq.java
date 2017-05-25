
package com.example.radzi.przewodnikmuzealny;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by radzi on 2017-05-04.
 */


public class LoginReq extends StringRequest {
    private static final String log_req_url = "http://tomeczki.000webhostapp.com/Login.php";
    private Map<String, String> params;
    //RegisterReq (int id, String name, String surname, String password, int age, int education, String Login, Response.Listener<String> listener) {
    LoginReq (String username,  String password, Response.Listener<String> listener) {
        super(Method.POST, log_req_url, listener, null);
        params = new HashMap<>();
        params.put("username", username);

        params.put("password", password);

        //params.put("login", Login);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

