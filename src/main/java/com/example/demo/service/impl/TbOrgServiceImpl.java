package com.example.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.TbOrg;
import com.example.demo.mapper.TbOrgMapper;
import com.example.demo.service.ITbOrgService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@DS("1")
@Service
public class TbOrgServiceImpl extends ServiceImpl<TbOrgMapper, TbOrg> implements ITbOrgService {

}
