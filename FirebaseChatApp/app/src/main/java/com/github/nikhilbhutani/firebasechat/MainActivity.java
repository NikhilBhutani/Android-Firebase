package com.github.nikhilbhutani.firebasechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    EditText editText;
    Button button;

    final FirebaseDatabase  database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            textview = (TextView)findViewById(R.id.mymessage);
            editText = (EditText)findViewById(R.id.etMessage);
            button = (Button)findViewById(R.id.sendbutton);

           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   chatting();
               }
           });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String chat = "";

                for(DataSnapshot mchild : dataSnapshot.getChildren())
                {
                    chat = chat+"\n\n"+mchild.child("msg").getValue();
                }
                textview.setText(chat);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

    private void chatting() {

         Message message = new Message(editText.getText().toString(),"Android");
        databaseReference.push().setValue(message);
        editText.setText("");


    }



}
