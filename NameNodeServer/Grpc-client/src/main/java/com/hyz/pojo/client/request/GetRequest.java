package com.hyz.pojo.client.request;

import lombok.Data;

/**
 * @author HGD
 * @date 2022/8/30 12:55
 */
@Data
public class GetRequest {
    String remotePath;
    String fileHash;
}
