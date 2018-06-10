package MapeamentoDireto;

public class MapeamentoDir {
    private CacheDir cache;

    public MapeamentoDir(CacheDir cache){
        this.cache = cache;
    }

    public String add16(String endereco){
        String tag = endereco.substring(0,10);
        String linha = endereco.substring(10, 14);

        if (cache.add(tag,linha))
            return "hit";

        else
            return "miss";

    }
    public String add32(String endereco){
        String tag = endereco.substring(0,10);
        String linha = endereco.substring(10, 15);

        if (cache.add(tag,linha))
            return "hit";

        else
            return "miss";
    }
}
