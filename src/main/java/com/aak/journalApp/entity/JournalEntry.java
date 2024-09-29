package com.aak.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Setter
@Data
@Document(collection = "j2")
@NoArgsConstructor
public class JournalEntry {
    @Id
    private ObjectId id;
    private String content;
    @NonNull
    private String title;
    private LocalDateTime date;


}