package com.hyz.pojo.client.response;

import com.hyz.pojo.dataNode.Block;
import lombok.Data;

import java.util.List;

/**
 * @author HGD
 * @date 2022/8/30 13:13
 */
@Data
public class BlockResponse {
    Boolean isSucceed;
    String rrMessage;
    List<Block> blockList;
}
