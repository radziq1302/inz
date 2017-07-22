
package com.example.radzi.przewodnikmuzealny;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by radzi on 2017-05-04.
 */


public class RegisterReq extends StringRequest {
    private Map<String, String> parametry;
    private static final String reg_req_url = "http://tomeczki.000webhostapp.com/Register69.php";

    //RegisterReq (int id, String imie, String surname, String haslo, int wiek, int education, String Login, Response.Listener<String> listener) {
        RegisterReq (String imie, String nazwisko, int wiek, String haslo, Response.Listener<String> listener) {
        super(Method.POST, reg_req_url, listener, null);
        parametry = new HashMap<>();
        parametry.put("name", imie);
        parametry.put("username", nazwisko);
        parametry.put("age", wiek + "");
        parametry.put("password", haslo);

        //parametry.put("wiek", Login);

    }

    @Override
    public Map<String, String> getParams() {
        return parametry;
    }
}

