package com.hyz.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author HGD
 * @date 2022/8/27 18:56
 */
@Data
public class BlockListResponse {
    String fileHash;
    Date uploadTime;
    List<BlockOrderMap> blockList;
}
