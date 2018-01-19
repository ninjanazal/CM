package a8794.plantas.ipca.plantas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PlantaDetailsActivity extends AppCompatActivity {

    public static final String EXTRANOME = "extraNome";
    public static final String EXTRALATIM = "extraLatim";
    public static final String EXTRADESC = "extraDesc";

    String plantaNome, plantaNomeLatim,plantaDesc;
    TextView textViewNome, textViewNomeLatim, textViewDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planta_details);

        plantaNome = getIntent().getStringExtra(EXTRANOME);
        plantaNomeLatim = getIntent().getStringExtra(EXTRALATIM);
        plantaDesc = getIntent().getStringExtra(EXTRADESC);

        setTitle(plantaNome);

        textViewNome = (TextView)findViewById(R.id.textViewDetailsNome);
        textViewNomeLatim=(TextView)findViewById(R.id.textViewDetailsNomeLatim);
        textViewDesc = (TextView)findViewById(R.id.textViewDetailsDesc);

        textViewNome.setText(plantaNome);
        textViewNomeLatim.setText(plantaNomeLatim);
        textViewDesc.setText(plantaDesc);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.planta_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.actionShare){
            Intent intentShare = new Intent(Intent.ACTION_SEND);
            intentShare.setType("text/plain");
            intentShare.putExtra(Intent.EXTRA_SUBJECT,plantaNome);
            intentShare.putExtra(Intent.EXTRA_TEXT,plantaNomeLatim);
            intentShare.putExtra(Intent.EXTRA_TEXT,plantaDesc);
            startActivity(Intent.createChooser(intentShare,"Partilhar"));
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
