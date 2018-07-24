package com.example.shell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shell.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText edtWidth, edtHeight, edtLength, edtSisi ;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_HASIL = "state_hasil";

// Code untuk menjaga output saat orientasi Layout

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }
// End
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = (EditText)findViewById(R.id.edt_width);
        edtHeight = (EditText)findViewById(R.id.edt_height);
        edtLength = (EditText)findViewById(R.id.edt_length);
     //  edtSisi = (EditText)findViewById((R.id.edt_sisi));
        btnCalculate = (Button)findViewById(R.id.btn_calculate);
        tvResult = (TextView)findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);

        // Code untuk menjaga output saat orientasi Layout

        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
        // END

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate){
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            String sisi = edtSisi.getText().toString().trim();
            boolean isEmpetyFields = false;
            if (TextUtils.isEmpty(length)){
                isEmpetyFields = true;
                edtLength.setError("Field ini tak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmpetyFields = true;
                edtWidth.setError("Field ini tak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmpetyFields = true;
                edtHeight.setError("Ojo kosong broo");
            }
            if (TextUtils.isEmpty(sisi)){
                isEmpetyFields = true;
                edtSisi.setError("Ojo Sembrono");
            }
            if(!isEmpetyFields) {
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }

            // Untuk Kubus
            /*if(!isEmpetyFields) {
                double s = Double.parseDouble(sisi);
                double volume2 = s * s * s;
                tvResult.setText(String.valueOf(volume2));
            }*/


        }
    }


}
