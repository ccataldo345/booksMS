package com.chris.booksMS.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;

    @Size(max = 50, message="Please do not exceed 50 characters.")
    private String commentText;
}
