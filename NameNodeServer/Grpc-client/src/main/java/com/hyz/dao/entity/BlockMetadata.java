package com.hyz.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HGD
 * @date 2022/9/1 21:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("block_metadata")
public class BlockMetadata {
    @TableId(value = "server_id")
    private String serverId;
    @TableId(value = "block_id")
    private String blockId;
    @TableField(value = "file_hash")
    private String fileHash;
    @TableField(value = "order_of_block_in_file")
    private Integer orderOfBlockInFile;
    @TableId(value = "star_subscript")
    private Long starSubscript;
    @TableId(value = "end_subscript")
    private Long endSubscript;
}
