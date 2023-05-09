package com.hyz.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author HGD
 * @date 2022/8/27 18:45
 */
@Data
public class BlockOrderMap {
    Integer orderOfBlockInFile;
    List<Block> blockList;
}
