package com.devdojo.maratonajsf.bean.estudante;

import com.devdojo.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
/**
 * O ViewScoped faz com que, enquanto o usuario estiver na mesma tela, os objetos permaneçam no mesmo estado.
 */
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {
    private Estudante estudante = new Estudante();

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
