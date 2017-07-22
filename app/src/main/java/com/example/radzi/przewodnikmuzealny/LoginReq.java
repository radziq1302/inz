
package com.example.radzi.przewodnikmuzealny;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by radzi on 2017-05-04.
 */


public class LoginReq extends StringRequest {
    private Map<String, String> parametry;
    private static final String log_req_url = "http://tomeczki.000webhostapp.com/Login.php";

    //RegisterReq (int id, String name, String surname, String haslo, int age, int education, String Login, Response.Listener<String> listener) {
    LoginReq (String nazwisko,  String haslo, Response.Listener<String> listener) {
        super(Method.POST, log_req_url, listener, null);
        parametry = new HashMap<>();
        parametry.put("username", nazwisko);

        parametry.put("password", haslo);

        //parametry.put("login", Login);

    }

    @Override
    public Map<String, String> getParams() {
        return parametry;
    }
}

