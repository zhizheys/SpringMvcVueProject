package com.me.service.impl;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.me.common.FileUtil;
import com.me.entity.LuceneBook;
import com.me.mapper.LuceneBookMapper;
import com.me.service.LuceneService;

@Service
public class LuceneServiceImpl implements LuceneService {

	private static final String indexFilePath = "E:/Test/Java/LuceneStore/HelloSpringTest/Index";

	@Autowired
	private LuceneBookMapper luceneBookMapper;

	@Override
	public List<LuceneBook> getAllLuceneBook() {
		List<LuceneBook> bookList = new ArrayList<LuceneBook>();
		bookList = luceneBookMapper.getAllLuceneBook();
		return bookList;
	}

	public void createIndex(List<Document> documentList) {

		try {

			List<Document> documents = documentList;

			// 3. 创建分析器对象(Analyzer), 用于分词
		
            //Analyzer analyzer = new StandardAnalyzer();//自带的分词
			
			Analyzer analyzer = new IKAnalyzer(); //使用IKAnalyzer分词

			// 4. 创建索引配置对象(IndexWriterConfig), 用于配置Lucene
			// 参数一:当前使用的Lucene版本, 参数二:分析器
			// IndexWriterConfig indexConfig = new
			// IndexWriterConfig(Version.LUCENE_7_5_0, analyzer);
			IndexWriterConfig indexConfig = new IndexWriterConfig(analyzer);

			// 5. 创建索引库目录位置对象(Directory), 指定索引库的存储位置
			// File path = new File(indexFilePath);

			Path path = FileSystems.getDefault().getPath(indexFilePath);
			Directory directory = FSDirectory.open(path);

			// 6. 创建索引写入对象(IndexWriter), 将文档对象写入索引
			IndexWriter indexWriter = new IndexWriter(directory, indexConfig);

			// 7. 使用IndexWriter对象创建索引
			for (Document doc : documents) {
				// addDocement(doc): 将文档对象写入索引库
				indexWriter.addDocument(doc);
			}

			// 8. 释放资源
			indexWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Document> searchIndex(String searchField, String searchQueryExpression) {
		
		 List<Document> documentList= new ArrayList<Document>();
		
		try {

			// 1. 创建分析器对象(Analyzer), 用于分词
			//Analyzer analyzer = new StandardAnalyzer();//自带的分词
			
			Analyzer analyzer = new IKAnalyzer(); //使用IKAnalyzer分词
			

			// 2. 创建查询对象(Query)
			// 2.1 创建查询解析器对象
			// 参数一:默认的搜索域, 参数二:使用的分析器
			QueryParser queryParser = new QueryParser(searchField, analyzer);
			// 2.2 使用查询解析器对象, 实例化Query对象
			Query query = queryParser.parse(searchQueryExpression);

			// 3. 创建索引库目录位置对象(Directory), 指定索引库位置
			Path path = FileSystems.getDefault().getPath(indexFilePath);
			Directory directory = FSDirectory.open(path);

			// 4. 创建索引读取对象(IndexReader), 用于读取索引
			IndexReader indexReader = DirectoryReader.open(directory);

			// 5. 创建索引搜索对象(IndexSearcher), 用于执行索引
			IndexSearcher searcher = new IndexSearcher(indexReader);

			// 6. 使用IndexSearcher对象执行搜索, 返回搜索结果集TopDocs
			// 参数一:使用的查询对象, 参数二:指定要返回的搜索结果排序后的前n个
			TopDocs topDocs = searcher.search(query, 10);

			// 7. 处理结果集
			// 7.1 打印实际查询到的结果数量
			System.out.println("实际查询到的结果数量: " + topDocs.totalHits);
			// 7.2 获取搜索的结果数组
			// ScoreDoc中有文档的id及其评分
			 ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			 
			 for (ScoreDoc scoreDoc : scoreDocs) {
		
			        // 获取文档的id和评分
			        int docId = scoreDoc.doc;
			        float score = scoreDoc.score;
			        
	
			        // 根据文档Id, 查询文档数据 -- 相当于关系数据库中根据主键Id查询数据
			        Document doc = searcher.doc(docId);
			        documentList.add(doc);
			    }

			// 8. 关闭资源
			indexReader.close();

	

		} catch (Exception e) {
			e.printStackTrace();
		}

		return documentList;
	}

	public void dbDataToLucene() {
		// 1. 采集数据
		List<LuceneBook> bookList = new ArrayList<LuceneBook>();
		bookList = luceneBookMapper.getAllLuceneBook();
		// 2. 创建文档对象
		List<Document> documents = new ArrayList<Document>();

		
		for (LuceneBook book : bookList) {
			Document document = new Document();
			// 给文档对象添加域
			// add方法: 把域添加到文档对象中, field参数: 要添加的域
			// TextField: 文本域, 属性name:域的名称, value:域的值, store:指定是否将域值保存到文档中
			document.add(new TextField("bookId", book.getId() + "", Store.YES));
			document.add(new TextField("bookName", book.getBookname(), Store.YES));
			document.add(new TextField("bookPrice", book.getPrice() + "", Store.YES));
			document.add(new TextField("bookPic", book.getPic(), Store.YES));
			document.add(new TextField("bookDesc", book.getBookdesc(), Store.YES));

			// 将文档对象添加到文档对象集合中
			documents.add(document);
		}

		createIndex(documents);

	}

	public void fileDataToLucene() {

		List<LuceneBook> bookList = new ArrayList<LuceneBook>();
		List<Document> documents = new ArrayList<Document>();

		String fileName1 = "E:/Test/Java/file/aaa.txt";
		String fileName2 = "E:/Test/Java/file/bbb.txt";

		String fileContent1 = FileUtil.readToString(fileName1);
		String fileContent2 = FileUtil.readToString(fileName2);

		Document document1 = new Document();
		document1.add(new TextField("fileContent", fileContent1, Store.YES));
		documents.add(document1);
		
		Document document2 = new Document();
		document2.add(new TextField("fileContent", fileContent2, Store.YES));
		documents.add(document2);

		createIndex(documents);
	}

}
