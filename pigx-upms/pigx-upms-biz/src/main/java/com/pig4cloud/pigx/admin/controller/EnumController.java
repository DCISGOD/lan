package com.pig4cloud.pigx.admin.controller;

import com.pig4cloud.pigx.admin.api.dto.EnumDto;
import com.pig4cloud.pigx.admin.util.EnumUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author DC
 */
@RestController
@RequestMapping("enums")
public class EnumController {

    @GetMapping("/type")
    public HashMap<String, List<EnumDto>> getTheEnumerationListByType(String type) throws Exception {
        return EnumUtils.getEnums(type);
    }
}
