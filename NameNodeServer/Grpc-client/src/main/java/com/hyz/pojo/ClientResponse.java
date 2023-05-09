package com.hyz.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author HGD
 * @date 2022/8/24 23:50
 */
@Data
public class ClientResponse {
    Boolean isSucceed;
    String errMessage;
    String path;
    List<BasicMetadata> basicMetadata;
}
