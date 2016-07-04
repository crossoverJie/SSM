package com.crossoverJie.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Searcher {

    /**
     * 根据关键字查询
     * @param indexDir
     * @param key
     */
    public static void search(String indexDir,String key) throws Exception {
        Directory dir = FSDirectory.open(Paths.get(indexDir)) ;
        IndexReader reader = DirectoryReader.open(dir) ;
        IndexSearcher is = new IndexSearcher(reader) ;
        Analyzer analyzer = new StandardAnalyzer() ;//new一个标准分词器
        QueryParser parser = new QueryParser("contents",analyzer) ;
        Query query = parser.parse(key) ;
        long start=System.currentTimeMillis();
        TopDocs hits = is.search(query, 10);
        long end=System.currentTimeMillis();
        System.out.println("匹配 "+key+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");
        for (ScoreDoc doc : hits.scoreDocs){
            Document dc = is.doc(doc.doc);
            System.out.println(dc.get("fullPath"));
        }
        reader.close();
    }


    public static void main(String args[]) throws Exception {
        String indexDir = "F:\\Idea\\SSM\\indexDir" ;
        String key = "crossoverjie" ;
        search(indexDir,key);
    }


}
