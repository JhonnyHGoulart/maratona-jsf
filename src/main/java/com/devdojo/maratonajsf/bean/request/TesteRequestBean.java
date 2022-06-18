package com.devdojo.maratonajsf.bean.request;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
/**
 * O RequestScoped irá ficar vivo, apenas durante a requisição http, isso é,
 * não é mantido o estado por mais tempo do que uma requisição fica viva.
 * Ele deve ser usado quando por exemplo, precisa-se apenas exibir dados para o usuário,
 * ou que não envolva a utilização dos valores dessa view.
 */

public class TesteRequestBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    /**
     * O PostConstruct faz com que o método seja inicializado após os atributos e os construtores,
     * ele deve ser por padrão public e void.
     */
    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do RequestScoped");
        personagens = asList("Saitama", "Goku", "kurama");
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
