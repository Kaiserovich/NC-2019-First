package com.netcracker.edu.name2.backend.repositories;

import com.netcracker.edu.name2.backend.entities.CommentsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentsEntity, Long> {

}
