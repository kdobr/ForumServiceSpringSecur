package telran.ashkelon2018.forum.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2018.forum.dao.ForumRepository;
import telran.ashkelon2018.forum.domain.Comment;
import telran.ashkelon2018.forum.domain.Post;
import telran.ashkelon2018.forum.dto.DatePeriodDto;
import telran.ashkelon2018.forum.dto.NewCommentDto;
import telran.ashkelon2018.forum.dto.NewPostDto;
import telran.ashkelon2018.forum.dto.PostUpdateDto;

@Service
public class ForumServiceImpl implements ForumService{
	
	@Autowired
	ForumRepository repsitory;

	@Override
	public Post addNewPost(NewPostDto newPost) {
		Post post = new Post(newPost.getAuthor(), newPost.getTitle(), newPost.getContent(), newPost.getTags());
		repsitory.save(post);
		return post;
	}

	@Override
	public Post getPost(String id) {
	
		return repsitory.findById(id).orElse(null);
	}

	@Override
	public Post removePost(String id) {
		Post post = repsitory.findById(id).orElse(null);
		repsitory.delete(post);
		return post;
	}

	@Override
	public boolean updatePost(PostUpdateDto postUpdateDto) {
		Post post = repsitory.findById(postUpdateDto.getId()).orElse(null);
		if (post==null) return false;
		post.setMessage(postUpdateDto.getNewMessage());
		return repsitory.save(post) != null;
	}

	@Override
	public boolean addLike(String id) {
		Post post = repsitory.findById(id).orElse(null);
		if(post==null) return false;
		post.addLike();
		repsitory.save(post);
		return true;
	}

	@Override
	public Post addComment(String id, NewCommentDto newCommentDto) {
		Post post = repsitory.findById(id).orElse(null);
		post.addComment(new Comment(newCommentDto.getUser(), newCommentDto.getComment()));
		repsitory.save(post);
		return post;
	}

	@Override
	public Iterable<Post> findPostsByTegs(List<String> tags) {
		return repsitory.findByTagsIn(tags);
	}

	@Override
	public Iterable<Post> findPostsByAuthor(String author) {
				return repsitory.findByAuthor(author);
	}

	@Override
	public Iterable<Post> findPostsByDates(DatePeriodDto datesDto) {
	return repsitory.findByDateCreatedBetween(LocalDate.parse(datesDto.getFrom()), LocalDate.parse(datesDto.getTo()));
	}

}
