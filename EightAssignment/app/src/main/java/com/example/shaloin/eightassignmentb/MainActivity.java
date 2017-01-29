package com.example.shaloin.eightassignmentb;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_name,et_age,et_phone,et_city;
    private Button save,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=(EditText)findViewById(R.id.nameID);
        et_age=(EditText)findViewById(R.id.ageID);
        et_phone=(EditText)findViewById(R.id.phoneID);
        et_city=(EditText)findViewById(R.id.cityID);
        save=(Button) findViewById(R.id.saveID);
        show=(Button)findViewById(R.id.showID);

        SharedPreferences preferences=getPreferences(MODE_PRIVATE);
        String name=preferences.getString("key_name","");
        String age=preferences.getString("key_age","");
        String phone=preferences.getString("key_phone","");
        String city=preferences.getString("key_city","");
        et_name.setText(name);
        et_age.setText(age);
        et_phone.setText(phone);
        et_city.setText(city);

    }

    public void onSave(View v){
        String name_val=et_name.getText().toString();
        String age_val=et_age.getText().toString();
        String phone_val=et_phone.getText().toString();
        String city_val=et_city.getText().toString();
        SharedPreferences pref= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putString("key_name",name_val);
        editor.putString("key_age",age_val);
        editor.putString("key_phone",phone_val);
        editor.putString("key_city",city_val);
        editor.commit();

    }
    public void onShow(View v){
        Toast.makeText(getApplicationContext(),"Name : "+ et_name.toString() +"\nAge : "+et_age.toString() +"\nPhone : "+et_phone.toString() + "\nCity :"+et_city.toString(),
                Toast.LENGTH_LONG  ).show();
    }
}
