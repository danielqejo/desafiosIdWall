package idwall.desafio.redditcrawler.telegram.bots;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;

import idwall.desafio.redditcrawler.crawler.PostsCrawler;
import idwall.desafio.redditcrawler.crawler.impl.PostsCrawlerImpl;
import idwall.desafio.redditcrawler.model.RedditPost;

public class DanielIdWallBot extends AbilityBot {
	
	private PostsCrawler postsCrawler;
	
	public DanielIdWallBot() {
		super("603133789:AAE0GDM2e4puNhpJZMfY2KxjHt7BF9J53nM", "danielidwallbot");
		this.postsCrawler = new PostsCrawlerImpl();
	}

	@Override
	public int creatorId() {
		return 0;
	}

	public Ability nadaPraFazer() {
		return Ability.builder()
				.name("NadaPraFazer")
				.info("brings top trending reddit posts")
				.input(1)
				.locality(Locality.ALL)
				.privacy(Privacy.PUBLIC)
				.action(ctx -> {
					
					StringBuilder sb = new StringBuilder();
					try {
						List<RedditPost> redditPosts = new ArrayList<>();
						String[] subReddits = ctx.firstArg().split(";");
						
						for(String subReddit : subReddits) {
							redditPosts.addAll(postsCrawler.getPostsFrom(subReddit));
						}
							 
						for(RedditPost redditPost : redditPosts) {
							sb.append(redditPost.toString());
						}
					} catch (IOException e) {
						sb.append("Unable to create list of posts.");
					}
					
					String result = sb.toString().length() == 0 ? "No matches found in these SubReddits." : sb.toString();
					
					silent.send(result, ctx.chatId());
				})
				.build();
	}
	
	
}
