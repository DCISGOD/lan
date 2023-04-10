import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.anji.captcha.util.AESUtil;
import com.pig4cloud.pigx.admin.api.feign.RemoteParamService;
import com.pig4cloud.pigx.common.core.util.SpringContextHolder;
import com.pig4cloud.pigx.common.data.resolver.ParamResolver;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SimpleTest {
    @Test
    public void test1 (){
//        String tenantDefaultPassword = ParamResolver.getStr("TENANT_DEFAULT_PASSWORD", "123456");

        String tenantDefaultPassword = getStr("TENANT_DEFAULT_PASSWORD", "123456");
        System.out.println("tenantDefaultPassword = " + tenantDefaultPassword);
        PasswordEncoder ENCODER = new BCryptPasswordEncoder();
        String encode = ENCODER.encode(tenantDefaultPassword);
        System.out.println("encode = " + encode);
    }


    public static String encodePassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public static String getStr(String key, String... defaultVal) {
        return (String)checkAndGet(key, String.class, defaultVal);
    }

    private static <T> T checkAndGet(String key, Class<T> clazz, T... defaultVal) {
        if (!StrUtil.isBlank(key) && defaultVal.length <= 1) {
            RemoteParamService remoteParamService = (RemoteParamService) SpringContextHolder.getBean(RemoteParamService.class);
            String result = (String)remoteParamService.getByKey(key, "Y").getData();
            if (StrUtil.isNotBlank(result)) {
                return Convert.convert(clazz, result);
            } else {
                return defaultVal.length == 1 ? Convert.convert(clazz, ((Object[])defaultVal.clone())[0]) : null;
            }
        } else {
            throw new IllegalArgumentException("参数不合法");
        }
    }
}
