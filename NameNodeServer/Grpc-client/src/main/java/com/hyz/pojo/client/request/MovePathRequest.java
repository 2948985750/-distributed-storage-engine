package com.hyz.pojo.client.request;

import lombok.Data;

/**
 * @author HGD
 * @date 2022/8/30 12:58
 */
@Data
public class MovePathRequest {
    String sourcePath;
    String newPath;
    String fileHash;
}
