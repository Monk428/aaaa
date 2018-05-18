package com.monk.sbbook.dao;

import com.monk.sbbook.entity.GoodInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品jpa查询接口
 */
public interface GoodInfoRepositoryDao
    extends JpaRepository<GoodInfoEntity,Long>
{
}
