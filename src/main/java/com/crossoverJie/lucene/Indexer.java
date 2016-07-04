package com.crossoverJie.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2016/7/3.
 */
public class Indexer {
    private IndexWriter writer ;

    /**
     * 构造器 实例化IndexWriter
     * @param indexDir
     * @throws IOException
     */
    public Indexer(String indexDir) throws IOException {
        Directory dir = FSDirectory.open(Paths.get("indexDir")) ;
        //标准分词器
        Analyzer analyzer = new StandardAnalyzer() ;
        IndexWriterConfig config = new IndexWriterConfig(analyzer) ;
        writer = new IndexWriter(dir,config) ;
    }

    /**
     * 关闭索引
     * @throws IOException
     */
    public void closeWriter() throws IOException {
        writer.close();
    }

    public void index(File f) throws Exception {
        System.out.println("索引文件路径" + f.getCanonicalPath()) ;
//        Document doc = getd
    }


    /**
     * 索引指定目录的所有文件，返回索引数量
     * @param dataDir
     * @return
     * @throws IOException
     */
    public int index(String dataDir) throws Exception {
        File[] files = new File(dataDir).listFiles() ;
        for (File f : files){
            indexFile(f) ;
        }
        return writer.numDocs() ;
    }

    /**
     * 索引指定的文件
     * @param f
     * @throws IOException
     */
    private void indexFile(File f) throws Exception {
        System.out.println("索引文件目录:"+ f.getCanonicalPath());
        Document doc = getDocument(f) ;
        writer.addDocument(doc);
    }

    /**
     * 获取文档，在文档里面设值
     * @param f
     * @return
     * @throws Exception
     */
    private Document getDocument(File f) throws Exception {
        Document doc = new Document() ;
        doc.add(new TextField("contents",new FileReader(f)));
        doc.add(new TextField("fileName",f.getName(), Field.Store.YES));
        doc.add(new TextField("fullPath",f.getCanonicalPath(), Field.Store.YES));
        return doc;
    }

    public static void main(String[] args){
        String indexDir = "F:\\BaiduYunDownload" ;
        String dataDir = "F:\\BaiduYunDownload\\data" ;
        Indexer indexer = null ;
        int number = 0 ;
        long start = System.currentTimeMillis() ;
        try {
            indexer = new Indexer(indexDir) ;
            number = indexer.index(dataDir) ;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                indexer.closeWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end  = System.currentTimeMillis() ;
        System.out.println("总共索引了"+number+"个文件"+"消耗了"+(end - start)+"毫秒") ;
    }


}
