package MapeamentoAssociativo;

/**
 *
 * Classe para facilitar a criacao das caches assim como
 * a insercao e captura dos hits e misses
 *
 *
 *
 */

public class MapeamentoAsso {
    private CacheAsso cache;

    /**
     *
     * Construtor onde considera a configuracao da cache passada
     *
     * Se for uma cache de 16 linhas, inicializa uma cache passando o valor 16
     *
     * Se for uma cache de 32 linhas, inicializa uma cache passando o valor 32
     *
     *
     *
     * @param tipoCache somente 16 ou 32
     */

    public MapeamentoAsso(int tipoCache){
        if (tipoCache == 16)
            cache = new CacheAsso(16);

        else if (tipoCache == 32)
            cache = new CacheAsso(32);
    }

    /**
     *
     * Inicializa uma variavel 'tag' que recebe o valor de 'endereco' da posicao '0' ate a '14', ou
     * seja, recorta as 14 primeiras posicoes da variavel 'endereco' e para a variavel 'tag'
     *
     * Inicializa uma variavel 'palavra' com as ultimas duas posicoes da variavel 'endereco'
     *
     * Se o metodo 'add(String, String)' da classe CacheAsso retornar true
     *
     * Retorna 'hit'
     *
     * Se nao, retorna 'miss'
     *
     *
     *
     * @param endereco tamanho maximo de 16
     * @method add()
     * @return String
     */

    public String add16(String endereco){
        String tag = endereco.substring(0, 14);
        String palavra = endereco.substring(14);

        if (cache.add(tag,palavra))
            return "hit";
        else
            return "miss";
    }

    /**
     *
     * Inicializa uma variavel 'tag' que recebe o valor de 'endereco' da posicao '0' ate a '15', ou
     * seja, recorta as 15 primeiras posicoes da variavel 'endereco' e para a variavel 'tag'
     *
     * Inicializa uma variavel 'palavra' com a ultima posicao da variavel 'endereco'
     *
     * Se o metodo 'add(String, String)' da classe CacheAsso retornar verdadeiro
     *
     * Retorna 'hit'
     *
     * Se nao, retorna 'miss'
     *
     *
     *
     * @param endereco tamanho maximo de 16
     * @method add()
     * @return String
     */

    public String add32(String endereco){
        String tag = endereco.substring(0, 15);
        String palavra = endereco.substring(15);

        if (cache.add(tag,palavra))
            return "hit";

        else
            return "miss";
    }

    /**
     *
     * Retorna o valor armazenado na variavel 'cache'
     *
     *
     *
     * @return CacheAsso
     */

    public CacheAsso getCache(){
        return cache;
    }
}
