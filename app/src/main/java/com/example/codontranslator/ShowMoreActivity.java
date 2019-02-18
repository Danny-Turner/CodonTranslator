package com.example.codontranslator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ShowMoreActivity extends AppCompatActivity {

    private TextView Name, ThreeLetterCode, SingleLetterCode, Hydrophobic, Polar, AminoAcidDetail;
    private Button ReturnToMainButton;
    private ImageView AminoAcidImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more);
        assignLayoutToObjects();
        displayAdditionalInfo();
        ReturnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void assignLayoutToObjects() {
        Name = findViewById(R.id.Name);
        ThreeLetterCode = findViewById(R.id.ThreeLetterCode);
        SingleLetterCode = findViewById(R.id.SingleLetterCode);
        Hydrophobic = findViewById(R.id.Hydrophobic);
        Polar = findViewById(R.id.Polar);
        AminoAcidDetail = findViewById(R.id.AminoAcidDetail);
        ReturnToMainButton = findViewById(R.id.ReturnToMainButton);
        AminoAcidImage = findViewById(R.id.AminoAcidImageMore);
    }


    private void displayAdditionalInfo() {
        Name.setText(MainActivity.findAminoAcid().getName());
        ThreeLetterCode.setText(MainActivity.findAminoAcid().getThreeLetter());
        SingleLetterCode.setText(MainActivity.findAminoAcid().getSingleLetter().toString());
        Hydrophobic.setText(MainActivity.findAminoAcid().getHydrophobic());
        Polar.setText(MainActivity.findAminoAcid().getPolar());
        AminoAcidImage.setImageResource(getIntent().getIntExtra("ImageID", 0));
        AminoAcidDetail.setText(aminoAcidDescription());
    }


    private String aminoAcidDescription() {
        String information = "";
        try {
            InputStream Description = getAssets().open(MainActivity.findAminoAcid().getDescription());
            Scanner input = new Scanner(Description);
            while (input.hasNextLine()) {
                information += input.nextLine();
            }
            input.close();
        } catch (IOException e) {
            Log.e("MainActivity", "Could not read AminoAcidDescription");
        }
        return information;
    }

}
