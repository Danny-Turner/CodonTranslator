package com.example.codontranslator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowMoreActivity extends AppCompatActivity {

    private TextView Name;
    private TextView ThreeLetterCode;
    private TextView SingleLetterCode;
    private TextView AminoAcidDetail;
    private Button ReturnToMainButton;
    private ImageView AminoAcidImage;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more);

        Name = findViewById(R.id.Name);
        ThreeLetterCode = findViewById(R.id.ThreeLetterCode);
        SingleLetterCode = findViewById(R.id.SingleLetterCode);
        AminoAcidDetail = findViewById(R.id.AminoAcidDetail);
        ReturnToMainButton = findViewById(R.id.ReturnToMainButton);
        AminoAcidImage = findViewById(R.id.AminoAcidImageMore);
        ReturnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
