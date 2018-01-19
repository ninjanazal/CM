package a8794.plantas.ipca.plantas;

/**
 * Created by Eurico on 07/11/2017.
 */

public class Plantas {
    String nomePlanta;
    String nomePlantaLatin;
    String desc;

    public Plantas(String nomePlanta, String nomePlantaLatin, String desc) {
        this.nomePlanta = nomePlanta;
        this.nomePlantaLatin = nomePlantaLatin;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Plantas{" +
                "nomePlanta='" + nomePlanta + '\'' +
                ", nomePlantaLatin='" + nomePlantaLatin + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getNomePlanta() {
        return nomePlanta;
    }

    public void setNomePlanta(String nomePlanta) {
        this.nomePlanta = nomePlanta;
    }

    public String getNomePlantaLatin() {
        return nomePlantaLatin;
    }

    public void setNomePlantaLatin(String nomePlantaLatin) {
        this.nomePlantaLatin = nomePlantaLatin;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
