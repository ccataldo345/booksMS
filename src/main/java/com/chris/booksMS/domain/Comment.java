package com.chris.booksMS.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private String commentText;
}
