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
        File file = new File("ArquivosGerados/DocumentoCompleto.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getDocumentoCompleto());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'ValoresMapeamentos' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/ValoresMapeamentos.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValores());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'Caches' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/Caches.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCaches());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'MapeamentoAssociativo' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/MapeamentoAssociativo.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getAssociativo());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'ValorAssociativo' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/ValorAssociativo.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValorAssociativo());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'CacheAssociativo' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/CacheAssociativo.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapAsso());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'MapeamentoDireto' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/MapeamentoDireto.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getDireto());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'ValorDireto' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/ValorDireto.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getValorDireto());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'CacheDireto' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/CacheDireto.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapDir());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'CachesTagPalavraConcat' na pasta ArquivosGerados
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
        File file = new File("ArquivosGerados/CachesTagPalavraConcat.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCachesTxt());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'Adresses' na pasta ArquivosGerados
     *
     * A classe Leituras eh obtida a partir do metodo 'getLeituras()'
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a cada posicao
     * da matriz recebida do metodo 'getBinHexa()' da classe Leituras
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getBinHexa()
     * @method getLeituras()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveEnderecosBinHexa()throws Exception{
        File file = new File("ArquivosGerados/Adresses.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        String[][] aux = impressoes.getLeituras().getBinHexa();

        for (int i =0; i < aux.length;i++) {
            bw.append(aux[i][0]+aux[i][1]);
            bw.newLine();
        }
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'CachesEnderecoOrig' na pasta ArquivosGerados
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getCachesOrigin()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getCachesOrig()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveCachesComEnderecoOriginal() throws Exception{
        File file = new File("ArquivosGerados/CachesEnderecoOrig.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCachesOrig());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'CacheAssoEnederecoOrig' na pasta ArquivosGerados
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getCacheMapAssoOrig()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getCacheMapAssoOrig()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveCacheAssoOrig() throws Exception{

        File file = new File("ArquivosGerados/CacheAssoEnderecoOrig.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapAssoOrig());
        bw.flush();
        bw.close();

         
    }

    /**
     *
     * Cria um arquivo com o nome 'CacheDirEnderecoOrig' na pasta ArquivosGerados
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getCacheMapDirOrig()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getCacheMapDirOrig()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver erro durante a escrita do arquivo
     */

    public void escreveCacheDirOrig()throws Exception{
        File file = new File("ArquivosGerados/CacheDirEnderecoOrig.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getCacheMapDirOrig());
        bw.flush();
        bw.close();
         
    }

    /**
     *
     * Cria um arquivo com o nome 'MapeamentoAssociativoOrig' na pasta ArquivosGerados
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getAssociativoOrig()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getAssociativoOrig()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver algum erro na escrita do arquivo
     */

    public void escreveMapeamentoAssociativoOrig()throws Exception{
        File file = new File("ArquivosGerados/MapeamentoAssociativoOrig.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getAssociativoOrig());
        bw.flush();
        bw.close();
    }

    /**
     *
     * Cria um arquivo com o nome 'MapeamentoDiretoOrig' na pasta ArquivosGerados
     *
     * Atraves do metodo 'append(String)', escreve no arquivo a String recebida do
     * metodo 'getDiretoOrig()' da classe Impressoes
     *
     * Com o metodo 'flush()' forca a escreve no arquivo caso nao o tenha feito
     *
     * Com o metodo 'close()' o escritor de arquivo eh encerrado
     *
     *
     *
     * @method getDiretoOrig()
     * @method createNewFile()
     * @method append()
     * @method flush()
     * @method close()
     * @throws Exception se houver algum erro na escrita do arquivo
     */

    public void escreveMapeamentoDiretoOrig() throws Exception{
        File file = new File("ArquivosGerados/MapeamentoDiretoOrig.txt");
        file.createNewFile();

        this.bw = new BufferedWriter(new FileWriter(file));

        bw.append(impressoes.getDiretoOrig());
        bw.flush();
        bw.close();
    }


}
