package com.hyz.pojo;

import lombok.Data;

/**
 * @author HGD
 * @date 2022/8/24 18:55
 */
@Data
public class BasicMetadata {
    String fileName;
    String fileSize;
    String fileExtension;
    String path;
    String fileHash;
}
