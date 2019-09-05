package telran.ashkelon2018.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2018.forum.domain.Post;
import telran.ashkelon2018.forum.dto.DatePeriodDto;
import telran.ashkelon2018.forum.dto.NewCommentDto;
import telran.ashkelon2018.forum.dto.NewPostDto;
import telran.ashkelon2018.forum.dto.PostUpdateDto;
import telran.ashkelon2018.forum.service.ForumService;

@RestController
public class ForumController {
	
@Autowired
ForumService forumService;
	
@PostMapping("/post")
public Post addNewPost(@RequestBody NewPostDto newPost ) {
return forumService.addNewPost(newPost);}
	
	
@GetMapping("/post/{id}")	
public Post getPost(@PathVariable String id) {
return forumService.getPost(id);
	
}

@DeleteMapping("/post/{id}")
public Post removePost(@PathVariable String id) {
return forumService.removePost(id);
}


@PutMapping ("/post")
public boolean updatePost (@RequestBody PostUpdateDto postUpdateDto) {
return forumService.updatePost(postUpdateDto);

	
}

@PutMapping ("/post/{id}")
public boolean addLike (@PathVariable String id) {
return forumService.addLike(id);
}


@PutMapping ("/post/comment/{id}")
public Post  addComment (@PathVariable String id, 
		@RequestBody NewCommentDto newCommentDto) {
return forumService.addComment(id, newCommentDto);
	
	
}

@GetMapping ("/post/tegs")
public Iterable<Post> findPostsByTegs (@RequestBody List<String> tags){
	return forumService.findPostsByTegs(tags);
}

@GetMapping ("/post/author/{author}")
public Iterable<Post> findPostsByAuthor (@PathVariable String author){
	return forumService.findPostsByAuthor(author);
}
@GetMapping("/post/dates")
public Iterable<Post> findPostsByDates (@RequestBody DatePeriodDto datesDto){
		return forumService.findPostsByDates(datesDto);
}

}
