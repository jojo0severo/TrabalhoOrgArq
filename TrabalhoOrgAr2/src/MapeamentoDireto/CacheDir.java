package MapeamentoDireto;

public class CacheDir {
    private Linha[] linhas;
    private Integer posLinha;

    public CacheDir(Integer tipoCache){

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

    private void settaTipoCacheLinhas16(){
        for (int i = 0; i < linhas.length; i++)
            linhas[i] = new Linha(16);

    }

    private void settaTipoCacheLinhas32(){
        for (int i = 0; i < linhas.length; i++)
            linhas[i] = new Linha(32);

    }

    private Integer[] achaLinha(String linha){
        Integer[] aux = new Integer[2];
        for (int i = 0; i < linhas.length; i++)
            if (linhas[i].getTag()==null)
                return null;

            else if (linhas[i].getLinha().equals(linha)){
                aux[0] = 1;
                aux[1] = i;
                return aux;
            }

        return null;
    }

    private boolean achaTag(Integer pos, String tag){
        if (linhas[pos].getTag().equals(tag))
            return true;

        return false;
    }

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

}
