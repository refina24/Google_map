package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast; // Corrected import statement for Toast
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Corrected findViewById method names
        EditText source = findViewById(R.id.editTe);
        EditText destination = findViewById(R.id.editTex);
        Button button = findViewById(R.id.butt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Corrected onClick method name
                String source1 = source.getText().toString();
                String destination1 = destination.getText().toString();
                if (source1.equals("") || destination1.equals("")) { // Corrected logical operator && to ||
                    Toast.makeText(getApplicationContext(), "Enter the source and destination", Toast.LENGTH_SHORT).show(); // Corrected method names
                } else {
                    // Corrected URL formation and added missing '/' after 'dir'
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + source1 + "/" + destination1);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}
