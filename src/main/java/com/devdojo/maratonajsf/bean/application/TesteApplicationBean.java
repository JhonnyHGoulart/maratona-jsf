package com.devdojo.maratonajsf.bean.application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
/**
 * O ApplicationScoped irá manter os dados do bean vivos, durante todo o ciclo de vida do servidor,o seja,
 * enquando a sua plicação estiver rodando no servidor, qualquer escopo, de qualquer lugar,
 * poderá acessar os dados de bean que tiver a anotação ApplicationScoped.
 * Imagine o ApllicationScoped como uma classe, onde todos os atributos são estáticos.
 */
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;

    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ApplicationScoped");
        categoriaList = asList("Terror", "Ação", "Suspense");
    }

    /**
     * O método abaixo irá mudar a lita
     */
    public void mudarLista() {
        categoriaList = asList("Terror", "Ação", "Suspense", "Aventura");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
