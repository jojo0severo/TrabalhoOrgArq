package Main;


import Leitura_Impressao_Arquivo.Arquivo;
import Leitura_Impressao_Arquivo.Impressoes;
import Leitura_Impressao_Arquivo.Leituras;

import java.util.Scanner;

public class App {
    private static Impressoes impressoes;

    public static void main(String[] args) throws Exception{
        Leituras leituras = new Leituras();
        leituras.le();

        impressoes = new Impressoes(leituras);
        impressoes.imprime();

        acoesUsuario();


    }

    private static void acoesUsuario() throws Exception{
        System.out.println("Para sair digite 0");

        System.out.println("Dados a serem impressos no terminal");

        while (acoesImpressao())
            acoesImpressao();



        System.out.println("Dados a serem salvos em arquivos dentro da pasta do projeto");

        while (acoesSalvar())
            acoesSalvar();
    }

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

    private static void pausa(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nDigite qualquer coisa");
        String aux = in.next();

        if (aux.equals("0"))
            System.exit(1);

        System.out.println("\n\n\n\n\n\n\n\n");
    }
}
