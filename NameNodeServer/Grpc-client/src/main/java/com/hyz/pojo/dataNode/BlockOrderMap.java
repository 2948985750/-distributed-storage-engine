package com.hyz.pojo.dataNode;

import lombok.Data;

import java.util.List;

/**
 * @author HGD
 * @date 2022/8/30 13:06
 */
@Data
public class BlockOrderMap {
    Integer orderOfBlockInFile;
    List<Block> blockList;
}
