
package com.example.radzi.przewodnikmuzealny;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by radzi on 2017-05-04.
 */


public class RegisterReq extends StringRequest {
    private static final String reg_req_url = "https://tomeczki.000webhostapp.com/Register.php";
    private Map<String, String> params;
    //RegisterReq (int id, String name, String surname, String password, int age, int education, String Login, Response.Listener<String> listener) {
        RegisterReq (String name, String surname, String password, Response.Listener<String> listener) {
        super(Method.POST, reg_req_url, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("surname", surname);
        params.put("password", password);
        //params.put("login", Login);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

