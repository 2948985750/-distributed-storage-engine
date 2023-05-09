package com.hyz.pojo.dataNode;

import lombok.Data;

/**
 * @author HGD
 * @date 2022/8/30 13:04
 */
@Data
public class Block {
    String serverId;
    String blockId;
    Long starSubscript;
    Long endSubscript;
}
