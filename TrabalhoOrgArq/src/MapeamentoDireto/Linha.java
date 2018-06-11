package MapeamentoDireto;

/**
 *
 * Classe que simula cada linha separada da de uma cache com mapeamento direto
 *
 *
 */

public class Linha {
    private String[] tag;
    private String[] linha;
    private String[] palavra;
    private int tipoCache;

    /**
     *
     * So eh "vista" por classes no pacote 'MapeamentoDireto'
     *
     * Construtor onde considera a configuracao da cache passada
     *
     * Se for uma cache de 16 linhas, inicializa um vetor com 2 posicoes para o bloco de palavras
     *
     * Se for uma cache de 32 linhas, inicializa um vetor com 4 posicoes para o bloco de palavras
     *
     *
     *
     * @param tipoCache somente 16 ou 32
     */

    Linha(int tipoCache){
        this.tipoCache = tipoCache;
        tag = new String[1];
        linha = new String[1];

        if (tipoCache == 16)
            palavra = new String[4];

        else if (tipoCache == 32)
            palavra = new String[2];

    }

    /**
     *
     * Esse metodo so pode ser utilizado pelas classes no pacote 'MapeamentoDireto'
     *
     * O valor do vetor 'tag' na posicao 'tag[0]' recebe o valor da variavel 'tag'
     * passada por parametro
     *
     * O valor do vetor 'linha' na posicao 'linha[0]' recebe o valor da variavel 'linha'
     * passada por parametro
     *
     * Inicializamos uma variavel do tipo String
     *
     * Se a configuracao da cache for de 16 linhas, a variavel recebe '00'
     *
     * Se a configuracao da cache for de 32 linhas, a variavel recebe '0'
     *
     * Essa variavel simula o comeco das palavras de cada tag, ou seja, a primeira posicao do
     * bloco: '00 01 10 11'
     *
     * Se o a configuracao da cache for de 16 linhas
     *
     * Um loop de 3 ciclos eh montado para preencher as outras posicoes com o bloco de palavras
     *
     * Cada ciclo do loop o metodo 'calculaBin(String)' eh chamado para mostrar a proxima
     * palavra a ser inserida no bloco
     *
     * Uma verificacao eh necessaria devido a um erro de interpretacao da linguagem
     *
     * Quando eh calculada a posicao seguinte a '10' o metodo interpreta como um decimal, devido
     * a isso, a palavra '11' eh inserida manualmente
     *
     * Se o a configuracao da cache for de 32 linhas
     *
     * Um loop de 2 ciclos eh montado para preencher as outras posicoes com o bloco de palavras
     *
     * Cada ciclo do loop o metodo 'calculaBin(String)' eh chamado para mostrar a proxima
     * palavra a ser inserida no bloco
     *
     *
     *
     * @param linha tamanho maximo de 5 e minimo de 4
     * @param tag tamanho sempre 10
     * @method calculaBin()
     */

    void add(String tag, String linha){
        this.tag[0] = tag;
        this.linha[0] = linha;

        String palavra = "";

        if (tipoCache == 16)
            palavra = "00";

        else if (tipoCache == 32)
            palavra = "0";

        if (tipoCache==16) {
            for (int i = 0; i < 3; i++) {
                this.palavra[i] = palavra;
                palavra = calculaBin(palavra);
            }
            this.palavra[3] = "11";
        }

        else if (tipoCache == 32)
            for (int i  = 0; i < 2; i++) {
                this.palavra[i] = palavra;
                palavra = calculaBin(palavra);
            }

    }

    /**
     *
     * Inicializa uma variavel 'aux' com o valor inteiro da variavel 'palavra', isto
     * eh possivel devido o metodo 'parseInt(String)'
     *
     * Inicializa uma variavel 'palavras' com o valor do em binario da variavel 'aux'
     * mais '1'
     *
     * Se o tamanho da variavel 'palavras' for igual a um e a configuracao da cache for
     * de dezesseis linhas
     *
     * A variavel 'palavras' recebe a String '0' mais a propria variavel 'palavras', dessa
     * forma evita que no bloco de palavras surja algo como: '0, 1 , 10 , 11'
     *
     * Retorna o valor da variavel 'palavras' e acaba o metodo
     *
     *
     *
     * @param palavra tamanho maximo 2 e minimo 1
     * @method toBinaryString()
     * @method parseInt()
     * @return String
     */

    private String calculaBin(String palavra){
        Integer aux = Integer.parseInt(palavra);
        String auxPalavra = Integer.toBinaryString(aux+1);

        if (auxPalavra.length()==1 && tipoCache==16)
            auxPalavra = "0"+ auxPalavra;

        return auxPalavra;
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'tag' na posicao 'tag[0]'
     *
     *
     * @return String
     */

    String getTag(){
        return tag[0];
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'linha' na posicao 'linha[0]'
     *
     *
     * @return String
     */

    String getLinha (){
        return linha[0];
    }

    /**
     *
     * O valor armazenado na variavel 'linha' na posicao 'linha[0]' recebe
     * o novo valor passado por parametro
     *
     * Retorna false;
     *
     *
     *
     * @param tag
     * @return boolean
     */

    boolean setTag(String tag){
        this.tag[0] = tag;
        return false;
    }

    /**
     *
     * Inicializa uma variavel do tipo String, 'palavras', que ira simular o
     * bloco de palavras
     *
     * Cria-se um loop percorrendo todos os objetos do tipo String armazenados no
     * vetor 'palavra'
     *
     * A cada ciclo a variavel 'palavras' eh concatenada com ela mesma, mais uma String
     * que eh apenas um espaco, um traco e um espaco e mais o objeto do vetor 'palavra',
     * ou seja, no caso de uma cache com 16 linhas
     *
     *      palavras = "" + " | " + 00
     *
     *      palavras = "| 00" + " | " + 01
     *
     *      palavras = "| 00 | 01" + " | " + 10
     *
     * E assim em diante
     *
     * Retonar a concatenacao da variavel 'linha' na posicao 'linha[0]', mais
     * uma String que eh apenas um espaco, um traco e um espaco variavel, mais
     * a variavel 'tag' na posicao 'tag[0]', mais uma String que eh apenas um
     * espaco e mais a variavel 'palavras'
     *
     *
     *
     * @return String
     */

    @Override
    public String toString(){
        String palavras = "";
        for (String aPalavra : palavra)
            palavras = palavras + " | " + aPalavra;

        if (tipoCache == 16)
            return linha[0] + "   | " + tag[0] + " " + palavras;

        return linha[0] + "  | " + tag[0] + " " + palavras;
    }

    /**
     *
     * Inicializa uma variavel do tipo String, 'palavras', que ira simular o
     * bloco de palavras
     *
     * Cria-se um loop percorrendo todos os objetos do tipo String armazenados no
     * vetor 'palavra'
     *
     * A cada ciclo a variavel 'palavras' eh concatenada com ela mesma, mais uma String
     * que eh apenas um espaco, um traco e um espaco, mais a variavel 'tag' na posicao
     * 'tag[0]' e mais o objeto do vetor 'palavra', ou seja, no caso de uma cache com
     * 16 linhas
     *
     *      palavras = "" + " | " + 000000000000
     *
     *      palavras = "| 000000000000" + " | " + 000000000001
     *
     *      palavras = "| 000000000000 | 000000000001" + " | " + 000000000010
     *
     * E assim em diante
     *
     * Retonar a concatenacao da variavel 'linha' na posicao 'linha[0]', mais
     * uma String que eh apenas um espaco, um traco e um espaco variavel, mais
     * a variavel 'tag' na posicao 'tag[0]', mais uma String que eh apenas um
     * espaco e mais a variavel 'palavras'
     *
     *
     *
     * @return String
     */

    String toStringTxt(){
        String palavras = "";
        for (String aPalavra : palavra)
            palavras = palavras + " | " + tag[0] + aPalavra;

        return linha[0] + "  | " + tag[0] + " " + palavras;
    }
}
