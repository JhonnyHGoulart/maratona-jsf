package com.devdojo.maratonajsf.bean.view;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
/**
 * O ViewScoped deixará os objétos do bean vivos, apenas enquando o usuario estiver na mesma página.
 */
@ViewScoped
public class TesteViewBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    /**
     * O PostConstruct faz com que o método seja inicializado após os atributos e os construtores,
     * ele deve ser por padrão public e void.
     */
    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ViewScoped");
        personagens = asList("Nartuo", "Hinata", "Yondaime");
    }

    /**
     * ThreadLocalRandom.current().nextInt(3);
     * Cria um número aleatório e atribui esse número para a variável index;
     * Em seguida criamos a variável personegem recebendo personegens na posição do index criado aleatóriamente;
     * Logo depois inserimos na variávle personagemSelecionado a variável personagem.
     */
    public void selecionaPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
