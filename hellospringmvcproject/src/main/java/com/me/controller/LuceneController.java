package com.me.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;

import com.me.entity.LuceneBook;
import com.me.service.LuceneService;
import com.me.service.impl.LuceneServiceImpl;

@RestController
@RequestMapping(value = "/lucene")
public class LuceneController {

	@Autowired
	private LuceneService luceneService;

	@RequestMapping(value = "/showlucenebook", method = RequestMethod.GET)
	public List<LuceneBook> showLuceneBook() {
		List<LuceneBook> bookList = luceneService.getAllLuceneBook();

		return bookList;
	}

	
	
	@RequestMapping(value = "/searchlucene/{field}/{query}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String searchLucene(HttpServletRequest request) {

		//http://localhost:8888/hellospringmvcproject/lucene/searchlucene/bookName/bookName:精通
		//http://localhost:8888/hellospringmvcproject/lucene/searchlucene/fileContent/fileContent:中国
		
		StringBuilder sBuilder = new StringBuilder();
		LuceneServiceImpl aImpl = new LuceneServiceImpl();
		NativeWebRequest webRequest = new ServletWebRequest(request);
		Map<String, String> map = (Map<String, String>) webRequest
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
		String searchField = map.get("field");
		String searchQueryExpression = map.get("query");

		List<Document> documentList = aImpl.searchIndex(searchField, searchQueryExpression);

		for (Document doc : documentList) {

			switch (searchField.toLowerCase()) {
			case "bookname":
				sBuilder.append("图书Id: " + doc.get("bookId"));
				sBuilder.append("\n");
				sBuilder.append("图书名称: " + doc.get("bookName"));
				sBuilder.append("\n");
				sBuilder.append("图书价格: " + doc.get("bookPrice"));
				sBuilder.append("\n");
				sBuilder.append("图书图片: " + doc.get("bookPic"));
				sBuilder.append("\n");
				sBuilder.append("图书描述: " + doc.get("bookDesc"));
				sBuilder.append("\n");
				break;

			case "bookdesc":
				sBuilder.append("图书Id: " + doc.get("bookId"));
				sBuilder.append("\n");
				sBuilder.append("图书名称: " + doc.get("bookName"));
				sBuilder.append("\n");
				sBuilder.append("图书价格: " + doc.get("bookPrice"));
				sBuilder.append("\n");
				sBuilder.append("图书图片: " + doc.get("bookPic"));
				sBuilder.append("\n");
				sBuilder.append("图书描述: " + doc.get("bookDesc"));
				sBuilder.append("\n");

				break;

			case "filecontent":
				sBuilder.append("内容描述: " + doc.get("fileContent"));
				sBuilder.append("\n");
				break;

			default:
				break;
			}

		}

		return sBuilder.toString();
	}

	@RequestMapping(value = "/dblucene", method = RequestMethod.GET)
	public String addDataToLuceneFromDB() {

		luceneService.dbDataToLucene();
		return "Lucene add data from database";
	}

	@RequestMapping(value = "/filelucene", method = RequestMethod.GET)
	public String addDataToLuceneFromFile() {

		luceneService.fileDataToLucene();
		return "Lucene add data from file";
	}

}
