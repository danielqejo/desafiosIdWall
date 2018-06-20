package idwall.desafio.redditcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import idwall.desafio.redditcrawler.crawler.PostsCrawler;
import idwall.desafio.redditcrawler.crawler.impl.PostsCrawlerImpl;
import idwall.desafio.redditcrawler.model.RedditPost;

public class RedditCrawlerApplication {
	
	private static PostsCrawler postsCrawler = new PostsCrawlerImpl();
	
	private static final String DEFAULT_SUBREDDITS = "cats;worldnews;brazil";
	
	public static void main(String[] args) {
		try {
			
			String fullString = (args.length != 0) ? args[0] : DEFAULT_SUBREDDITS;
			
			String[] subReddits = fullString.split(";");
			
			List<RedditPost> redditPosts = new ArrayList<>();
			for(String subReddit : subReddits) {
					redditPosts.addAll(postsCrawler.getPostsFrom(subReddit));
			}
			
			for(RedditPost redditPost : redditPosts)
				System.out.println(redditPost);
		
		} catch (IOException e) {
			throw new RuntimeException("Something went Wrong on getting top current reddit threads.");
		}
	}
	

}
