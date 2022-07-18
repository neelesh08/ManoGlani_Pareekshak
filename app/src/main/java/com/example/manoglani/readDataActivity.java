package com.example.manoglani;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.manoglani.databinding.ActivityReadDataActivityBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class readDataActivity extends AppCompatActivity {
    ActivityReadDataActivityBinding binding;
    private RequestQueue mQueue;
    private String response1;
    public  String email , depression_result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityReadDataActivityBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromAPI();
            }
        });
    }

    private void getDataFromAPI() {


        // creating a string variable for URL.
        String url = "https://sheet2api.com/v1/3MnzdpBEQMaI/result_sheet_manoglanipareekshak";
        Toast toast = Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG);
        toast.show();


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {


                    try {

                        if(extractData(response)){
                            Toast toast1 = Toast.makeText(getApplicationContext(), "data found response", Toast.LENGTH_LONG);

                        }
                        else{
                            Toast toast1 = Toast.makeText(getApplicationContext(), "data not found response", Toast.LENGTH_LONG);

                        }



                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast toast1 = Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG);
                        toast1.show();


                    }
                }, error ->

                binding.getText.setText("error"));
        queue.add(stringRequest);
    }

    private boolean extractData(String response) throws JSONException {
        boolean flag = false;
        JSONArray jsonArray = new JSONArray(response);


        for(int i=0; i< jsonArray.length() ; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String x = jsonObject.getString("Subject_D");
            if(x.equals(binding.subId.getText().toString())){
                // email
                String email = jsonObject.getString("Email_ID");
                String result = jsonObject.getString("Depression_Result");
                binding.getText.setText(email);
                flag = true;
            }


        }
        if(flag == true){
            return true;
        }
        return false;






    }


}