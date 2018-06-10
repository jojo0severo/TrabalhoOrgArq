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

    /**
     *
     * Cria um arquivo com o nome 'DocumentoCompleto' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getDocumentoCompleto()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getDocumentoCompleto()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveDocumentoCompleto() throws Exception{
        File file = new File("DocumentoCompleto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getDocumentoCompleto());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'ValoresMapeamentos' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getValores()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getValores()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveValores() throws Exception{
        File file = new File("ValoresMapeamentos");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValores());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'Caches' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getCaches()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getCaches()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveCaches() throws Exception{
        File file = new File("Caches");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCaches());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'MapeamentoAssociativo' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getAssociativo()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getAssociativo()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveAssociativo() throws Exception{
        File file = new File("MapeamentoAssociativo");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getAssociativo());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'ValorAssociativo' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getValorAssociativo()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getValorAssociativo()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveValorAssociativo() throws Exception{
        File file = new File("ValorAssociativo");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValorAssociativo());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'CacheAssociativo' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getCacheMapAsso()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getCacheMapAsso()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveCacheAssociativo() throws Exception{
        File file = new File("CacheAssociativo");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapAsso());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'MapeamentoDireto' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getDireto()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getDireto()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveDireto() throws Exception{
        File file = new File("MapeamentoDireto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getDireto());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'ValorDireto' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getValorDireto()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getValorDireto()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveValorDireto() throws Exception{
        File file = new File("ValorDireto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValorDireto());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'CacheDireto' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getCacheMapDir()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getCacheMapDir()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveCacheDireto() throws Exception{
        File file = new File("CacheDireto");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapDir());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'Caches.txt' na pasta do projeto
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getCachesTxt()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getCachesTxt()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveCachesTxt() throws Exception{
        File file = new File("Caches.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCachesTxt());
        bw.flush();
        bw.close();
    }

}
