package com.example.demo.controller;


import com.example.demo.entity.TbProtalBpmMapInfo;
import com.example.demo.mapper.TbProtalBpmMapInfoMapper;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-17
 */
@RestController
@RequestMapping("/demo")
public class TbProtalBpmMapInfoController {

    @Autowired
    private TbProtalBpmMapInfoMapper infoMapper;

    @GetMapping("/info")
    public void mapSave() throws IOException {
        String now = LocalDate.now().toString().replace("-", "");
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\xiangzhang\\Desktop\\定时任务-组织\\T99_PORTAL_BPM_MAP_INFO20210816.csv"));
        List<String> split ;
        List<TbProtalBpmMapInfo>  tbProtalBpmMapInfos = new ArrayList<>();

        for (String line:
             lines) {
             split = Splitter.on(",").trimResults().splitToList(line.replace("\"", ""));
             tbProtalBpmMapInfos.add(new TbProtalBpmMapInfo(split.get(1),split.get(2),split.get(3),split.get(4),split.get(5),now));
        }

        if (tbProtalBpmMapInfos.size() > 0) {
            infoMapper.clearTable();
        }
        infoMapper.saveList(tbProtalBpmMapInfos);
    }

}

