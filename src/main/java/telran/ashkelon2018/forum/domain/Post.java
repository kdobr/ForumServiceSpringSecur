package telran.ashkelon2018.forum.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = { "id" })
@ToString
@Document (collection = "forum_security")
public class Post {
	String id;
	String author;
	@Setter String title;
	@Setter String message;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
	LocalDateTime dateCreated;
	Set<String> tags;
	int likes;
	Set<Comment> comments;
	public Post(String author, String title, String content,  Set<String> tags) {
		
		this.title = title;
		this.message = content;
		this.author = author;
		this.tags = tags;
		dateCreated = LocalDateTime.now();
		comments = new HashSet<>();
	}
	
	public void addLike() {
		likes++;
	}
	
	public boolean addComment(Comment comment) {
		return comments.add(comment);
	}
	
	public boolean addTag(String tag) {
		return tags.add(tag);
	}
	
	public boolean removeTag(String tag) {
		return tags.remove(tag);
	}
	
	
}
