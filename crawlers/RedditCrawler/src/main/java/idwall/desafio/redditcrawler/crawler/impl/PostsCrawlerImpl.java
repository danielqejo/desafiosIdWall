package idwall.desafio.redditcrawler.crawler.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import idwall.desafio.redditcrawler.crawler.PostsCrawler;
import idwall.desafio.redditcrawler.model.RedditPost;

public class PostsCrawlerImpl implements PostsCrawler {
	
	@Override
	public List<RedditPost> getPostsFrom(String subReddit) throws IOException {
		
		Document dom = Jsoup.connect(RedditPost.REDDIT_ENDPOINT + "/r/"+ subReddit).get();
		
		Element elementById = dom.getElementById("siteTable");
		
		Elements elementsByClass = elementById.getElementsByClass("thing");
		List<RedditPost> posts = new ArrayList<>();
		
		for(Element element : elementsByClass) {
			Elements likes = element.getElementsByClass("score likes");
			String val = likes.get(0).attr("title");
			Long numberOfLikes = NumberUtils.isCreatable(val) ? Long.valueOf(val) : 0;
			
			if(numberOfLikes > 5000) {
				posts.add(new RedditPost(subReddit, element));
			}
		}
		
		return posts;
	}
	
	

}
