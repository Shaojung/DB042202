package com.example.teacher.db042202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditInfoActivity extends AppCompatActivity {
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        MyApplication app = (MyApplication) getApplication();
        uid = app.uid;


    }
    public void clickSave(View v)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(uid);
        EditText ed2 = (EditText) findViewById(R.id.editText2);
        myRef.setValue(ed2.getText().toString());

    }

}
