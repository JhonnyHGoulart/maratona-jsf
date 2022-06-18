package com.devdojo.maratonajsf.bean.conversation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
/**
 * O ConversationScoped serve para que, quando precisarmos criar um processo onde o usuário precise clicar em
 * "next next next e finish", o bean vique vivo durante esse processo;
 * O ConversationScoped possui 2 estados:
 * TRANSIENT: É quando cria-se um bean que é do tipo ConversationScoped,ele fica como se estivesse em modo de espera.
 * LONG RUNNING: é quando iniciamos o conversation.
 */
@ConversationScoped
public class TesteConversationBean implements Serializable {
    private List<String> personagens = asList("Vegeta", "Goku", "Gohan");
    private List<String> personagemSelecionado = new ArrayList<>();

    /**
     * No Inject abaixo, estamos fazendo com que sejá injetado o Conversation,
     * para podermos usa-lo sem se preocupar com sua criação ou suas dependencias.
     */
    @Inject
    private Conversation conversation;

    /**
     * No if do método init abaixo, está sendo verificado se o Conversation é transiente,
     * pois se tentarmos iniciar ou finalizar o mesmo sem essa verificação, teremos uma exeption;
     * Com o código "conversation.isTransient()" fazemos a verificação;
     * Com o código "conversation.begin()" iniciamos o Conversation.
     */
    public void init() {
        System.out.println("Entrou no PostConstruct do ConversationScoped");
        personagens = asList("Luffy", "Zoro", "Sanji");
        if (conversation.isTransient()) {
            //LONG RUNNING
            conversation.begin();
            System.out.println("Iniciando o Conversation Scoped, ID=" + conversation.getId());
        }
    }

    /**
     * No método abaixo, estamos verificando se o Conversation não é trasiente, e finalizando o mesmo,
     * retornando para a mesma página apenas para testes
     */
    public String endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "conversation?faces-redirect=true";
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

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
