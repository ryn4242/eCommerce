package edu.psu.rjc65.ecommerce;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "MainActivity";

    private EditText email;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailEditTextID);
        password = findViewById(R.id.passwordEditTextID);
        login = findViewById(R.id.loginButtonID);

        mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("message");

        databaseReference.setValue("Hello Firebase");

        //databaseReference.addValueEventListener(new ValueEventListener() {
            //@Override
            //public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String value = dataSnapshot.getValue(String.class);
                //Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
            //}
//
            //@Override
            //public void onCancelled(@NonNull DatabaseError databaseError) {
//
            //}
        //});

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null){
                    //signed in
                    Log.d(TAG, "User signed in");
                } else {
                    //signed out
                    Log.d(TAG, "User signed out");
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Shopping.class));
                /*
                final String emailString = email.getText().toString();
                String passwordString = password.getText().toString();

                if(!emailString.equals("") && !passwordString.equals("")){
                    mAuth.signInWithEmailAndPassword(emailString, passwordString)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, "Sign-In Failed", Toast.LENGTH_LONG)
                                                .show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Sign-In Sucessful", Toast.LENGTH_LONG)
                                                .show();

                                        Customer customer = new Customer("Ryan", "Capets", emailString, 22);

                                        //Can now write to Database
                                        databaseReference.setValue(customer);
                                    }
                                }
                            });
                }*/
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void signIn(){

    }
}
