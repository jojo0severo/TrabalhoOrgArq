package MapeamentoDireto;

/**
 *
 * Classe que simula um cache com mapeamento direto
 *
 * A variavel 'linhas' representa as posicoes das linhas na cache
 *
 *
 *
 */
public class CacheDir {
    private Linha[] linhas;
    private Integer posLinha;

    /**
     *
     * So pode ser "vista" no pacote 'MapeamentoDireto'
     *
     * Construtor onde considera a configuracao da cache passada
     *
     * Se for uma cache de 16 linhas, inicializa uma Linha passando o valor 16
     *
     * Se for uma cache de 32 linhas, inicializa uma Linha passando o valor 32
     *
     * A variavel 'posLinha' eh sempre iniciada com '0'
     *
     * @param tipoCache somente 16 ou 32
     */

    CacheDir(Integer tipoCache){

        if (tipoCache==16) {
            linhas = new Linha[16];
            settaTipoCacheLinhas16();
        }
        else if(tipoCache==32) {
            linhas = new Linha[32];
            settaTipoCacheLinhas32();
        }

        posLinha = 0;
    }

    /**
     *
     * Esse metodo so pode ser utilizado pelas classes no pacote 'MapeamentoDireto'
     *
     * Inicializa um vetor de inteiros com o retorno do metodo 'achaLinha(String)', o qual ira
     * retornar um vetor de inteiros caso achar a linha, ou nulo se nao achar
     *
     * Se metodo 'achaLinha(String)' nao retornou nulo
     *      Se o vetor de inteiros na posicao 'aux[0]' for igual a um
     *             Se o metodo 'achaTag(Int, String)' retornar verdadeiro
     *
     * Retorna true e acaba o metodo
     *
     *              Se nao o valor na posicao 'linhas[Int]' recebe o valor da variavel 'tag'
     *              que foi buscada
     *
     * Retorna false e acaba o metodo
     *
     *
     * Se o metodo 'achaLinha(String)' retornar nulo
     *
     * Ha uma verificacao para saber se chegou a ultima linha do vetor de Linha 'linhas'
     *
     * Se chegou no fim, ou seja, o indice (a variavel 'posLinha') for igual ao
     * tamanho do vetor 'linhas'
     *
     * A variavel 'posLinha' recebe o valor '0'
     *
     * Se nao chegou no fim o vetor 'linhas' na posicao 'linhas[posLinha]' utiliza
     * o metodo add(String, String) da classe Linha
     *
     * A variável 'posLinha' eh incrementada
     *
     * Retorna false e acaba o metodo
     *
     *
     *
     *
     * @param tag tamanho sempre 10
     * @param linha tamanho minho = 4, tamanho maximo = 5
     * @method achaLinha()
     * @method achaTag()
     * @method setTag()
     * @return boolean
     */

    boolean add(String tag, String linha){
        Integer[] aux = achaLinha(linha);

        if (aux!=null)
            if (aux[0]==1)
                if (achaTag(aux[1], tag))
                    return true;
                else
                    return linhas[aux[1]].setTag(tag);



        if (posLinha==linhas.length)
            posLinha = 0;

        linhas[posLinha].add(tag, linha);

        posLinha++;


        return false;
    }

    /**
     *
     * Inicializa objetos do tipo Linha em todas as posicoes do vetor 'linhas'
     * com a configuracao de cache com 16 linhas
     *
     *
     */

    private void settaTipoCacheLinhas16(){
        for (int i = 0; i < linhas.length; i++)
            linhas[i] = new Linha(16);
    }

    /**
     *
     * Inicializa objetos do tipo Linha em todas as posicoes do vetor 'linhas'
     * com a configuracao de cache com 32 linhas
     *
     *
     */

    private void settaTipoCacheLinhas32(){
        for (int i = 0; i < linhas.length; i++)
            linhas[i] = new Linha(32);

    }


    /**
     *
     * Inicializa um vetor de inteiros com duas posicoes
     *
     * Cria um loop percorrendo todas as posicoes de 'linhas[index]'
     *
     * Caso seja nulo o valor armazenado na linha da posicao 'linhas[index]',
     * significa que nao ha mais nenhum valor a ser verificado (so ocorre
     * no primeiro ciclo de cache)
     *
     * Retorna null e acaba o metodo
     *
     * Caso o valor armazenado na linha da posicao 'linhas[index]' seja igual
     * ao valor armazenado na variavel 'linha'
     *
     * Adiciona 1 na posicao 'aux[0]' do vetor de inteiros
     *
     * Adiciona o index que foi encontrada a tag da posicao 'aux[1]' do
     * vetor de inteiros
     *
     * Retorna o vetor de inteiros e acaba o metodo
     *
     * Caso nao tenha acontecido nenhum dos casos
     *
     * Retorna false e acaba o metodo
     *
     *
     *
     * @param linha tamanho maximo de 5 e minimo de 4
     * @return Integer[]
     */

    private Integer[] achaLinha(String linha){
        Integer[] aux = new Integer[2];
        for (int i = 0; i < linhas.length; i++)
            if (linhas[i].getLinha()==null)
                return null;

            else if (linhas[i].getLinha().equals(linha)){
                aux[0] = 1;
                aux[1] = i;
                return aux;
            }

        return null;
    }

    /**
     *
     * Se o valor armazenado na tag da posicao 'linha[pos]' seja igual
     * ao valor armazenado na variavel 'tag'
     *
     * Retorna true e acaba o metodo
     *
     * Se o valor armazenado na tag da posicao 'linha[posicao]' seja nulo
     *
     * Retorna false e acaba o metodo
     *
     * Caso nao tenha acontecido nenhum dos casos
     *
     * Retorna false e acaba o metodo
     *
     *
     * @param tag tamanho maximo 2 e minimo 1
     * @param pos entre 0 e 15 ou entre 0 31
     * @return boolean
     */

    private boolean achaTag(Integer pos, String tag){
        return linhas[pos].getTag().equals(tag);

    }

    /**
     *
     * Inicializa uma String, a variavel 'cache' simula a prorpia cache
     * com a posicao de memoria
     *
     * Inicializa um inteiro que simula as posicoes de memoria da cache
     *
     * Cria um loop percorrendo cada objeto do tipo Linha[] da variavel 'linhas'
     *
     * Se o tamanho da variavel 'cache' for igual a um
     *
     * A variavel 'cache' recebe ela mesma, mais uma String que eh somente um '\n',
     * mais mais '0x' e o valor em hexadecimal da variavel 'index' (simulando uma
     * posicao de memoria no vetor), mais uma String que eh compreendida por cinco tabs,
     * tres iguais, um sinal de maior e dois tabs e mais o objeto na posicao 'linhas[pos]'
     * (utilizando o metodo 'toString()' do objeto para conseguir o resultado desejado)
     *
     * Se nao a variavel 'cache' recebe ela mesma, mais uma String que eh somente um '\n',
     * mais mais '0x' e o valor em hexadecimal da variavel 'index' (simulando uma
     * posicao de memoria no vetor), mais uma String que eh compreendida por quatro tabs,
     * tres iguais, um sinal de maior e dois tabs e mais o objeto na posicao 'linhas[pos]'
     * (utilizando o metodo 'toString()' do objeto para conseguir o resultado desejado)
     *
     * A varivavel 'index' eh incrementada
     *
     * Retorna o valor da variavel 'cache' e acaba o metodo
     *
     *
     *
     * @method toHexString()
     * @method toString()
     * @return String
     */

    public String toString(){
        String cache = "";
        int index = 0;

        for (int i = 0; i < linhas.length-1; i++) {
            if (Integer.toHexString(index).length()==1)
                cache = cache +  "\n" + "0x" + Integer.toHexString(index) +  "\t\t\t\t\t===>\t\t" +linhas[i].toString();
            else
                cache = cache +  "\n" + "0x" + Integer.toHexString(index) +  "\t\t\t\t===>\t\t" +linhas[i].toString();
            index++;
        }

        return cache;
    }

    /**
     *
     * Inicializa uma String, a variavel 'cache' simula a prorpia cache
     * com a posicao de memoria
     *
     * Inicializa um inteiro que simula as posicoes de memoria da cache
     *
     * Cria um loop percorrendo cada objeto do tipo Linha[] da variavel 'linhas'
     *
     * Se o tamanho da variavel 'cache' for igual a um
     *
     * A variavel 'cache' recebe ela mesma, mais uma String que eh somente um '\n',
     * mais mais '0x' e o valor em hexadecimal da variavel 'index' (simulando uma
     * posicao de memoria no vetor), mais uma String que eh compreendida por cinco tabs,
     * tres iguais, um sinal de maior e dois tabs e mais o objeto na posicao 'linhas[pos]'
     * (utilizando o metodo 'toString()' do objeto para conseguir o resultado desejado)
     *
     * Se nao a variavel 'cache' recebe ela mesma, mais uma String que eh somente um '\n',
     * mais mais '0x' e o valor em hexadecimal da variavel 'index' (simulando uma
     * posicao de memoria no vetor), mais uma String que eh compreendida por quatro tabs,
     * tres iguais, um sinal de maior e dois tabs e mais o objeto na posicao 'linhas[pos]'
     * (utilizando o metodo 'toStringTxt()' do objeto para conseguir o resultado desejado)
     *
     * A varivavel 'index' eh incrementada
     *
     * Retorna o valor da variavel 'cache' e acaba o metodo
     *
     *
     *
     * @method toHexString()
     * @method toStringTxt()
     * @return String
     */

    public String toStringTxt(){
        String cache = "";
        int index = 0;

        for (int i = 0; i < linhas.length-1; i++) {
            if (Integer.toHexString(index).length()==1)
                cache = cache +  "\n" + "0x" + Integer.toHexString(index) +  "\t\t\t\t\t===>\t\t" +linhas[i].toStringTxt();
            else
                cache = cache +  "\n" + "0x" + Integer.toHexString(index) +  "\t\t\t\t===>\t\t" +linhas[i].toStringTxt();
            index++;
        }

        return cache;
    }

}
