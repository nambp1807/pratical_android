package com.example.buiphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buiphuongnam.database.AppDatabase;
import com.example.buiphuongnam.database.DBHelper;
import com.example.buiphuongnam.database.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edName;
    private EditText edEmail;
    private EditText edDes;
    private Button btSendFeedback;
    private Spinner spinner;
    private CheckBox checkBox;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btSendFeedback.setOnClickListener(this);
    }


    private void initView(){
        edName = (EditText) findViewById(R.id.edName);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edDes = (EditText) findViewById(R.id.edDes);
        btSendFeedback = (Button) findViewById(R.id.btSendFeedback);
        checkBox = (CheckBox) findViewById(R.id.ck);
        btSendFeedback.setOnClickListener(this);

        String[] genders = {"Gripe", "Zack", "Dave", "Sam"};
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btSendFeedback:
                onSendFeedback();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void onSendFeedback() {
        if (!validate()) {
            return;
        }
//        CheckBox bt = (CheckBox)  findViewById(checkBox.getCheckBoxButtonRadioId());
        db = AppDatabase.getAppDatabase(this);
        Student student = new Student();
        student.username = edName.getText().toString();
        student.email = edEmail.getText().toString();
        student.des = edDes.getText().toString();
        long id = db.studentDAO().insertStudent(student);
        if (id > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
        getAllStudent();

    }

    private void getAllStudent() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean validate() {
        String mes = null;
        if (edName.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập name";
        }else if (edEmail.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập email";
        }else if (edDes.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập description";
        }else if (!checkBox.isChecked()) {
            mes = "Bạn phải đồng ý điều khoản sử dụng";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}