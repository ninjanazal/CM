package a8794.clientes.ipca.testemodelo;

/**
 * Created by Eurico on 06/11/2017.
 */

public class Cliente {
    String nome;
    String email;
    String numeroTelefone;
    Integer num;

    public Cliente(String nome, String email, String numeroTelefone, Integer n) {
        this.nome = nome;
        this.email = email;
        this.numeroTelefone = numeroTelefone;
        this.num = n;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                ", num=" + num +
                '}';
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

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}


