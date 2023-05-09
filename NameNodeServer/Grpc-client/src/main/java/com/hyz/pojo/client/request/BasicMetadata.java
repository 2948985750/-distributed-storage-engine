package com.hyz.pojo.client.request;

import lombok.Data;

/**
 * @author HGD
 * @date 2022/8/30 12:50
 */
@Data
public class BasicMetadata {
    String fileName;
    String fileSize;
    String fileExtension;
    String path;
    String fileHash;
}
