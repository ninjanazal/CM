package com.example.geral.testemodelo.Ipca;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Geral on 02/11/2017.
 */

public class Cliente extends RealmObject {

    String nome, email;
    int numTelefone, numAluno;

    public Cliente() { }

    public Cliente(String nome, int num, String email, int numAluno) {
        this.nome = nome;
        this.numTelefone = num;
        this.email = email;
        this.numAluno = numAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumTelefone() {
        return numTelefone;
    }

    public int getNumAluno() {
        return numAluno;
    }

    public void setNumAluno(int numAluno) {
        this.numAluno = numAluno;
    }

    public void setNumTelefone(int numTelefone) {
        this.numTelefone = numTelefone;
    }


    public static void add(final Cliente cliente, Realm realm) {

        RealmResults<Cliente> clientes =
                realm.where(Cliente.class).equalTo("nome", cliente.getNome())
                        .equalTo("numAluno", cliente.getNumAluno())
                        .findAll();

        if (clientes.size() == 0) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Cliente newCliente = realm.createObject(Cliente.class);
                    newCliente.setNome(cliente.getNome());
                    newCliente.setNumTelefone(cliente.getNumTelefone());
                    newCliente.setEmail(cliente.getEmail());
                    newCliente.setNumAluno(cliente.getNumAluno());
                }
            });
        } else {
            update(cliente, realm);
        }
    }

    public static void update(final Cliente cliente, Realm realm) {
        final RealmResults<Cliente> clientes =
                realm.where(Cliente.class).equalTo("nome", cliente.getNome())
                        .equalTo("numAluno", cliente.getNumAluno())
                        .findAll();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (clientes.size() > 0) {
                    clientes.first().setNome(cliente.getNome());
                    clientes.first().setNumTelefone(cliente.getNumTelefone());
                    clientes.first().setNumAluno(cliente.getNumAluno());
                    clientes.first().setEmail(cliente.getEmail());
                }
            }
        });
    }


}
