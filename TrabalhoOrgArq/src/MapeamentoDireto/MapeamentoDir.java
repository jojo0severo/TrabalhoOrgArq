package MapeamentoDireto;


import java.util.ArrayList;

public class MapeamentoDir {
    private CacheDir cache;
    private ArrayList<String> hitsMisses;

    public MapeamentoDir(int tipoCache) {
        hitsMisses = new ArrayList<>();

        if (tipoCache == 16)
            cache = new CacheDir(16);

        else if (tipoCache == 32)
            cache = new CacheDir(32);
    }

    /**
     * Inicializa uma variavel 'tag' que recebe o valor de 'endereco' da posicao '0' ate a '10', ou
     * seja, recorta as 10 primeiras posicoes da variavel 'endereco' e para a variavel 'tag'
     * <p>
     * Inicializa uma variavel 'linha' com as posicoes de '10' ate '14' da variavel 'endereco'
     * <p>
     * Se o metodo 'add(String, String)' da classe CacheDir retornar true
     * <p>
     * Retorna 'hit'
     * <p>
     * Se nao, retorna 'miss'
     *
     * @param endereco tamanho maximo de 16
     * @return String
     * @method add()
     */

    public String add16(String endereco) {
        String tag = endereco.substring(0, 10);
        String linha = endereco.substring(10, 14);

        boolean retorno = cache.add(tag, linha);

        if (retorno) {
            hitsMisses.add("hit   " + endereco);
            return "hit";
        }

        else {
            hitsMisses.add("miss  " + endereco);
            return "miss";
        }

    }

    /**
     * Inicializa uma variavel 'tag' que recebe o valor de 'endereco' da posicao '0' ate a '10', ou
     * seja, recorta as 10 primeiras posicoes da variavel 'endereco' e para a variavel 'tag'
     * <p>
     * Inicializa uma variavel 'linha' com as posicoes de '10' ate '15' da variavel 'endereco'
     * <p>
     * Se o metodo 'add(String, String)' da classe CacheDir retornar true
     * <p>
     * Retorna 'hit'
     * <p>
     * Se nao, retorna 'miss'
     *
     * @param endereco tamanho maximo de 16
     * @return String
     * @method add()
     */

    public String add32(String endereco) {
        String tag = endereco.substring(0, 10);
        String linha = endereco.substring(10, 15);

        boolean retorno = cache.add(tag, linha);

        if (retorno) {
            hitsMisses.add("hit  " + endereco);
            return "hit";
        }

        else {
            hitsMisses.add("miss  " + endereco);
            return "miss";
        }
    }

    /**
     * Retorna o valor armazenado na variavel 'cache'
     *
     * @return CacheDir
     */

    public CacheDir getCache() {
        return cache;
    }

    public ArrayList<String> getHitsMisses(){
        return hitsMisses;
    }
}
