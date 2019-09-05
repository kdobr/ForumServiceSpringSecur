package telran.ashkelon2018.forum.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = { "user", "dateCreated" })
public class Comment {
	String user;
	@Setter
	String comment;
	@JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
	LocalDateTime dateCreated;
	int likes;

	public Comment(String user, String message) {
		this.user = user;
		this.comment = message;
		dateCreated = LocalDateTime.now();
	}
	
	public void addLike() {
		likes++;
	}

}
