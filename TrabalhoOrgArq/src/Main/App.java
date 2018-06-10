package Main;


import Leitura_Impressao_Arquivo.Arquivo;
import Leitura_Impressao_Arquivo.Impressoes;
import Leitura_Impressao_Arquivo.Leituras;

import java.util.Scanner;

/**
 *
 * Disciplina: Organização e Arquitetura de Computadores
 *
 * Professor: Dr. Sérgio Johann Filho
 *
 *
 * A aplicacao implementada neste projeto foi proposto pela disciplina de Organizacao e
 * Arquitetura de Computadores, onde o objetivo eh simular uma memoria cache que utiliza
 * dois tipos de mapeamento, mapeamento direto e mapeamento associativo.
 *
 *
 * Os enderecos fornecidos foram obtidos a partir de um codigo assembly feito pelo professor
 * e executado no simulador viking, uma aplicacao tambem implementada pelo professor
 *
 *
 * A partir disso deveria ser implementado:
 *
 *  - Uma memoria cache de 16 linhas utilizando mapeamento direto
 *      Endereco no formato:
 *          10 bits para tag, 4 bits para linha e 2 bits para palavra
 *  - Uma memoria cache de 32 linhas utilizando mapeamento direto
 *      Endereco no formato:
 *          10 bits para tag, 5 bits para linha e 1 bit para palavra
 *  - Uma memoria cache de 16 linhas utilizando mapeamento associativo
 *      Endereco no formato:
 *          14 bits para tag e 2 bits para palavra
 *  - Uma memoria cache de 32 linhas utilizando mapeamento associativo
 *      Endereco no formato:
 *          15 bits para tag e 1 bits para palavra
 *
 *  O mapeamento associativo utilizou a politica de substituicao com contador
 *
 *
 */

public class App {
    private static Impressoes impressoes;

    /**
     *
     * Inicializa a variavel leituras e chama o metodo le() da classe Leituras
     * o qual inicializa os contadores de hits e misses das quatro configuracoes
     * das caches
     *
     * Inicializa a variavel impressoes e chama o metodo imprime() da classe
     * Impressoes, o qual cria as Strings contendo cada uma das opcoes abaixo:
     *
     *   - Valores do Mapeamento Associativo (variavel correspondente = valoresAssociativo)
     *   - Valores do Mapeamento Direto (variavel correspondente = valoresDireto)
     *   - Cache do Mapeamento Associativo (variavel correspondente = cacheMapAsso)
     *   - Cache do Mapeamento Direto (variavel correspondente = cacheMapDir
     *
     *
     * Chama o metodo acoesUsuario() para comecar a interacao entre o sistema e o usuario
     *
     * @param args utilizacao no terminal
     * @method acoesUsuario()
     * @throws Exception caso ocorra algum erro na escrita e|ou leitura do arquivo
     */

    public static void main(String[] args) throws Exception{
        Leituras leituras = new Leituras();
        leituras.le();

        impressoes = new Impressoes(leituras);
        impressoes.imprime();

        acoesUsuario();


    }

    /**
     *
     * Enquanto o usuario quiser realizar as acoes de impressao no terminal, o metodo
     * 'acoesImpressao()' continua sendo chamado
     *
     * Quando o usuario quiser parar de realizar acoes no terminal deve digitar '0'
     *
     * Terminando as acoes com o terminal, o usuario entra em outro loop para realizar
     * acoes com arquivos, ou seja, dados que ele deseja salvar
     *
     * Enquanto o usuario quiser realizar as acoes de criacao de arquivos, o metodo
     * 'acoesSalvar()' continua sendo chamado
     *
     * Quando o usuario quiser parar de realizar as acoes deve digitar '0'
     *
     * A aplicacao eh encerrada
     *
     *
     *
     * @method acoesImpressao()
     * @method acoesSalvar()
     * @throws Exception caso ocorra algum erro na escrita do arquivo
     */

    private static void acoesUsuario() throws Exception{
        System.out.println("Para sair digite 0");

        System.out.println("Dados a serem impressos no terminal");

        while (acoesImpressao())
            acoesImpressao();



        System.out.println("Dados a serem salvos em arquivos dentro da pasta do projeto");

        while (acoesSalvar())
            acoesSalvar();
    }

    /**
     *
     * Inicializa uma variavel da classe Scanner e apresenta as opcoes dentro do metodo 'escolhasImpressao()'
     * para o usuario
     *
     * Armazena na variavel 'opcao' a escolha do usuario:
     *  - caso seja '0', o metodo acaba;
     *  - caso seja '-1', a aplicacao para;
     *  - caso seja maior que '15', o sistema imprime uma mensagem de erro, chama o metodo 'pausa()',
     * apresenta novamente as opcoes para o usuario e altera a varivel 'opcao' para a nova escolha do usuario
     *  - caso nao caia em nenhuma das validacoes anteriores, o metodo encontra multiplas opcoes
     *
     * A aplicacao exibe no terminal o retorno da classe Impressoes que corresponde a escolha do usuario
     *
     * Caso nao seja uma opcao valida, ha mais uma verificacao que tambem imprime uma mensagem de erro
     *
     * Chama o metodo pausa para impedir a exibicao das opcoes logo apos a exibicao do retorno da classe Impressoes
     *
     * Retorna true para continuar o loop
     *
     *
     *
     * @method escolhasImpressao()
     * @method pausa()
     * @method metodos da classe Impressoes
     * @return boolean
     */

    private static boolean acoesImpressao(){
        Scanner in = new Scanner(System.in);

        escolhasImpressao();

        Integer opcao = in.nextInt();

        if (opcao == 0)
            return false;

        if (opcao == -1)
            System.exit(1);

        while (opcao > 15){
            System.err.println("Opcao invalida!\n");
            pausa();
            escolhasImpressao();
            opcao = in.nextInt();
        }

        switch (opcao){
            case 1:
                System.out.println("\n" + impressoes.getDocumentoCompleto());
                break;
            case 2:
                System.out.println("\n" + impressoes.getValores());
                break;
            case 3:
                System.out.println("\n" + impressoes.getCaches());
                break;
            case 4:
                System.out.println("\n" + impressoes.getAssociativo());
                break;
            case 5:
                System.out.println("\n" + impressoes.getDireto());
                break;
            case 6:
                System.out.println("\n" + impressoes.getValorAssociativo());
                break;
            case 7:
                System.out.println("\n" + impressoes.getValorDireto());
                break;
            case 8:
                System.out.println("\n" + impressoes.getCacheMapAsso());
                break;
            case 9:
                System.out.println("\n" + impressoes.getCacheMapDir());
                break;
            case 10:
                System.out.println("\n" + impressoes.getPorcentagemHits());
                break;
            case 11:
                System.out.println("\n" + impressoes.getPorcentagemHitsAssociativo());
                break;
            case 12:
                System.out.println("\n" + impressoes.getPorcentagemHistDireto());
                break;
            case 13:
                System.out.println("\n" + impressoes.getQuantidadeHitsMisses());
                break;
            case 14:
                System.out.println("\n" + impressoes.getQuantidadeHitsMissesAssociativo());
                break;
            case 15:
                System.out.println("\n" + impressoes.getQuantidadeHitsMissesDireto());
                break;
            default:
                System.err.println("\n" + "Opcao Invalida!");
        }

        System.out.println("\n");
        pausa();
        return true;
    }

    /**
     *
     * Exibe para o usuario as opcoes de impressao no terminal
     *
     *
     */

    private static void escolhasImpressao(){
        System.out.println("Escolha sua impressao:");
        System.out.println("1  - Todos os dados armazenados");
        System.out.println("2  - Todos os valores armazenados");
        System.out.println("3  - Todas as caches armazenadas");
        System.out.println("4  - Todos dados do Mapeamento Associativo");
        System.out.println("5  - Todos dados do Mapeamento Direto");
        System.out.println("6  - Valores do Mapeamento Associativo");
        System.out.println("7  - Valores do Mapeamento Direto");
        System.out.println("8  - Cache do Mapeamento Associativo");
        System.out.println("9  - Cache do Mapeamento Direto");
        System.out.println("10 - Porcentagens de hits");
        System.out.println("11 - Porcentagem de hits do Mapeamento Associativo");
        System.out.println("12 - Porcentagem de hits do Mapeamento Direto");
        System.out.println("13 - Quantidade de hits e misses");
        System.out.println("14 - Quantidade de hits e misses do Mapeamento Associativo");
        System.out.println("15 - Quantidade de hits e misses do Mapeamento Direto");
    }

    /**
     *
     * Inicializa uma variavel da classe Arquivo e uma variavel da classe Scanner
     *
     * Apresenta as opcoes dentro do metodo 'escolhasSalvar()'
     *
     * Armazena na variavel 'opcao' a escolha do usuario:
     *  - caso seja '0', a aplicacao para
     *  - caso seja maior que '15', o sistema imprime uma mensagem de erro, chama o metodo 'pausa()',
     * apresenta novamente as opcoes para o usuario e altera a varivel 'opcao' para a nova escolha do usuario
     *  - caso nao caia em nenhuma das validacoes anteriores, o metodo encontra multiplas opcoes
     *
     * A aplicacao salva na pasta do projeto o arquivo correspondente a escolha do usuario
     *
     * Caso nao seja uma opcao valida, ha mais uma verificacao que tambem imprime uma mensagem de erro
     *
     * Chama o metodo pausa para impedir a exibicao das opcoes logo apos o salvamento
     *
     * Retorna true para continuar o loop
     *
     *
     *
     *
     * @method escolhasSalvar()
     * @method pausa()
     * @return boolean
     * @throws Exception caso ocorra algum erro na escrita do arquivo
     */

    private static boolean acoesSalvar() throws Exception{
        Arquivo arquivo = new Arquivo(impressoes);
        Scanner in = new Scanner(System.in);

        escolhasSalvar();

        Integer opcao = in.nextInt();

        if (opcao == 0)
            System.exit(1);

        while (opcao > 9){
            System.err.println("Opcao invalida!\n");
            pausa();
            escolhasSalvar();
            opcao = in.nextInt();
        }

        switch (opcao){
            case 1:
                arquivo.escreveDocumentoCompleto();
                break;
            case 2:
                arquivo.escreveValores();
                break;
            case 3:
                arquivo.escreveCaches();
                break;
            case 4:
                arquivo.escreveAssociativo();
                break;
            case 5:
                arquivo.escreveDireto();
                break;
            case 6:
                arquivo.escreveValorAssociativo();
                break;
            case 7:
                arquivo.escreveValorDireto();
                break;
            case 8:
                arquivo.escreveCacheAssociativo();
                break;
            case 9:
                arquivo.escreveCacheDireto();
                break;
            default:
                System.err.println("\n" + "Opcao Invalida!");
        }

        System.out.println("\n");

        pausa();

        return true;
    }

    /**
     *
     * Exibe para o usuario as opcoes de salvamento de arquivo
     *
     *
     */

    private static void escolhasSalvar(){
        System.out.println("Escolha seu dado a ser salvo:");
        System.out.println("1  - Todos os dados armazenados");
        System.out.println("2  - Todos os valores armazenados");
        System.out.println("3  - Todas as caches armazenadas");
        System.out.println("4  - Todos dados do Mapeamento Associativo");
        System.out.println("5  - Todos dados do Mapeamento Direto");
        System.out.println("6  - Valores do Mapeamento Associativo");
        System.out.println("7  - Valores do Mapeamento Direto");
        System.out.println("8  - Cache do Mapeamento Associativo");
        System.out.println("9  - Cache do Mapeamento Direto");
    }

    /**
     *
     * Inicializa uma variavel da classe Scanner
     *
     * Metodo utilizado para impedir que sejam exibidas as opcoes novamente logo apos
     * o salvamento do arquivo ou exibicao do retorno
     *
     * Se for inserido '0', a aplicacao para
     *
     *
     */

    private static void pausa(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nDigite qualquer coisa");
        String aux = in.next();

        if (aux.equals("0"))
            System.exit(1);

        System.out.println("\n\n\n\n\n\n\n\n");
    }
}
