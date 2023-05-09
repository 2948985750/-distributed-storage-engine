package com.hyz.pojo.client.response;

import com.hyz.pojo.client.request.BasicMetadata;
import lombok.Data;

/**
 * @author HGD
 * @date 2022/8/30 13:14
 */
@Data
public class StatResponse {
    Boolean isSucceed;
    String errMessage;
    String remotePath;
    BasicMetadata basicMetadata;
}
