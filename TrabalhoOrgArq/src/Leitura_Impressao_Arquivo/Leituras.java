package Leitura_Impressao_Arquivo;

import MapeamentoAssociativo.CacheAsso;
import MapeamentoAssociativo.MapeamentoAsso;
import MapeamentoDireto.CacheDir;
import MapeamentoDireto.MapeamentoDir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Leituras {
    private BufferedReader bf;
    private String[][] binHexa;
    private HashMap<String, String> enderecoPosMemoria16;
    private HashMap<String, String> enderecoPosMemoria32;
    private Integer hitA16;
    private Integer missA16;
    private Integer hitA32;
    private Integer missA32;
    private Integer hitD16;
    private Integer missD16;
    private Integer hitD32;
    private Integer missD32;
    private MapeamentoAsso mapA16;
    private MapeamentoAsso mapA32;
    private MapeamentoDir mapD16;
    private MapeamentoDir mapD32;

    public Leituras() {
        this.hitA16 = 0;
        this.missA16 = 0;
        this.hitA32 = 0;
        this.missA32 = 0;
        this.hitD16 = 0;
        this.missD16 = 0;
        this.hitD32 = 0;
        this.missD32 = 0;

        this.mapA16 = new MapeamentoAsso(16);
        this.mapA32 = new MapeamentoAsso(32);

        this.mapD16 = new MapeamentoDir(16);
        this.mapD32 = new MapeamentoDir(32);
    }

    /**
     *
     * Chama os metodos que iram atribuir as quantidades de hits e misses das
     * quatro configuracoes da cache definidas para esta aplicacao
     *
     * O metodo 'leAssociativoAdresses16()' atribui valores as variaveis:
     *      'hitA16' e 'missA16'
     *
     * O metodo 'leAssociativoAdresses32()' atribui valores as variaveis:
     *      'hitA32' e 'missA32'
     *
     * O metoto 'leDiretoAdresses16()' atribui valores as variaveis:
     *      'hitD16' e 'missD16'
     *
     * O metodo 'leDiretoAdresses32()' atribui valores as variaveis:
     *      'hitD32' e 'missD32'
     *
     * O metodo 'leAdressesBin()' atribui valor a variavel:
     *      'binHexa'
     *
     *
     *
     * @method leAssociativoAdresses16()
     * @method leAssociativoAdresses32()
     * @method leDiretoAdresses16()
     * @method leDiretoAdresses32()
     * @method leAdressesBin()
     * @method guardaEnderecos()
     * @throws Exception se houver algum erro durante a leitura do arquivo
     */

    public void le() throws Exception{
        leAssociativoAdresses16();

        leAssociativoAdresses32();

        leDiretoAdresses16();

        leDiretoAdresses32();

        leAdressesBin();
    }

    /**
     *
     * Chama os metodos que ira atribuir valores aos dicionarios contendo o valor
     * em binario como chave e o valor em hexadecimal como valor
     *
     * O metodo 'guardaEnderecos()' atribui valores as variaveis:
     *      'enderecoPostMemoria16' e 'enderecoPosMemoria32'
     *
     *
     *
     * @method guardaEnderecos()
     */

    public void le2(){
        guardaEnderecos();
    }

    /**
     *
     * Metodo inicializador dos metodos 'guardaEnderecosOriginais16()' e 'guardaEnderecosOriginais32()'
     *
     *
     *
     * @method guardaEnderecosOriginais32()
     * @method guardaEnderecosOriginais16();
     */

    private void guardaEnderecos(){
        guardaEnderecosOriginais16();

        guardaEnderecosOriginais32();
    }

    /**
     *
     * O arquivo eh lido linha a linha atraves do metodo 'readLine()' da classe
     * BufferedReader, onde cada linha eh armazenada na variavel 'line'
     *
     * Para cada linha lida, o metodo 'add(String)' da classe MapeamentoAsso retorna
     * 'hit' ou 'miss'
     *
     * Caso retorne 'hit', a variavel 'hitA16' eh incrementada
     *
     * Caso retorne 'miss', a variavel 'missA16' eh incrementada
     *
     *
     *
     * @method add()
     * @method readLine()
     * @throws Exception se houver algum erro durante a leitura do arquivo
     */

    private void leAssociativoAdresses16()throws Exception{
        bf = new BufferedReader(new FileReader(new File("ArquivosNecessarios/AdressesBin.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapA16.add16(line).equals("hit"))
                hitA16++;
            else
                missA16++;

    }

    /**
     *
     * O arquivo eh lido linha a linha atraves do metodo 'readLine()' da classe
     * BufferedReader, onde cada linha eh armazenada na variavel 'line'
     *
     * Para cada linha lida, o metodo 'add(String)' da classe MapeamentoAsso retorna
     * 'hit' ou 'miss'
     *
     * Caso retorne 'hit', a variavel 'hitA32' eh incrementada
     *
     * Caso retorne 'miss', a variavel 'missA32' eh incrementada
     *
     *
     *
     * @method add()
     * @method readLine()
     * @throws Exception se houver algum erro durante a leitura do arquivo
     */

    private void leAssociativoAdresses32() throws Exception {
        bf = new BufferedReader(new FileReader(new File("ArquivosNecessarios/AdressesBin.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapA32.add32(line).equals("hit"))
                hitA32++;
            else
                missA32++;
    }

    /**
     *
     * O arquivo eh lido linha a linha atraves do metodo 'readLine()' da classe
     * BufferedReader, onde cada linha eh armazenada na variavel 'line'
     *
     * Para cada linha lida, o metodo 'add(String)' da classe MapeamentoDir retorna
     * 'hit' ou 'miss'
     *
     * Caso retorne 'hit', a variavel 'hitD16' eh incrementada
     *
     * Caso retorne 'miss', a variavel 'missD16' eh incrementada
     *
     *
     *
     * @method add()
     * @method readLine()
     * @throws Exception se houver algum erro durante a leitura do arquivo
     */

    private void leDiretoAdresses16() throws Exception{
        bf = new BufferedReader(new FileReader(new File("ArquivosNecessarios/AdressesBin.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapD16.add16(line).equals("hit"))
                hitD16++;
            else
                missD16++;
    }

    /**
     *
     * O arquivo eh lido linha a linha atraves do metodo 'readLine()' da classe
     * BufferedReader, onde cada linha eh armazenada na variavel 'line'
     *
     * Para cada linha lida, o metodo 'add(String)' da classe MapeamentoDir retorna
     * 'hit' ou 'miss'
     *
     * Caso retorne 'hit', a variavel 'hitD32' eh incrementada
     *
     * Caso retorne 'miss', a variavel 'missD32' eh incrementada
     *
     *
     *
     * @method add()
     * @method readLine()
     * @throws Exception se houver algum erro durante a leitura do arquivo
     */

    private void leDiretoAdresses32() throws Exception {
        bf = new BufferedReader(new FileReader(new File("ArquivosNecessarios/AdressesBin.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapD32.add32(line).equals("hit"))
                hitD32++;
            else
                missD32++;
    }

    /**
     *
     * Inicializa uma matriz com tamanho '288' por '2', ou seja, 288 posicoes
     * com duas posicoes disponiveis ao lado de cada
     *
     * Inicializa um inteiro que sera usado como indice para percorrer a matriz
     * verticalmente
     *
     * O arquivo eh lido linha a linha atraves do metodo 'readLine()' da classe
     * BufferedReader, onde cada linha eh armazenada na variavel 'line'
     *
     * Para cada linha lida, a linha eh adicionada a matriz na posicao 'binHex[index][0]'
     *
     * O index eh incrementado para continuar percorrendo a matriz
     *
     * Chama o metodo 'leAdressesHexa()'
     *
     *
     * @method leAdressesHexa()
     * @throws Exception caso ocorra algum erro na leitura do arquivo
     */

    private void leAdressesBin()throws Exception{
        binHexa = new String[288][2];
        bf = new BufferedReader(new FileReader(new File("ArquivosNecessarios/AdressesBin.txt")));
        int index = 0;

        for (String line = bf.readLine(); line != null; line = bf.readLine()) {
            binHexa[index][0] = line;
            index++;
        }

        leAdressesHexa();

    }

    /**
     *
     * Inicializa um inteiro que sera usado como indice para percorrer a matriz
     * verticalmente
     *
     * O arquivo eh lido linha a linha atraves do metodo 'readLine()' da classe
     * BufferedReader, onde cada linha eh armazenada na variavel 'line'
     *
     * Para cada linha lida, a linha eh adicionada a matriz na posicao 'binHex[index][1]'
     *
     * O index eh incrementado para continuar percorrendo a matriz
     *
     *
     *
     * @throws Exception
     */

    private void leAdressesHexa()throws Exception{
        bf = new BufferedReader(new FileReader(new File("ArquivosNecessarios/AdressesHexa")));
        int index = 0;

        for (String line = bf.readLine(); line != null; line = bf.readLine()){
            binHexa[index][1] = "   " + line;;
            index++;
        }

    }

    /**
     *
     * Inicializar um dicionario com a classe HashMap
     *
     * Percorre as posicoes da matriz e armazena no dicionario as quatorze
     * primeiras posicoes de 'binHexa[index][0]' e 'binHexa[index][1]', dessa forma
     * a chave do nosso dicionario sera a tag (caso seja associativo) ou a concatencao
     * da tag com a linha (caso seja direto) e o valor associado a chave sera o numero
     * em hexadecimal
     *
     *
     *
     */

    private void guardaEnderecosOriginais16(){
        enderecoPosMemoria16 = new HashMap<>();

        for (int i = 0; i < binHexa.length;i++)
            enderecoPosMemoria16.put(binHexa[i][0].substring(0,14), binHexa[i][1]);
    }

    /**
     *
     * Inicializar um dicionario com a classe HashMap
     *
     * Percorre as posicoes da matriz e armazena no dicionario as quinze primeiras
     * posicoes de 'binHexa[index][0]' e 'binHexa[index][1]', dessa forma a chave
     * do nosso dicionario sera a tag (caso seja associativo) ou a concatencao da tag
     * com a linha (caso seja direto) e o valor associado a chave sera o numero em hexadecimal
     *
     *
     *
     */

    private void guardaEnderecosOriginais32(){
        enderecoPosMemoria32 = new HashMap<>();

        for (int i = 0; i < binHexa.length;i++)
            enderecoPosMemoria32.put(binHexa[i][0].substring(0,15), binHexa[i][1]);
    }

    /**
     *
     * Retorna um dicionario com os valores armazenados na variavel 'enderecoPosMemoria16'
     *
     *
     * @return HashMap<String,String>
     */

    public HashMap<String, String> getEnderecoPosMemoria16(){
        return enderecoPosMemoria16;
    }

    /**
     *
     * Retorna um dicionario com os valores armazenados na variavel 'enderecoPosMemoria32'
     *
     *
     * @return HashMap<String,String>
     */

    public HashMap<String, String> getEnderecoPosMemoria32(){
        return enderecoPosMemoria32;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'hitA16'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getHitA16() {
        return hitA16;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'missA16'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getMissA16() {
        return missA16;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'hitA32'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getHitA32() {
        return hitA32;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'missA32'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getMissA32() {
        return missA32;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'hitD16'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getHitD16() {
        return hitD16;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'missD16'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getMissD16() {
        return missD16;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'hitD32'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getHitD32() {
        return hitD32;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'missD32'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    Integer getMissD32() {
        return missD32;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheAsso16'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    CacheAsso getCacheAsso16() {
        return mapA16.getCache();
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheAsso32'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    CacheAsso getCacheAsso32() {
        return mapA32.getCache();
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheDir16'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    CacheDir getCacheDir16() {
        return mapD16.getCache();
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cacheDir32'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     * @return Integer
     */

    CacheDir getCacheDir32() {
        return mapD32.getCache();
    }

    /**
     *
     * Retorna uma matriz com os valores armazenados na variavel 'binHexa'
     *
     * Metodo visivel somente no pacote 'Leitura_Impressao_Arquivo'
     *
     *
     *
     * @return String[][]
     */

    String[][] getBinHexa(){
        return binHexa;
    }
}
