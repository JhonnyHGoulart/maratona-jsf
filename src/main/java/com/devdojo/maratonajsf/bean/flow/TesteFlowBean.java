package com.devdojo.maratonajsf.bean.flow;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named

/**
 * O FlowScoped é uma versão melhorada do ConversationScoped,
 * algumas vantagens são por exemplo que não precisamos colocar "begin end" na operação,
 * e ele também tem suporte para os parâmetros;
 * Pode-se dizer que ele fica entre o RequestScoped e o SessionScoped.
 * REGRAS PARA UTILIZAR O FLOWSCOPED:
 * 1 - Todas as páginas precisam estar dentro de um mesmo pacote;
 * 2 - Deve ser criado um ponto de entrada fora de pacote, com a extenção .xhtml;
 * 3 - Deve ser criado um ponto de saída;
 * 4 - Deve ser criado um arquivo de configuração com o mesmo nome do pacote e
 * "-flow.xml" dentro do pacote onde serão criadas as páginas.
 */

/**
 * No value do FlowScope abaixo, é inserido o ponto de entrada que foi criado no arquivo de configuração registration-flow.xml.
 */
@FlowScoped(value = "registration")
public class TesteFlowBean implements Serializable {
    private String nome;
    private String sobrenome;
    private String endereco;

    /**
     * No método abaixo, é determinado como retorno o return-node que foi configurado no arquivo registration-flow.xml.
     */
    public String salvar() {
        System.out.println("Salvando no banco");
        System.out.println(nome);
        System.out.println(sobrenome);
        System.out.println(endereco);
        return "exitToInicio";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
