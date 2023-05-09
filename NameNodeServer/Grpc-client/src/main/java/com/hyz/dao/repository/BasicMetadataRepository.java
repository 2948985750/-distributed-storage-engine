package com.hyz.dao.repository;

import com.hyz.dao.document.BasicMetadata;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author HGD
 * @date 2022/8/30 14:31
 */
public interface BasicMetadataRepository extends ElasticsearchRepository<BasicMetadata, String> {
    /**
     * 通过哈希值和远程路径查询文件基本数据
     *
     * @param pathHash 路径哈希值
     * @return 基本元数据列表
     */
    List<BasicMetadata> findByPathHash(String pathHash);

    /**
     * 根据相对路径获取当前路径下的所有文件基本信息
     *
     * @param path 远程路径
     * @return 基本元数据列表
     */
    List<BasicMetadata> findByPath(String path);


}
