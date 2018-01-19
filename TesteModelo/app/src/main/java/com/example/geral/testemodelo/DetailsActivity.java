package com.example.geral.testemodelo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by Eurico on 04/11/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    TextView textViewNome, textViewEmail, textViewNumero, textViewNumTelefone;
    Integer num, numTelefone;
    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        nome = getIntent().getStringExtra("NAME");
        num = getIntent().getIntExtra("NUMERO", 0);
        numTelefone = getIntent().getIntExtra("TELEFONE", 0);
        setTitle(nome);

        textViewNome = (TextView) findViewById(R.id.textNameDetail);
        textViewEmail = (TextView) findViewById(R.id.textEmailDetail);
        textViewNumero = (TextView) findViewById(R.id.textNumDetail);
        textViewNumTelefone = (TextView) findViewById(R.id.textTelephoneDetail);

        textViewNome.setText(nome);
        textViewNumero.setText(num.toString());
        textViewEmail.setText(getIntent().getStringExtra("EMAIL"));
        textViewNumTelefone.setText(numTelefone.toString());

    }
}
