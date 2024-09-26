package com.aak.journalApp.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
public class JournalEntry {

@Getter
@Setter
@Document(collection = "j2")
public class JournalEntry {
    @Id
    private ObjectId id;
    private String content;
    private String title;
    private LocalDateTime date;

}
}
