package MapeamentoDireto;

public class Linha {
    private String[] tag;
    private String[] linha;
    private String[] palavra;
    private int tipoCache;

    Linha(int tipoCache){
        this.tipoCache = tipoCache;
        tag = new String[1];
        linha = new String[1];

        if (tipoCache == 16)
            palavra = new String[4];

        else if (tipoCache == 32)
            palavra = new String[2];

    }

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

    private String calculaBin(String palavra){
        Integer aux = Integer.parseInt(palavra);
        String auxPalavra = Integer.toBinaryString(aux+1);

        if (auxPalavra.length()==1 && tipoCache==16)
            auxPalavra = "0"+ auxPalavra;

        return auxPalavra;
    }

    String getTag(){
        return tag[0];
    }

    String getLinha (){
        return linha[0];
    }

    boolean setTag(String tag){
        this.tag[0] = tag;
        return false;
    }

    @Override
    public String toString(){
        String palavras = "";
        for (String aPalavra : palavra)
            palavras = palavras + " | " + aPalavra;

        return linha[0] + "  | " + tag[0] + " " + palavras;
    }
}
