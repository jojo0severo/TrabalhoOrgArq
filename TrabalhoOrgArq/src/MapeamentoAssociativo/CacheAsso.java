package MapeamentoAssociativo;

/**
 *
 * Classe que simula uma memoria associativa e uma cache
 *
 * A variavel 'linha' representa nas posicoes 'linha[index][0]' a tag na memoria associativa
 *
 * Enquanto as outras posicoes 'linha[index][index>0]' guardam as palavras na cache
 *
 *
 */

public class CacheAsso {
    private String[][] linha;
    private Integer posLinha;
    private int tipoCache;

    /**
     *
     * So pode ser "vista" no pacote 'MapeamentoAssociativo'
     *
     * Se a configuracao da cache for de 16 linhas, o limite de 'linha[]' eh dezesseis
     * E o limmite de 'linha[][]' eh cinco
     *
     * Caso a configuracao da cache for de 32 linhas, o limite de 'linha[]' eh trinta e dois
     * E o limite de 'linha[][]' eh tres
     *
     * A variavel 'posLinha' eh sempre iniciada com '0'
     *
     *
     *
     * @param tipoCache somente 16 ou 32
     */

    CacheAsso(int tipoCache){
        this.tipoCache = tipoCache;
        if (tipoCache==16)
            linha = new String[16][5];

        else if(tipoCache==32)
            linha = new String[32][3];

        posLinha = 0;
    }

    /**
     *
     * Esse metodo so pode ser utilizado pelas classes no pacote 'MapeamentoAssociativo'
     *
     * Inicializa um vetor de inteiros com o retorno do metodo 'achaTag(String)', o qual ira
     * retornar um vetor de inteiros caso achar a tag, ou nulo se nao achar
     *
     * Inicializa duas variaveis inteiro
     *
     * Se metodo 'achaTag(String)' nao retornou nulo
     *      A variavel 'booleano' recebe o valor armazenado na posicao '0' do vetor de inteiros
     *      A variavel 'posicao' recebe o valor armazenado na posicao '1' do vetor de inteiros
     *
     * Se a variavel 'booleano' tiver o valor '1' armazenado, o metodo 'achaPalavra(String, Integer)'
     * eh chamada, se retornar true significa qeu achou a palavra na posicao indicada
     *
     * Retorna true e acaba o metodo
     *
     *
     * Se o metodo 'achaTag(String)' retornou um valor nulo
     *
     * Verifica-se se ja esta sendo preenchida a ultima posicao da nossa matriz 'linha'
     *
     * Se estiver, voltamos para o inicio, ou seja, a variavel que aponta onde devemos adicionar
     * uma nova linha eh alterada para '0'
     *
     * Se nao estiver inicializamos uma variavel do tipo String
     *
     * Se a configuracao da cache for de 16 linhas, a variavel recebe '00'
     *
     * Se a configuracao da cache for de 32 linhas, a variavel recebe '0'
     *
     * Essa variavel simula o comeco das palavras de cada tag, ou seja, a primeira posicao do
     * bloco: '00 01 10 11'
     *
     * A matriz 'linha[posLinha][0]' recebe o valor armazenado na variavel 'tag'
     *
     * Um loop eh montado para preencher as outras posicoes com o bloco de palavras
     *
     * Cada ciclo do loop o metodo 'calculaBin(String)' eh chamado para mostrar a proxima
     * palavra a ser inserida no bloco
     *
     * Uma verificacao eh necessaria devido a um erro de interpretacao da linguagem
     *
     * Quando eh calculada a posicao seguinte a '10' o metodo interpreta como um decimal, devido
     * a isso, a palavra '11' eh inserida manualmente
     *
     * A variavel 'posLinha' eh incrementada
     *
     * Retorna false e acaba o metodo
     *
     *
     *
     * @param tag tamanho maximo de 15 e minimo de 14
     * @param palavra se tamanho da tag for 15, tamanho = 1, se tamanho da tag for 14, tamamnho =2
     * @method achaTag()
     * @method achaPalavra()
     * @method calculaBin()
     * @return boolean
     */

    boolean add(String tag, String palavra){
        Integer[] aux = achaTag(tag);
        int booleano = 0;
        int posicao = 0;

        if (aux!=null) {
            booleano = aux[0];
            posicao = aux[1];
        }

        if (booleano==1)
            if (achaPalavra(palavra, posicao))
                return true;

        if (posLinha==linha.length)
            posLinha = 0;

        String palavraAux = "";

        if (tipoCache==16)
            palavraAux = "00";

        else if (tipoCache == 32)
            palavraAux = "0";

        linha[posLinha][0] = tag;
        for (int i = 1; i < linha[0].length; i++) {
            if (palavraAux.equals("1011"))
                palavraAux = "11";
            linha[posLinha][i] = palavraAux;
            palavraAux = calculaBin(palavraAux);
        }

        posLinha++;

        return false;

    }

    /**
     *
     * Inicializa um vetor de inteiros com duas posicoes
     *
     * Cria um loop percorrendo todas as posicoes de 'linha[index][0]'
     *
     * Caso seja nulo o valor armazenado na posicao 'linha[index][0]',
     * significa que nao ha mais nenhum valor a ser verificado (so ocorre
     * no primeiro ciclo de cache)
     *
     * Retorna null e acaba o metodo
     *
     * Caso o valor armazenado na posicao 'linha[index][0]' seja igual
     * ao valor armazenado na variavel 'tag'
     *
     * Adiciona 1 na posicao 'aux[0]' do vetor de inteiros
     *
     * Adiciona o index que foi encontrada a tag na posicao 'aux[1]' do
     * vetor de inteiros
     *
     * Retorna o vetor de inteiros e acaba o metodo
     *
     * Caso nao tenha acontecido nenhum dos casos
     *
     * Retorna false e acaba o metodo
     *
     *
     * @param tag tamanho maximo de 15 e minimo de 14
     * @return Integer[]
     */

    private Integer[] achaTag(String tag){
        Integer[] aux = new Integer[2];
        for (int i = 0; i < linha.length;i++){
            if (linha[i][0] == null) {
                return null;
            }
            if (linha[i][0].equals(tag)) {
                aux[0] = 1;
                aux[1] = i;
                return aux;
            }
        }
        return null;
    }

    /**
     *
     * Cria um loop percorrendo todas as posicoes de 'linha[posicao][index]'
     *
     * Se o valor armazenado na posicao 'linha[posicao][index]' seja igual
     * ao valor armazenado na variavel 'palavra'
     *
     * Retorna true e acaba o metodo
     *
     * Se o valor armazenado na posicao 'linha[posicao][index]' seja nulo
     *
     * Retorna false e acaba o metodo
     *
     * Caso nao tenha acontecido nenhum dos casos
     *
     * Retorna false e acaba o metodo
     *
     *
     * @param palavra tamanho maximo 2 e minimo 1
     * @param posicao entre 0 e 15 ou entre 0 31
     * @return boolean
     */

    private boolean achaPalavra(String palavra, Integer posicao){
        for (int i = 0; i < linha[posicao].length;i++)
            if (linha[posicao][i].equals(palavra))
                return true;
            else if (linha[posicao][i]==null)
                return false;

        return false;

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
        String palavras = Integer.toBinaryString(aux+1);

        if (palavras.length()==1 && tipoCache==16)
            palavras = "0"+ palavras;

        return palavras;
    }

    /**
     *
     * Inicializa duas Strings, a variavel 'posMemoriaString' simula a propria cache
     * com a posicao de memoria, enquanto a variavel linhaString simula a linha da cache
     * sem a posicao de memoria
     *
     * Inicializa um inteiro que simula as posicoes de memoria da cache
     *
     * Cria um loop percorrendo cada objeto do tipo String[] da variavel 'linha'
     *
     * A variavel 'linhaString' recebe o objeto na posicao 'objeto[0]' mais
     * uma String que eh apenas um espaco
     *
     * Cria um loop aninhado (dentro de outro loop) percorrendo todos os valores
     * de 'linha[index]'
     *
     * A variavel 'linhaString' recebe ela mesma, mais uma String que eh apenas dois
     * espacos, um traco e mais dois espacos e mais o objeto do loop superior, ou seja,
     *
     *      linhaString = 000000000001
     *          linhaString = 000000000001 + "  |  " + 00
     *
     *      LinhaString = 000000000001
     *          linhaString = 000000000001 | 00 + "  |   " + 01
     *
     *      LinhaString = 000000000001
     *          linhaString = 000000000001 | 00 | 01 + "  |   " + 10
     *
     *  E assim em diante...
     *
     * (Exemplo montado considerando uma cache de 16 linhas)
     *
     * A variavel 'linhaString' recebe ela mesma mais '\n'
     *
     * Se o tamanho da variavel 'posMemoriaString' for igual a um
     *
     * A variavel 'posMemoriaString' recebe ela mesma, mais '0x' e o valor em hexadecimal da variavel 'index'
     * (simulando uma posicao de memoria no vetor), mais uma String que eh compreendida por cinco tabs, tres
     * iguais, um sinal de maior e dois tabs e mais a variavel 'linhaString'
     *
     *
     * Se nao 'posMemoriaString' recebe ela mesma, mais '0x' e o valor em hexadecimal da variavel 'index'
     * (simulando uma posicao de memoria no vetor), mais uma String que eh compreendida por quatro tabs, tres
     * iguais, um sinal de maior e dois tabs e mais a variavel 'linhaString'
     *
     * Retorna o valor da variavel 'posMemoriaString' e acaba o metodo
     *
     *
     *
     * @method toHexString()
     * @return String
     */

    public String toString(){
        String linhaString;
        String posMemoriaString = "";

        int index = 0;

        for (String[] aLinha : linha) {
            linhaString = aLinha[0] + " ";

            for (int j = 1; j < linha[0].length; j++)
                linhaString = linhaString + "  |  " + aLinha[j];

            linhaString = linhaString + "\n";

            if (Integer.toHexString(index).length() == 1)
                posMemoriaString = posMemoriaString + "0x" + Integer.toHexString(index) + "\t\t\t\t\t===>\t\t" + linhaString;
            else
                posMemoriaString = posMemoriaString + "0x" + Integer.toHexString(index) + "\t\t\t\t===>\t\t" + linhaString;

            index++;
        }


        return  posMemoriaString;
    }

    /**
     *
     * Inicializa duas Strings, a variavel 'posMemoriaString' simula a linha da cache
     * com a posicao de memoria, enquanto a variavel linhaString simula a linha da cache
     * sem a posicao de memoria
     *
     * Inicializa um inteiro que simula as posicoes de memoria da cache
     *
     * Cria um loop percorrendo cada objeto do tipo String[] da variavel 'linha'
     *
     * A variavel 'linhaString' recebe o objeto na posicao 'objeto[0]' mais
     * uma String que eh apenas um espaco
     *
     * Cria um loop aninhado (dentro de outro loop) percorrendo todos os valores
     * de 'linha[index]'
     *
     * A variavel 'linhaString' recebe ela mesma, mais uma String que eh apenas dois
     * espacos, um traco e mais dois espacos, mais o objeto do loop anterior na posicao 'objeto[0]'
     * (local onde foi armazenada a tag) e mais o objeto do loop superior, ou seja,
     *
     *      linhaString = 000000000001
     *          linhaString = 000000000001 + "  |  " + 000000000001 + 00
     *
     *      LinhaString = 000000000001
     *          linhaString = 000000000001 | 00000000000100 + "  |   " + 000000000001 + 01
     *
     *      LinhaString = 000000000001
     *          linhaString = 000000000001 | 00000000000100 | 00000000000101 + "  |   " + 000000000001 + 10
     *
     *  E assim em diante...
     *
     * (Exemplo montado considerando uma cache de 16 linhas)
     *
     * A variavel 'linhaString' recebe ela mesma mais '\n'
     *
     * Se o tamanho da variavel 'posMemoriaString' for igual a um
     *
     * A variavel 'posMemoriaString' recebe ela mesma, mais '0x' e o valor em hexadecimal da variavel 'index'
     * (simulando uma posicao de memoria no vetor), mais uma String que eh compreendida por cinco tabs, tres
     * iguais, um sinal de maior e dois tabs e mais a variavel 'linhaString'
     *
     *
     * Se nao 'posMemoriaString' recebe ela mesma, mais '0x' e o valor em hexadecimal da variavel 'index'
     * (simulando uma posicao de memoria no vetor), mais uma String que eh compreendida por quatro tabs, tres
     * iguais, um sinal de maior e dois tabs e mais a variavel 'linhaString'
     *
     * Retorna o valor da variavel 'posMemoriaString' e acaba o metodo
     *
     *
     *
     * @method toHexString()
     * @return String
     */

    public String toStringTxt(){
        String linhaString;
        String posMemoriaString = "";

        int index = 0;

        for (String[] aLinha : linha) {
            linhaString = aLinha[0] + " ";

            for (int j = 1; j < linha[0].length; j++)
                linhaString = linhaString + "  |  " + aLinha[0] + aLinha[j];

            linhaString = linhaString + "\n";

            if (Integer.toHexString(index).length() == 1)
                posMemoriaString = posMemoriaString + "0x" + Integer.toHexString(index) + "\t\t\t\t\t===>\t\t" + linhaString;
            else
                posMemoriaString = posMemoriaString + "0x" + Integer.toHexString(index) + "\t\t\t\t===>\t\t" + linhaString;

            index++;
        }


        return  posMemoriaString;
    }

}
