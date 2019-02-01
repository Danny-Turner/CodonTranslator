package com.example.codontranslator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner Nucleotide1;
    private Spinner Nucleotide2;
    private Spinner Nucleotide3;
    private TextView Title1;
    private TextView Title2;
    private TextView Title3;
    private TextView AminoAcid;
    private Button ShowMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nucleotide1 = findViewById(R.id.Nucleotide1);
        Nucleotide2 = findViewById(R.id.Nucleotide2);
        Nucleotide3 = findViewById(R.id.Nucleotide3);
        Title1 = findViewById(R.id.Title1);
        Title2 = findViewById(R.id.Title2);
        Title3 = findViewById(R.id.Title3);
        ShowMore = findViewById(R.id.ShowMore);


    }
}
