package idwall.desafio.redditcrawler.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RedditPost {
	
	public static final String REDDIT_ENDPOINT = "https://old.reddit.com";
	
	private Long upVotes;
	private String subReddit;
	private String title;
	private String commentSectionLink;
	private String threadLink;
	
	public RedditPost(Long upVotes, String subReddit, String title, String commentSectionLink, String threadLink) {
		this.upVotes = upVotes;
		this.subReddit = subReddit;
		this.title = title;
		this.commentSectionLink = commentSectionLink;
		this.threadLink = threadLink;
	}
	
	public RedditPost(String subReddit, Element redditPostElement) {
		Elements title = redditPostElement.getElementsByClass("title").select("a.title");
		String commentsLink = redditPostElement.select("[data-event-action=\"comments\"]").attr("href");
		
		String likes = redditPostElement.getElementsByClass("score likes").get(0).attr("title");
		String threadLink = title.attr("href");
		String fullThreadLink = threadLink.startsWith("http") ? threadLink : REDDIT_ENDPOINT + threadLink;
		String threadTitle = title.get(0).wholeText();
		
		this.upVotes = Long.valueOf(likes);
		this.subReddit = subReddit;
		this.title = threadTitle;
		this.commentSectionLink = commentsLink;
		this.threadLink = fullThreadLink;
	}
	
	public Long getUpVotes() {
		return upVotes;
	}
	public String getSubReddit() {
		return subReddit;
	}
	public String getTitle() {
		return title;
	}
	public String getCommentSectionLink() {
		return commentSectionLink;
	}
	public String getThreadLink() {
		return threadLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentSectionLink == null) ? 0 : commentSectionLink.hashCode());
		result = prime * result + ((subReddit == null) ? 0 : subReddit.hashCode());
		result = prime * result + ((threadLink == null) ? 0 : threadLink.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((upVotes == null) ? 0 : upVotes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedditPost other = (RedditPost) obj;
		if (commentSectionLink == null) {
			if (other.commentSectionLink != null)
				return false;
		} else if (!commentSectionLink.equals(other.commentSectionLink))
			return false;
		if (subReddit == null) {
			if (other.subReddit != null)
				return false;
		} else if (!subReddit.equals(other.subReddit))
			return false;
		if (threadLink == null) {
			if (other.threadLink != null)
				return false;
		} else if (!threadLink.equals(other.threadLink))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (upVotes == null) {
			if (other.upVotes != null)
				return false;
		} else if (!upVotes.equals(other.upVotes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return 		"===================" + "\n"
				+ 	"UpVotes : " + upVotes + "\n"
				+	"SubReddit : " + subReddit + "\n"
				+ 	"Title : " + title + "\n"
				+ 	"Comments Link : " + commentSectionLink + "\n"
				+ 	"Thread Link : " + threadLink + "\n";
	}

}
