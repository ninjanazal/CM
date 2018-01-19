package com.example.geral.testemodelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.geral.testemodelo.Ipca.Cliente;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ListView listView;
    RealmResults<Cliente> clientes;
    ClientAdapter adapter;

    // com listas
    //List<Cliente> clientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ipca.Clientes");

        listView = (ListView) findViewById(R.id.listViewClient);


        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        // reseta a BD
        /*
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        */

        // Adiciona clientes á BD
        Cliente.add(new Cliente("Eurico Martins", 917120560, "eurico_martins@live.com.pt", 1), realm);
        Cliente.add(new Cliente("Novo Cliente", 900000000, "test@test.com", 2), realm);
        Cliente.add(new Cliente("abs", 900000001, "test@test.com", 3), realm);
        Cliente.add(new Cliente("Novo Cliente", 900000000, "test@test.com", 4), realm);
        Cliente.add(new Cliente("Laura Rodrigues", 964688296, "laurarodirgez@email.com", 5), realm);


        clientes = realm.where(Cliente.class).findAll();
        adapter = new ClientAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
    }

    class ClientAdapter extends BaseAdapter implements View.OnClickListener {

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
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.row, null);
            }
            TextView textViewName = (TextView) view.findViewById(R.id.textViewClienteName);
            TextView textViewTelephone = (TextView) view.findViewById(R.id.textViewClienteTelefone);

            textViewName.setText(clientes.get(i).getNome());
            textViewTelephone.setText(String.valueOf(clientes.get(i).getNumTelefone()));

            view.setTag(new Integer(i));
            view.setOnClickListener(this);
            view.setClickable(true);

            return view;
        }


        @Override
        public void onClick(View view) {
            Integer position = (Integer) view.getTag();
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("NAME", clientes.get(position).getNome());
            intent.putExtra("TELEFONE", clientes.get(position).getNumTelefone());
            intent.putExtra("NUMERO", clientes.get(position).getNumAluno());
            intent.putExtra("EMAIL", clientes.get(position).getEmail());
            startActivity(intent);
        }
    }

    // com listas
    //
    //class ClientAdapter2 extends BaseAdapter{
    //
    //      @Override
    //     public int getCount() {
    //        return 0;
    //   }
    //
    //      @Override
    //     public Object getItem(int i) {
    //return null;
        //}
    //
    //@Override
    //public long getItemId(int i){
    //  return 0;
    // }
    //
    //@Override
    //public View getView(int i,View view,ViewGroup viewGroup){
    //if(view==null)
    //getLayoutInflater().inflate(R.layout.row,null);
    //
    //TextView textViewName=(TextView)view.findViewById(R.id.textViewClienteName);
    //TextView textViewTelephone=(TextView)view.findViewById(R.id.textViewClienteTelefone);
    //
    //textViewName.setText(clientes.get(i).getNome());
    //textViewTelephone.setText(clientes.get(i).getNumTelefone());
    //
    //return view;
    //}
    //
    //}

}
