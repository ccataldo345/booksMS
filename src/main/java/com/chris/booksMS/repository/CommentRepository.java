package com.chris.booksMS.repository;

import com.chris.booksMS.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
