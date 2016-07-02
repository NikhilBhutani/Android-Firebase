package com.github.nikhilbhutani.firebase_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.nikhilbhutani.firebase_one.Utils.Constants;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text);
        editText = (EditText)findViewById(R.id.Edittext);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToFirebase();
            }
        });


    }

    private void addToFirebase() {


        //Creating a firebase Object
        Firebase firebase = new Firebase(Constants.FIREBASE_URL);

        //Storing the value to the firebase
        // Firebase always stores value in key value pairs
        firebase.child("name").setValue(editText.getText().toString());


        Firebase fi = new Firebase(Constants.FIREBASE_URL).child("name");
        fi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String myname = (String) dataSnapshot.getValue();
                textView.setText(myname);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }


}
