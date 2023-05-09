package com.hyz.dao.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


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
    private String fileHash;

    /**
     * 通过 文件路径 计算得出
     */
    @Field(type = FieldType.Text, store = true, index = false)
    private String pathHash;

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

    @Field(type = FieldType.Text, store = true)
    private String reviseTime;

    @JsonIgnore
    @Field(type = FieldType.Text, analyzer = "ik_max_word", excludeFromSource = true)
    private String search;
}
