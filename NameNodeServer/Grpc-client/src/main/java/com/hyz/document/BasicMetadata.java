package com.hyz.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author HGD
 * @date 2022/8/30 12:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "basicmetadata")
public class BasicMetadata {
    @Id
    @Field(type = FieldType.Keyword, store = true, index = false)
    private String hash;

    @Field(type = FieldType.Text, store = true, index = false)
    private String fileHash;

    @Field(type = FieldType.Text, store = true,
            analyzer = "ik_max_word", searchAnalyzer = "ik_max_word",
            copyTo = "search")
    private String fileName;

    @Field(type = FieldType.Text, store = true,
            analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String fileSize;

    @Field(type = FieldType.Text, store = true,
            analyzer = "ik_max_word", searchAnalyzer = "ik_max_word",
            copyTo = "search")
    private String fileExtension;

    @Field(type = FieldType.Text, store = true,
            analyzer = "ik_max_word", searchAnalyzer = "ik_max_word",
            copyTo = "search")
    private String path;

    @Field(type = FieldType.Date, pattern = "YYYY-MM-dd HH:mm:ss")
    private Date reviseTime;

    @JsonIgnore
    @Field(type = FieldType.Text, analyzer = "ik_max_word", excludeFromSource = true)
    private String search;
}
