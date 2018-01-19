package a8794.plantas.ipca.plantas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    List<Plantas> plantas;

    PlantasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Plantas");

        plantas = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewPlantas);

        plantas.add(new Plantas("PLanta1", "PlantusLAtinus1", "Descricao planta 1"));
        plantas.add(new Plantas("PLanta2", "PlantusLAtinus2", "Descricao planta 2"));
        plantas.add(new Plantas("PLanta3", "PlantusLAtinus3", "Descricao planta 3"));
        plantas.add(new Plantas("PLanta4", "PlantusLAtinus4", "Descricao planta 4"));


        adapter = new PlantasAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }

    class PlantasAdapter extends BaseAdapter implements View.OnClickListener {

        @Override
        public int getCount() {
            return plantas.size();
        }

        @Override
        public Object getItem(int i) {
            return plantas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.row_planta, null);

            TextView textViewNome = (TextView) view.findViewById(R.id.textViewNome);
            TextView textViewNum = (TextView) view.findViewById(R.id.textViewNomeLatim);

            textViewNome.setText(plantas.get(i).getNomePlanta());
            textViewNum.setText(plantas.get(i).getNomePlantaLatin());

            view.setTag(new Integer(i));
            view.setOnClickListener(this);
            view.setClickable(true);

            return view;
        }


        @Override
        public void onClick(View view) {
            Integer pos = (Integer) view.getTag();
            Intent intent = new Intent(MainActivity.this, PlantaDetailsActivity.class);
            intent.putExtra(PlantaDetailsActivity.EXTRANOME, plantas.get(pos).getNomePlanta());
            intent.putExtra(PlantaDetailsActivity.EXTRALATIM, plantas.get(pos).getNomePlantaLatin());
            intent.putExtra(PlantaDetailsActivity.EXTRADESC, plantas.get(pos).getDesc());
            startActivity(intent);
        }

    }
}
