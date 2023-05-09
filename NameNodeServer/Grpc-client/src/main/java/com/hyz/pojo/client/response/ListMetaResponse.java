package com.hyz.pojo.client.response;

import com.hyz.pojo.client.request.BasicMetadata;
import lombok.Data;

import java.util.List;

/**
 * @author HGD
 * @date 2022/8/30 12:53
 */
@Data
public class ListMetaResponse {
    Boolean isSucceed;
    String errMessage;
    String remotePath;
    List<BasicMetadata> basicMetadataList;
}
