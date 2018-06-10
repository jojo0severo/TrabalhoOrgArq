package Leitura_Impressao_Arquivo;

import MapeamentoAssociativo.CacheAsso;
import MapeamentoDireto.CacheDir;

import java.text.DecimalFormat;

public class Impressoes {
    private DecimalFormat df;
    private Integer hitA16;
    private Integer missA16;
    private Integer hitA32;
    private Integer missA32;
    private Integer hitD16;
    private Integer missD16;
    private Integer hitD32;
    private Integer missD32;
    private CacheAsso cacheAsso16;
    private CacheAsso cacheAsso32;
    private CacheDir cacheDir16;
    private CacheDir cacheDir32;
    private String valoresDireto;
    private String valoresAssociativo;
    private String caches;
    private String cacheMapAsso;
    private String cacheMapDir;

    public Impressoes(Leituras leituras) {
        this.valoresAssociativo = "";

        this.hitA16 = leituras.getHitA16();
        this.missA16 = leituras.getMissA16();

        this.hitA32 = leituras.getHitA32();
        this.missA32 = leituras.getMissA32();


        this.valoresDireto = "";

        this.hitD16 = leituras.getHitD16();
        this.missD16 = leituras.getMissD16();

        this.hitD32 = leituras.getHitD32();
        this.missD32 = leituras.getMissD32();


        this.caches = "";


        this.cacheMapAsso = "";

        this.cacheAsso16 = leituras.getCacheAsso16();
        this.cacheAsso32 = leituras.getCacheAsso32();


        this.cacheMapDir = "";

        this.cacheDir16 = leituras.getCacheDir16();
        this.cacheDir32 = leituras.getCacheDir32();


        this.df = new DecimalFormat("0.000");

    }

    public void imprime(){
        valoresAssociativo = imprimeValoresMapAsso();

        valoresDireto = imprimeValoresMapDir();

        caches = imprimeCaches();
    }

    private String imprimeValoresMapAsso(){
        return "   Mapeamento Associativo\n\n" +
                       "Cache de 16 linhas\n" +
                       "Hits: " + hitA16 + "\t\t" +
                       "Misses: " + missA16 + "\n\n" +
                       "Porcentagem de hits: " + df.format((hitA16*100)/288.0)+ "\n\n\n" +
                       "Cache de 32 linhas\n" +
                       "Hits: " + hitA32+"\t\t" +
                       "Misses: " + missA32 + "\n\n" +
                       "Porcentagem de hits: " + df.format((hitA32*100)/288.0);
    }

    private String imprimeValoresMapDir(){
        return "    Mapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Hits: " + hitD16 + "\t\t" +
                       "Misses: " + missD16 + "\n\n" +
                       "Porcentagem de hits: " + df.format((hitD16*100)/288.0)+ "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Hits: " + hitD32 + "\t\t" +
                       "Misses: " + missD32 + "\n\n" +
                       "Porcentagem de hits: " + df.format((hitD32*100)/288.0);
    }

    private String imprimeCaches(){
        cacheMapAsso = imprimeCacheMapeamentoAssociativo();

        cacheMapDir = imprimeCacheMapeamentoDireto();

        return cacheMapAsso + "\n\n\n\n" + cacheMapDir;
    }

    private String imprimeCacheMapeamentoAssociativo() {
        return "\t\t\t\t\tMapeamento associativo\n\n" +
                       "Cache 16 linhas\n" +
                       "Posicao Memoria     ===>        Tag              |  Bloco\n\n" +
                       cacheAsso16.toString() +
                       "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Posicao Memoria     ===>        Tag               |  Bloco\n\n" +
                       cacheAsso32.toString();

    }

    private String imprimeCacheMapeamentoDireto() {
        return "\t\t\t\t\tMapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Posicao Memoria     ===>        Linha | Tag         |  Bloco\n" +
                       cacheDir16.toString() +
                       "\n\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Posicao Memoria     ===>        Linha  | Tag         | Bloco\n" +
                       cacheDir32.toString();
    }

    public String getValorDireto(){
        return valoresDireto;
    }

    public String getValorAssociativo(){
        return valoresAssociativo;
    }

    public String getCacheMapAsso(){
        return cacheMapAsso;
    }

    public String getCacheMapDir(){
        return cacheMapDir;
    }

    public String getCaches(){
        return caches;
    }

    public String getAssociativo(){
        return valoresAssociativo + "\n\n\n\n\n\n\n\n" + cacheMapAsso;
    }

    public String getDireto(){
        return valoresDireto + "\n\n\n\n\n\n\n\n" + cacheMapDir;
    }

    public String getValores(){
        return valoresAssociativo + "\n\n\n\n\n\n" + valoresDireto;
    }

    public String getDocumentoCompleto(){
        return valoresAssociativo + "\n\n\n\n\n\n" + valoresDireto + "\n\n\n\n\n\n\n\n" + caches;
    }

    public String getPorcentagemHits(){
        return "   Mapeamento Associativo\n\n" +
                       "Cache de 16 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitA16*100)/288.0) + "\n\n\n" +
                       "Cache de 32 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitA32*100)/288.0) +
                       "\n\n\n\n\n"+
                       "   Mapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitD16*100)/288.0) + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitD32*100)/288.0);

    }

    public String getPorcentagemHitsAssociativo(){
        return "   Mapeamento Associativo\n\n" +
                       "Cache de 16 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitA16*100)/288.0)+
                       "\n\n\n" +
                       "Cache de 32 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitA32*100)/288.0);
    }

    public String getPorcentagemHistDireto(){
        return "   Mapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitD16*100)/288.0) + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitD32*100)/288.0);
    }

    public String getQuantidadeHitsMisses(){
        return "   Mapeamento Associativo\n\n" +
                       "Cache de 16 linhas\n" +
                       "Hits: " + hitA16 + "\t\t" +
                       "Misses: " + missA16 + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Hits: " + hitD32 + "\t\t" +
                       "Misses: " + missD32 +
                       "\n\n\n\n\n" +
                       "    Mapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Hits: " + hitD16 + "\t\t" +
                       "Misses: " + missD16 + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Hits: " + hitD32 + "\t\t" +
                       "Misses: " + missD32;
    }

    public String getQuantidadeHitsMissesAssociativo(){
        return "   Mapeamento Associativo\n\n" +
                       "Cache de 16 linhas\n" +
                       "Hits: " + hitA16 + "\t\t" +
                       "Misses: " + missA16 + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Hits: " + hitD32 + "\t\t" +
                       "Misses: " + missD32;
    }

    public String getQuantidadeHitsMissesDireto(){
        return "    Mapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Hits: " + hitD16 + "\t\t" +
                       "Misses: " + missD16 + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Hits: " + hitD32 + "\t\t" +
                       "Misses: " + missD32;
    }

    String getCachesTxt(){
        return "\t\t\t\t\tMapeamento associativo\n\n" +
                       "Cache 16 linhas\n" +
                       "Posicao Memoria     ===>        Tag              |  Bloco\n\n" +
                       cacheAsso16.toStringTxt() +
                       "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Posicao Memoria     ===>        Tag               |  Bloco\n\n" +
                       cacheAsso32.toStringTxt() +
                       "\n\n\n\n" +
                       "\t\t\t\t\tMapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Posicao Memoria     ===>        Linha | Tag         |  Bloco\n" +
                       cacheDir16.toStringTxt() +
                       "\n\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Posicao Memoria     ===>        Linha  | Tag         | Bloco\n" +
                       cacheDir32.toStringTxt();

    }

}