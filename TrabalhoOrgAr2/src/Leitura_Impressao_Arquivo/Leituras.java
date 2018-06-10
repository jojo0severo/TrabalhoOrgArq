package Leitura_Impressao_Arquivo;

import MapeamentoAssociativo.CacheAsso;
import MapeamentoAssociativo.MapeamentoAsso;
import MapeamentoDireto.CacheDir;
import MapeamentoDireto.MapeamentoDir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Leituras {
    private BufferedReader bf;
    private Integer hitA16;
    private Integer missA16;
    private Integer hitA32;
    private Integer missA32;
    private Integer hitD16;
    private Integer missD16;
    private Integer hitD32;
    private Integer missD32;
    private MapeamentoAsso mapA1;
    private MapeamentoAsso mapA2;
    private MapeamentoDir mapD1;
    private MapeamentoDir mapD2;
    private CacheAsso cacheAsso16;
    private CacheAsso cacheAsso32;
    private CacheDir cacheDir16;
    private CacheDir cacheDir32;

    public Leituras() {
        this.hitA16 = 0;
        this.missA16 = 0;
        this.hitA32 = 0;
        this.missA32 = 0;
        this.hitD16 = 0;
        this.missD16 = 0;
        this.hitD32 = 0;
        this.missD32 = 0;

        this.cacheAsso16 = new CacheAsso(16);
        this.mapA1 = new MapeamentoAsso(cacheAsso16);

        this.cacheAsso32 = new CacheAsso(32);
        this.mapA2 = new MapeamentoAsso(cacheAsso32);


        this.cacheDir16 = new CacheDir(16);
        this.mapD1 = new MapeamentoDir(cacheDir16);

        this.cacheDir32 = new CacheDir(32);
        this.mapD2 = new MapeamentoDir(cacheDir32);
    }

    public void le() throws Exception{
        leAssociativoAdresses16();

        leAssociativoAdresses32();

        leDiretoAdresses16();

        leDiretoAdresses32();
    }

    private void leAssociativoAdresses16()throws Exception{
        bf = new BufferedReader(new FileReader(new File("Adresses.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapA1.add16(line).equals("hit"))
                hitA16++;
            else
                missA16++;

    }

    private void leAssociativoAdresses32() throws Exception {
        bf = new BufferedReader(new FileReader(new File("Adresses.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapA2.add32(line).equals("hit"))
                hitA32++;
            else
                missA32++;
    }

    private void leDiretoAdresses16() throws Exception{
        bf = new BufferedReader(new FileReader(new File("Adresses.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapD1.add16(line).equals("hit"))
                hitD16++;
            else
                missD16++;
    }

    private void leDiretoAdresses32() throws Exception {
        bf = new BufferedReader(new FileReader(new File("Adresses.txt")));

        for (String line = bf.readLine(); line != null; line = bf.readLine())
            if (mapD2.add32(line).equals("hit"))
                hitD32++;
            else
                missD32++;
    }

    Integer getHitA16() {
        return hitA16;
    }

    Integer getMissA16() {
        return missA16;
    }

    Integer getHitA32() {
        return hitA32;
    }

    Integer getMissA32() {
        return missA32;
    }

    Integer getHitD16() {
        return hitD16;
    }

    Integer getMissD16() {
        return missD16;
    }

    Integer getHitD32() {
        return hitD32;
    }

    Integer getMissD32() {
        return missD32;
    }

    CacheAsso getCacheAsso16() {
        return cacheAsso16;
    }

    CacheAsso getCacheAsso32() {
        return cacheAsso32;
    }

    CacheDir getCacheDir16() {
        return cacheDir16;
    }

    CacheDir getCacheDir32() {
        return cacheDir32;
    }
}
