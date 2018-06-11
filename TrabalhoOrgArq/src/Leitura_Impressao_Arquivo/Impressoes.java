package Leitura_Impressao_Arquivo;

import MapeamentoAssociativo.CacheAsso;
import MapeamentoDireto.CacheDir;

import java.text.DecimalFormat;

/**
 *
 * Classe responsavel por gerenciar as impressoes de dados potencialmente importantes para o usuario
 *
 *
 */

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
    private String cachesOrig;
    private String cacheMapAsso;
    private String cacheMapDir;
    private String cacheMapAssoOrig;
    private String cacheMapDirOrig;
    private Leituras leituras;

    public Impressoes(Leituras leituras) {
        this.leituras = leituras;

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
        this.cachesOrig = "";


        this.cacheMapAsso = "";
        this.cacheMapAssoOrig = "";

        this.cacheAsso16 = leituras.getCacheAsso16();
        this.cacheAsso32 = leituras.getCacheAsso32();


        this.cacheMapDir = "";
        this.cacheMapDirOrig = "";

        this.cacheDir16 = leituras.getCacheDir16();
        this.cacheDir32 = leituras.getCacheDir32();


        this.df = new DecimalFormat("0.000");

    }

    /**
     *
     * Insere na variavel da classe String 'valoresAssociativo' o valor de retorno de 'imprimeValoresMapAsso()'
     * o qual ira retornar uma pequena tabela contendo a quantidade de hits e misses das duas configuracoes da cache com
     * mapeamento associativo, assim como a porcentagem de hits de cada uma
     *
     * Insere na variavel da classe String 'valoresDireto' o valor de retorno de 'imprimeValoresMapDir()'
     * o qual ira retornar uma pequena tabela contendo a quantidade de hits e misses das duas configuracoes da cache com
     * mapeamento direto, assim como a porcentagem de hits de cada uma
     *
     *
     * @method imprimeValoresMapAsso()
     * @method imprimeValoresMapDir()
     */

    public void imprime(){
        valoresAssociativo = imprimeValoresMapAsso();

        valoresDireto = imprimeValoresMapDir();
    }

    /**
     *
     * Insere na variavel da classe String 'caches' o valor de retorno de 'imprimeCaches()'
     * o qual ira retornar uma pequena tabela contendo a formatacao das quatro configuracoes
     * de cache especificadas no trabalho
     *
     * Insere na variavel da classe String 'cachesOrig' o valor de retorno de 'ímprimeCachesComPosMemoriaOriginal()' o
     * qual ira retornar uma pequena tabela contendo a formatacao das quatro configuracoes de cache especificadas no
     * trabalho com seus enderecos de memoria originais
     *
     *
     *
     * @method imprimeCaches()
     * @method imprimeCachesComPosMemoriaOriginal()
     */

    public void imprime2(){
        caches = imprimeCaches();

        cachesOrig = imprimeCachesComPosMemoriaOriginal();
    }

    /**
     *
     * Retorna uma pequena tabela contendo a quantidade de hits e misses das duas configuracoes da cache
     * commapeamento associativo, assim como a porcentagem de hits de cada uma
     *
     * Utiliza o metodo 'format(double)' da classe DecimalFormat para limitar o numero de casas decimais
     * para tres
     *
     *
     *
     * @method format()
     * @return String
     */

    private String imprimeValoresMapAsso(){
        return "\t\t\t\t\tMapeamento Associativo\n\n" +
                       "\t\t\t  Cache de 16 linhas\n" +
                       "\t\t\t  Hits: " + hitA16 + "\t\t" +
                       "\t\t\t  Misses: " + missA16 + "\n\n" +
                       "\t\t\t  Porcentagem de hits: " + df.format((hitA16*100)/288.0)+ "\n\n\n" +
                       "\t\t\t  Cache de 32 linhas\n" +
                       "\t\t\t  Hits: " + hitA32+"\t\t" +
                       "\t\t\t  Misses: " + missA32 + "\n\n" +
                       "\t\t\t  Porcentagem de hits: " + df.format((hitA32*100)/288.0);
    }

    /**
     *
     * Retorna uma pequena tabela contendo a quantidade de hits e misses das duas configuracoes da cache com
     * mapeamento direto, assim como a porcentagem de hits de cada uma
     *
     * Utiliza o metodo 'format(double)' da classe DecimalFormat para limitar o numero de casas decimais para
     * tres
     *
     *
     *
     * @method format()
     * @return String
     */

    private String imprimeValoresMapDir(){
        return "\t\t\t\t\tMapeamento Direto\n\n" +
                       "\t\t\t  Cache 16 linhas\n" +
                       "\t\t\t  Hits: " + hitD16 + "\t\t" +
                       "\t\t\t  Misses: " + missD16 + "\n\n" +
                       "\t\t\t  Porcentagem de hits: " + df.format((hitD16*100)/288.0)+ "\n\n\n" +
                       "\t\t\t  Cache 32 linhas\n" +
                       "\t\t\t  Hits: " + hitD32 + "\t\t" +
                       "\t\t\t  Misses: " + missD32 + "\n\n" +
                       "\t\t\t  Porcentagem de hits: " + df.format((hitD32*100)/288.0);
    }

    /**
     *
     * Insere na variavel 'cacheMapAsso' o valor de retorno do metodo 'imprimeCacheMapeamentoAssociativo()', o qual
     * ira retornar duas tabelas simulando duas configuracoes de cache com mapeamento associativo
     *
     * Insere na variavel 'cacheMapDir' o valor de retorno do metodo 'imprimeCacheMapeamentoDireto()', o qual ira
     * retornar duas tabelas simulando duas configuracoes de cache com mapeamento direto
     *
     * Retorna a concatenacao das duas variaveis 'cacheMapAsso' e 'cacheMapDir'
     *
     *
     * @method imprimeCacheMapeamentoAssociativo()
     * @method imprimeCacheMapeamentoDireto()
     * @return String
     */

    private String imprimeCaches(){
        cacheMapAsso = imprimeCacheMapeamentoAssociativo();

        cacheMapDir = imprimeCacheMapeamentoDireto();

        return cacheMapAsso + "\n\n\n\n" + cacheMapDir;
    }

    /**
     *
     * Insere na variavel 'cacheMapAssoOrig' o valor de retorno do metodo 'imprimeCacheMapeamentoAssociativo(Leituras)',
     * o qual ira retornar duas tabelas simulando duas configuracoes de cache com mapeamento associativo
     *
     * Insere na variavel 'cacheMapDirOrig' o valor de retorno do metodo 'imprimeCacheMapeamentoDireto(Leituras)', o qual ira
     * retornar duas tabelas simulando duas configuracoes de cache com mapeamento direto
     *
     * Retorna a concatenacao das duas variaveis 'cacheMapAssoOrig' e 'cacheMapDirOrig'
     *
     *
     * @method imprimeCacheMapeamentoAssociativo()
     * @method imprimeCacheMapeamentoDireto()
     * @return String
     */

    private String imprimeCachesComPosMemoriaOriginal(){
        cacheMapAssoOrig = imprimeCacheMapeamentoAssociativo(leituras);

        cacheMapDirOrig = imprimeCacheMapeamentoDireto(leituras);

        return cacheMapAssoOrig + "\n\n\n\n\n" + cacheMapDirOrig;
    }

    /**
     *
     * Retorna duas tabelas simulando duas configuracoes de cache com mapeamento associativo. Com o uso do metodo
     * 'toStringPosMemoriaOriginal()' da cache, eh possivel imprimir todas as linhas da cache juntamente com a
     * posicao de memoria, a tag e o bloco de palavras correspondente de cada linha
     *
     *
     *
     * @method toStringPosMemoriaOriginal()
     * @return String
     */

    private String imprimeCacheMapeamentoAssociativo(Leituras leituras){
        return "\t\t\t\t\tMapeamento associativo\n\n" +
                       "Cache 16 linhas\n" +
                       "Posicao Memoria     ===>        Tag              |  Bloco\n\n" +
                       cacheAsso16.toStringPosMemoriaOriginal(leituras) +
                       "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Posicao Memoria     ===>        Tag               |  Bloco\n\n" +
                       cacheAsso32.toStringPosMemoriaOriginal(leituras);
    }

    /**
     *
     * Retorna duas tabelas simulando duas configuracoes de cache com mapeamento associativo. Com o uso do metodo
     * 'toString()' da cache, eh possivel imprimir todas as linhas da cache juntamente com a posicao de memoria,
     * a tag e o bloco de palavras correspondente de cada linha
     *
     *
     *
     * @method toString()
     * @return String
     */

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

    /**
     *
     * Retorna duas tabelas simulando duas configuracoes de cache com mapeamento direto. Com o uso do metodo
     * 'toStringPosMemoriaOriginal(Leituas)' da cache, eh possivel imprimir todas as linhas da cache juntamente
     * com a posicao de memoria, a propria linha, a tag e o bloco de palavras de cada linha
     *
     *
     *
     * @method toStringPosMemoriaOriginal()
     * @return String
     */

    private String imprimeCacheMapeamentoDireto(Leituras leituras){
        return "\t\t\t\t\tMapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Posicao Memoria     ===>        Linha  | Tag         |  Bloco\n" +
                       cacheDir16.toStringPosMemoriaOriginal(leituras) +
                       "\n\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Posicao Memoria     ===>        Linha  | Tag         | Bloco\n" +
                       cacheDir32.toStringPosMemoriaOriginal(leituras);
    }

    /**
     *
     * Retorna duas tabelas simulando duas configuracoes de cache com mapeamento direto. Com o uso do metodo
     * 'toString()' da cache, eh possivel imprimir todas as linhas da cache juntamente com a posicao de memoria,
     * a propria linha, a tag e o bloco de palavras de cada linha
     *
     *
     *
     * @method toString()
     * @return String
     */

    private String imprimeCacheMapeamentoDireto() {
        return "\t\t\t\t\tMapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Posicao Memoria     ===>        Linha  | Tag         |  Bloco\n" +
                       cacheDir16.toString() +
                       "\n\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Posicao Memoria     ===>        Linha  | Tag         | Bloco\n" +
                       cacheDir32.toString();
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'valoresDireto'
     *
     * @return String
     */

    public String getValorDireto(){
        return valoresDireto;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'valoresAssociativo'
     *
     * @return String
     */

    public String getValorAssociativo(){
        return valoresAssociativo;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheMapAsso'
     *
     * @return String
     */

    public String getCacheMapAsso(){
        return cacheMapAsso;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheMapDir'
     *
     * @return String
     */

    public String getCacheMapDir(){
        return cacheMapDir;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'caches'
     *
     *
     * @return String
     */

    public String getCaches(){
        return caches;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cachesOrig'
     *
     *
     * @return String
     */

    public String getCachesOrig(){
        return cachesOrig;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheMapAssoOrig'
     *
     *
     * @return String
     */

    public String getCacheMapAssoOrig(){return cacheMapAssoOrig;}

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheMapDirOrig'
     *
     *
     * @return String
     */

    public String getCacheMapDirOrig(){return cacheMapDirOrig;}

    /**
     *
     * Retorna a contatenacao dos valores armazenados nas variaveis 'valoresAssociativo' e 'cacheMapAsso'
     *
     *
     *
     * @return String
     */

    public String getAssociativo(){
        return valoresAssociativo + "\n\n\n\n\n\n\n\n" + cacheMapAsso;
    }

    /**
     *
     * Retorna a contatenacao dos valores armazenados nas variaveis 'valoresAssociativo' e 'cacheMapAssoOrig'
     *
     *
     *
     * @return String
     */

    public String getAssociativoOrig(){return valoresAssociativo + "\n\n\n\n\n\n\n" + cacheMapAssoOrig; }

    /**
     *
     * Retorna a contatenacao dos valores armazenados nas variaveis 'valoresDireto' e 'cacheMapDir'
     *
     *
     *
     * @return String
     */

    public String getDireto(){
        return valoresDireto + "\n\n\n\n\n\n\n\n" + cacheMapDir;
    }

    /**
     *
     * Retorna a contatenacao dos valores armazenados nas variaveis 'valoresDireto' e 'cacheMapDirOrig'
     *
     *
     * @return String
     */

    public String getDiretoOrig(){return valoresDireto + "\n\n\n\n\n\n\n" + cacheMapDirOrig; }

    /**
     *
     * Retorna a contatenacao dos valores armazenados nas variaveis 'valoresAssociativo' e 'valoresDireto'
     *
     *
     *
     * @return String
     */

    public String getValores(){
        return valoresAssociativo + "\n\n\n\n\n\n" + valoresDireto;
    }

    /**
     *
     * Retorna a contatenacao dos valores armazenados nas variaveis 'valoresAssociativo', 'valoresDireto'
     * e 'caches'
     *
     *
     *
     * @return String
     */

    public String getDocumentoCompleto(){
        return valoresAssociativo + "\n\n\n\n\n\n" + valoresDireto + "\n\n\n\n\n\n\n\n" + caches;
    }

    /**
     *
     * Retorna uma tabela contendo a porcentagem de hits das quatro configuracoes de cache
     * definidas para esta aplicacoes
     *
     * O metodo 'format(double)' da classe DecimalFormat eh utilizado para limitar ate tres
     * casas decimais
     *
     *
     *
     * @method format()
     * @return String
     */

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

    /**
     *
     * Retorna uma tabela contendo a porcentagem de hits das duas configuracoes da
     * cache com mapeamento associativo
     *
     * O metodo 'format(double)' da classe DecimalFormat eh utilizado para limitar ate tres
     * casas decimais
     *
     *
     * @method format()
     * @return String
     */

    public String getPorcentagemHitsAssociativo(){
        return "   Mapeamento Associativo\n\n" +
                       "Cache de 16 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitA16*100)/288.0)+
                       "\n\n\n" +
                       "Cache de 32 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitA32*100)/288.0);
    }

    /**
     *
     * Retorna uma tabela contendo a porcentagem de hits das duas configuracoes da
     * cache com mapeamento direto
     *
     * O metodo 'format(double)' da classe DecimalFormat eh utilizado para limitar ate tres
     * casas decimais
     *
     *
     * @method format()
     * @return String
     */

    public String getPorcentagemHistDireto(){
        return "   Mapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitD16*100)/288.0) + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Porcentagem de hits: " + df.format((hitD32*100)/288.0);
    }

    /**
     *
     * Retorna uma tabela contendo a quantidade de misses e hits das quatro configuracoes
     * de cache definidas para esta aplicacao
     *
     *
     *
     * @return String
     */

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

    /**
     *
     * Retorna uma tabela contendo a quantidade de misses e hits das duas configuracoes
     * de cache com mapeamento associativo
     *
     *
     *
     * @return String
     */

    public String getQuantidadeHitsMissesAssociativo(){
        return "   Mapeamento Associativo\n\n" +
                       "Cache de 16 linhas\n" +
                       "Hits: " + hitA16 + "\t\t" +
                       "Misses: " + missA16 + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Hits: " + hitD32 + "\t\t" +
                       "Misses: " + missD32;
    }

    /**
     *
     * Retorna uma tabela contendo a quantidade de misses e hits das duas configuracoes
     * de cache com mapeamento direto
     *
     *
     *
     * @return String
     */

    public String getQuantidadeHitsMissesDireto(){
        return "    Mapeamento Direto\n\n" +
                       "Cache 16 linhas\n" +
                       "Hits: " + hitD16 + "\t\t" +
                       "Misses: " + missD16 + "\n\n\n" +
                       "Cache 32 linhas\n" +
                       "Hits: " + hitD32 + "\t\t" +
                       "Misses: " + missD32;
    }

    /**
     *
     * Retorna duas tabelas simulando quatro configuracoes de cache definidas na aplicacao. Com o uso do metodo
     * 'toStringTxt()' da cache, eh possivel imprimir todas as linhas da cache juntamente com a posicao de memoria,
     * a tag e o bloco de palavras concatenadas com a tag correspondente de cada linha
     *
     *
     *
     * @method toStringTxt()
     * @return String
     */

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

    /**
     *
     * Retorna o valor armazenado na variavel 'leituras'
     *
     *
     * @return String
     */

    Leituras getLeituras(){
        return leituras;
    }

}