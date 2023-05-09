package com.hyz.dao.repository;

import com.hyz.dao.document.FolderMetadata;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author HGD
 * @date 2022/9/1 21:49
 */
public interface FolderMetadataRepository extends ElasticsearchRepository<FolderMetadata, String> {
    /**
     * 根据父路径哈希值获取
     *
     * @param parentPathHash 路径哈希值
     * @return 列表
     */
    List<FolderMetadata> findByParentPathHash(String parentPathHash);
}
