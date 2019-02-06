package com.example.codontranslator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

// Dan Turner
// CSCI 352
// Project 1 - Codon Translator



public class MainActivity extends AppCompatActivity {

    private Spinner Nucleotide1;
    private Spinner Nucleotide2;
    private Spinner Nucleotide3;
    private TextView Title1;
    private TextView Title2;
    private TextView Title3;
    private TextView AminoAcid;
    private Button ShowMore;


    public ArrayList<Nucleotide> nucleotides = new ArrayList<Nucleotide>();

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
        AminoAcid = findViewById(R.id.AminoAcid);
        ShowMore = findViewById(R.id.ShowMore);

        ArrayAdapter<Nucleotide> NucleotideOneAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Nucleotide.values());
        Nucleotide1.setAdapter(NucleotideOneAdapter1);

        ArrayAdapter<Nucleotide> NucleotideOneAdapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Nucleotide.values());
        Nucleotide2.setAdapter(NucleotideOneAdapter2);

        ArrayAdapter<Nucleotide> NucleotideOneAdapter3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Nucleotide.values());
        Nucleotide3.setAdapter(NucleotideOneAdapter3);

        Nucleotide1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
