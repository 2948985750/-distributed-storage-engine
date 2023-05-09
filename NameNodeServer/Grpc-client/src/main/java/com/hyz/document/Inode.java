package com.hyz.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author HGD
 * @date 2022/8/30 23:06
 */
@Document(indexName = "inode")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inode {
    @Id
    @Field(type = FieldType.Keyword, store = true, index = false)
    private String hash;
    @Field(type = FieldType.Text, store = true,
            analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String fileName;
}
