package com.pig4cloud.pigx.admin.util;

import cn.hutool.core.util.ClassUtil;
import com.pig4cloud.pigx.admin.api.dto.EnumDto;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 枚举工具类
 *
 * @author DC
 */
public class EnumUtils {

    // 枚举类型包路径
    private static final String BASE_PACKAGE = "com.pig4cloud.pigx.admin.api.enums";

    /**
     *
     * @param type 枚举的类名
     * @return
     * @throws Exception
     */
    public static HashMap<String, List<EnumDto>> getEnums(String type) throws Exception {
        Set<Class<?>> classes = ClassUtil.scanPackage(BASE_PACKAGE);
        HashMap<String, List<EnumDto>> enums = new HashMap<>();

        for (Class<?> aClass : classes) {
            boolean equals ;
            if (type != null) {
                equals = aClass.getName().equals(BASE_PACKAGE + "." + type);
            }else {
                equals = true;
            }
            if (ClassUtil.isEnum(aClass) && equals) {
                Class<Enum> em = (Class<Enum>) aClass;
                // 枚举类里面必须是 code 和desc
                Method codeMethod = ClassUtil.getDeclaredMethod(aClass, "getValue");
                Method descMethod = ClassUtil.getDeclaredMethod(aClass, "getDesc");
                if (codeMethod == null || descMethod == null) {
                    continue;
                }
                //得到enum的所有实例
                Object[] objs = em.getEnumConstants();
                EnumDto dto;
                List<EnumDto> list = new ArrayList<>();
                for (Object obj : objs) {
                    dto = new EnumDto();
                    dto.setCode(codeMethod.invoke(obj) + "");
                    dto.setDesc(descMethod.invoke(obj) + "");
                    list.add(dto);
                }
                enums.put(aClass.getName().replace(BASE_PACKAGE + ".", "").replace("$", "."), list);
            }
        }
        return enums;
    }
}

