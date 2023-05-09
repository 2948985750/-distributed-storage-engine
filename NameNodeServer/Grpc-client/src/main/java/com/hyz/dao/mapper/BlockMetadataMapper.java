package com.hyz.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyz.dao.entity.BlockMetadata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HGD
 * @date 2022/9/1 21:26
 */
@Mapper
public interface BlockMetadataMapper extends BaseMapper<BlockMetadata> {
    /**
     * 根据文件哈希值找到对应的元数据
     *
     * @param fileHash 文件哈希值
     * @return 元数据列表
     */
    List<BlockMetadata> getAllByFileHashSortByAsc(@Param("fileHash") String fileHash);

}
