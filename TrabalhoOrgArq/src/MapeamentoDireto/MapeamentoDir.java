package MapeamentoDireto;

public class MapeamentoDir {
    private CacheDir cache;

    public MapeamentoDir(int tipoCache){
        if (tipoCache == 16)
            cache = new CacheDir(16);

        else if (tipoCache == 32)
            cache = new CacheDir(32);
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

    public CacheDir getCache(){
        return cache;
    }
}
