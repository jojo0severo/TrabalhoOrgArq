package MapeamentoAssociativo;

public class CacheAsso {
    private String[][] linha;
    private Integer posLinha;
    private int tipoCache;

    public CacheAsso(int tipoCache){
        this.tipoCache = tipoCache;
        if (tipoCache==16)
            linha = new String[16][5];

        else if(tipoCache==32)
            linha = new String[32][3];

        posLinha = 0;
    }

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

    private boolean achaPalavra(String palavra, Integer posicao){
        for (int i = 0; i < linha[posicao].length;i++)
            if (linha[posicao][i].equals(palavra))
                return true;
            else if (linha[posicao][i]==null)
                return false;

        return false;

    }

    private String calculaBin(String palavra){
        Integer aux = Integer.parseInt(palavra);
        String palavras = Integer.toBinaryString(aux+1);

        if (palavras.length()==1 && tipoCache==16)
            palavras = "0"+ palavras;

        return palavras;
    }

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
