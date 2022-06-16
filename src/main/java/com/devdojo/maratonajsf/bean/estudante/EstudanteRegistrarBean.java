package be.com.devdojo.maratonajsf.bean.estudante;

import be.com.devdojo.maratonajsf.model.Estudante;

import javax.inject.Named;
import java.io.Serializable;

@Named
public class EstudanteRegistrarBean implements Serializable {
    private Estudante estudante = new Estudante();

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
