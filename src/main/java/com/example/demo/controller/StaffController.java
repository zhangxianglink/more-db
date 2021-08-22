package com.example.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 定时任务同步
 * @author xiang.z
 * @date 2021年8月20日
 */
@RestController
@RequestMapping("/api/staff")
public class StaffController {

//
//    /**
//     * 同步组织信息
//     *
//     * @return
//     */
//    @PostMapping("/syncOrg")
//    public void syncOrg(HttpServletRequest httpServletRequest) {
//        long startTime = System.currentTimeMillis();
//        BaseRequest baseRequest = (BaseRequest) httpServletRequest.getAttribute("baseRequest");
//        List<OrgDto> orgDtolist = JSonUtil.getList(JSON.toJSONString(baseRequest), "data", OrgDto.class);
//        if (orgDtolist == null) {
//            throw new BaseException(ResponseEnum.REQUEST_DATA_IS_NULL);
//        }
//        orgDtolist.forEach(orgDto -> {
//            if (orgDto.getOrgCode() == null) {
//                throw new BaseException(ResponseEnum.PARAMS_IS_ERROR);
//            }
//        });
//        logger.info("【{}】接收到需要同步的数据数量为：{}", SystemContext.getLogID(), orgDtolist.size());
//        syncService.syncOrg(orgDtolist);
//        long endTime = System.currentTimeMillis();
//        logger.info("【{}】数据同步成功，消耗时间：{}", SystemContext.getLogID(), endTime - startTime);
//        return new ResponseData(ResponseEnum.SUCCESS);
//    }
//
//    @PostMapping("/syncStaff")
//    public ResponseData syncStaff(HttpServletRequest httpServletRequest) {
//        BaseRequest baseRequest = (BaseRequest) httpServletRequest.getAttribute("baseRequest");
//        List<UserDTO> userDTOList = JSonUtil.getList(JSON.toJSONString(baseRequest), "data", UserDTO.class);
//        if (userDTOList == null) {
//            throw new BaseException(ResponseEnum.REQUEST_DATA_IS_NULL);
//        }
//        userDTOList.forEach(userDTO -> {
//            if (userDTO.getWorkNumber() == null) {
//                throw new BaseException(ResponseEnum.PARAMS_IS_ERROR);
//            }
//        });
//        logger.info("【{}】接收到需要同步的数据数量为：{}", SystemContext.getLogID(), userDTOList.size());
//        syncService.syncUser(userDTOList);
//        logger.info("【{}】数据同步成功", SystemContext.getLogID());
//        return new ResponseData(ResponseEnum.SUCCESS);
//    }
//
}
