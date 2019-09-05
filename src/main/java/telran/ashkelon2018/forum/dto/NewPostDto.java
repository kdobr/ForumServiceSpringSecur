package telran.ashkelon2018.forum.dto;

import java.util.Set;

import lombok.Getter;

@Getter
public class NewPostDto {
	
	String author;
	String title;
	String content;
	Set<String>tags;
	

}
