package Leitura_Impressao_Arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Arquivo {
    private Impressoes impressoes;
    private BufferedWriter bw;

    public Arquivo(Impressoes impressoes){
        this.impressoes = impressoes;
    }

    public void escreveDocumentoCompleto() throws Exception{
        File file = new File("DocumentoCompleto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getDocumentoCompleto());
        bw.flush();
        bw.close();
    }

    public void escreveValores() throws Exception{
        File file = new File("ValoresMapeamentos");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValores());
        bw.flush();
        bw.close();
    }

    public void escreveCaches() throws Exception{
        File file = new File("Caches");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCaches());
        bw.flush();
        bw.close();
    }

    public void escreveAssociativo() throws Exception{
        File file = new File("MapeamentoAssociativo");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getAssociativo());
        bw.flush();
        bw.close();
    }

    public void escreveValorAssociativo() throws Exception{
        File file = new File("ValorAssociativo");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValorAssociativo());
        bw.flush();
        bw.close();
    }

    public void escreveCacheAssociativo() throws Exception{
        File file = new File("CacheAssociativo");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapAsso());
        bw.flush();
        bw.close();
    }

    public void escreveDireto() throws Exception{
        File file = new File("MapeamentoDireto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getDireto());
        bw.flush();
        bw.close();
    }

    public void escreveValorDireto() throws Exception{
        File file = new File("ValorDireto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValorDireto());
        bw.flush();
        bw.close();
    }

    public void escreveCacheDireto() throws Exception{
        File file = new File("CacheDireto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapDir());
        bw.flush();
        bw.close();
    }

    public void escreveCachesTxt() throws Exception{
        File file = new File("Caches.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCachesTxt());
        bw.flush();
        bw.close();
    }

}
