package telran.ashkelon2018.forum.dto;

import java.util.Set;

import lombok.Getter;
import telran.ashkelon2018.forum.domain.Comment;

@Getter
public class NewCommentDto {
	
	String user;
	String comment;

}
