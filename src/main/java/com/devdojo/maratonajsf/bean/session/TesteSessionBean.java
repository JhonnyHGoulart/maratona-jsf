package com.devdojo.maratonajsf.bean.session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
/**
 * O SessionScoped irá deixar tudo que tem no bean vivo, enquanto a requisição estiver ativa.
 * Arequisição não estará ativa apenas quando fecharmos o browser,
 * ou quando chamarmos algum método para invalidar a sessão.
 * O SessionScoped deve ser utilizado quando por exemplo,
 * um determinado atributo precisar se utilizado em outras páginas
 */
@SessionScoped
public class TesteSessionBean implements Serializable {
    private List<String> personagens = asList("Vegeta", "Goku", "Gohan");
    private List<String> personagemSelecionado = new ArrayList<>();

    /**
     * O PostConstruct faz com que o método seja inicializado após os atributos e os construtores,
     * ele deve ser por padrão public e void.
     */
    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do SessionScoped");
        personagens = asList("Vegeta", "Goku", "Gohan");
    }

    /**
     * O método abaixo será usado para invalidar uma sessão;
     * FacesContext.getCurrentInstance() para pegar a instância atual;
     * getExternalContext() para pegar o contexto externo;
     * invalidateSession() para invalidar a sessão.
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true";
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
