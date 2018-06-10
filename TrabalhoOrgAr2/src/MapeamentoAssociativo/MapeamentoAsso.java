package MapeamentoAssociativo;

public class MapeamentoAsso {
    private CacheAsso cache;

    public MapeamentoAsso(CacheAsso cache){
        this.cache = cache;
    }

    public String add16(String endereco){
        String tag = endereco.substring(0, 14);
        String palavra = endereco.substring(14);

        if (cache.add(tag,palavra))
            return "hit";
        else
            return "miss";
    }

    public String add32(String endereco){
        String tag = endereco.substring(0, 15);
        String palavra = endereco.substring(15);

        if (cache.add(tag,palavra))
            return "hit";

        else
            return "miss";
    }
}
