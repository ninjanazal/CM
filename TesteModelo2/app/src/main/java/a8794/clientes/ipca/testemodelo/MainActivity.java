package a8794.clientes.ipca.testemodelo;

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
    List<Cliente> clientes = new ArrayList<>();
    ClienteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Clientes");

        listView = findViewById(R.id.listViewClients);

        clientes.add(new Cliente("Eurico Martins", "eurico_martins@live.com.pt", "917120560", clientes.size() + 1));
        clientes.add(new Cliente("Laura Rodrigues", "lauramartinsr18@gmail.com", "964688296", clientes.size() + 1));
        clientes.add(new Cliente("Lady Laura", "ladylaura@email.com", "917120561", clientes.size() + 1));
        clientes.add(new Cliente("Cloe", "cloethefish@email.com", "9000000000", clientes.size() + 1));


        adapter = new ClienteAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }

    class ClienteAdapter extends BaseAdapter implements View.OnClickListener {
        @Override
        public int getCount() {
            return clientes.size();
        }

        @Override
        public Object getItem(int i) {
            return clientes.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.row_main, null);

            TextView textViewNome = (TextView) view.findViewById(R.id.textViewName);
            TextView textViewNum = (TextView) view.findViewById(R.id.textViewNum);

            textViewNome.setText(clientes.get(i).getNome());
            textViewNum.setText(clientes.get(i).getNumeroTelefone());

            view.setTag(new Integer(i));
            view.setOnClickListener(this);
            view.setClickable(true);

            return view;
        }

        @Override
        public void onClick(View view) {
            Integer position = (Integer) view.getTag();
            Intent intent = new Intent(MainActivity.this, ClientDetailsActivity.class);
            intent.putExtra(ClientDetailsActivity.EXTRA_NAME, clientes.get(position).getNome());
            intent.putExtra(ClientDetailsActivity.EXTRA_NUM, clientes.get(position).getNum().toString());
            intent.putExtra(ClientDetailsActivity.EXTRA_EMAIL, clientes.get(position).getEmail());
            intent.putExtra(ClientDetailsActivity.EXTRA_MOBILE, clientes.get(position).getNumeroTelefone());
            startActivity(intent);
        }
    }
}
