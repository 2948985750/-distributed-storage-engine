package com.hyz.dao.document;

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
public class FolderMetadata {
    @Id
    @Field(type = FieldType.Keyword, store = true, index = false)
    private String pathHash;

    @Field(type = FieldType.Text, store = true)
    private String folderName;

    @Field(type = FieldType.Text, store = true)
    private String parentPathHash;

    public BasicMetadata metadata() {
        BasicMetadata basicMetadata = new BasicMetadata();
        basicMetadata.setFileExtension("文件夹");
        basicMetadata.setFileHash(this.pathHash);
        basicMetadata.setFileName(this.folderName);
        basicMetadata.setPathHash(this.parentPathHash);
        return basicMetadata;
    }
}
