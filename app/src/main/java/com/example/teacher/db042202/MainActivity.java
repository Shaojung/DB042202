package com.example.teacher.db042202;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void clickReg(View v)
    {
        startActivity(new Intent(MainActivity.this, RegActivity.class));
    }
    public void clickLogin(View v)
    {
        EditText ed1 = (EditText) findViewById(R.id.editText);
        EditText ed3 = (EditText) findViewById(R.id.editText3);
        mAuth.signInWithEmailAndPassword(ed1.getText().toString().trim(), ed3.getText().toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("FCM", "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            FirebaseUser user = task.getResult().getUser();
                            String str = user.getUid();

                            startActivity(new Intent(MainActivity.this, InfoActivity.class).putExtra("uid", str));
                        }
                        else
                        {
                            Log.w("FCM", "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, "Error",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}
