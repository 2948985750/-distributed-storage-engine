package com.hyz.pojo.client.request;

import lombok.Data;

/**
 * @author HGD
 * @date 2022/8/30 12:56
 */
@Data
public class DeleteRequest {
    String remotePath;
    String fileHash;
}
