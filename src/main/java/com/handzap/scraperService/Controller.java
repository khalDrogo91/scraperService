package com.handzap.scraperService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@RestController
public class Controller {
   
	@RequestMapping(method = RequestMethod.GET, value="/authors/")
    @ResponseBody
    public ResponseEntity<List<Author>> getAvailableAuthors(String name) throws IOException {
		System.out.println("getting list of  available Authors");
		WebClient webClient = new WebClient();
		webClient.getOptions().setCssEnabled(false);
	    webClient.getOptions().setJavaScriptEnabled(false);
	 
	    String url = "https://www.thehindu.com/search/?q=authors&order=DESC&sort=publishdate";
	    HtmlPage page = webClient.getPage(url);
	    String xpath = "(//ul[@class='story-card-news']/li)[1]/a";
	    HtmlAnchor latestPostLink = (HtmlAnchor) page.getByXPath(xpath).get(0);
	    HtmlPage postPage = latestPostLink.click();
	 
	    List<HtmlHeading1> h1  
	      = (List<HtmlHeading1>) postPage.getByXPath("//h1");
	  
		ArrayList<Author> entity = new ArrayList<Author>();
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value="/authors/articles")
    @ResponseBody
	 public ResponseEntity<List<String>> getArticles(@RequestParam(name="name", required=false, defaultValue="articles") String name) throws IOException {
		List<String> listOfArticles =new ArrayList<>();
		return new ResponseEntity<>(listOfArticles,  HttpStatus.OK);
	 }
	
	
	
	
}
