package idwall.desafio.redditcrawler.crawler;

import java.io.IOException;
import java.util.List;

import idwall.desafio.redditcrawler.model.RedditPost;

public interface PostsCrawler {
	
	List<RedditPost> getPostsFrom(String subReddit) throws IOException;

}
