package MapeamentoDireto;


public class MapeamentoDir {
    private CacheDir cache;

    public MapeamentoDir(int tipoCache){
        if (tipoCache == 16)
            cache = new CacheDir(16);

        else if (tipoCache == 32)
            cache = new CacheDir(32);
    }

    /**
     *
     * Inicializa uma variavel 'tag' que recebe o valor de 'endereco' da posicao '0' ate a '10', ou
     * seja, recorta as 10 primeiras posicoes da variavel 'endereco' e para a variavel 'tag'
     *
     * Inicializa uma variavel 'linha' com as posicoes de '10' ate '14' da variavel 'endereco'
     *
     * Se o metodo 'add(String, String)' da classe CacheDir retornar true
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
        String tag = endereco.substring(0,10);
        String linha = endereco.substring(10, 14);

        if (cache.add(tag,linha))
            return "hit";

        else
            return "miss";

    }

    /**
     *
     * Inicializa uma variavel 'tag' que recebe o valor de 'endereco' da posicao '0' ate a '10', ou
     * seja, recorta as 10 primeiras posicoes da variavel 'endereco' e para a variavel 'tag'
     *
     * Inicializa uma variavel 'linha' com as posicoes de '10' ate '15' da variavel 'endereco'
     *
     * Se o metodo 'add(String, String)' da classe CacheDir retornar true
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
        String tag = endereco.substring(0,10);
        String linha = endereco.substring(10, 15);

        if (cache.add(tag,linha))
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
     * @return CacheDir
     */

    public CacheDir getCache(){
        return cache;
    }
}
