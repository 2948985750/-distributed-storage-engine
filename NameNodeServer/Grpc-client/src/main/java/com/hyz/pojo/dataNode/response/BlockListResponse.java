package com.hyz.pojo.dataNode.response;

import com.hyz.pojo.dataNode.BlockOrderMap;
import com.hyz.pojo.dataNode.BlockStat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author HGD
 * @date 2022/8/30 13:08
 */
@Data
public class BlockListResponse {
    BlockStat operateStat;
    String fileHash;
    Date uploadTime;
    List<BlockOrderMap> blockList;
}
