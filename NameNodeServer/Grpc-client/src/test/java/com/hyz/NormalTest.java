package com.hyz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HGD
 * @date 2022/9/1 22:25
 */
public class NormalTest {
    @Test
    public void test() {
        String path = "a/b/c/d/e";
        StringBuilder varPath = new StringBuilder(path);
        String substring = path.substring(varPath.lastIndexOf("/") + 1);
        String pathName = String.valueOf(varPath.delete(varPath.lastIndexOf("/"), varPath.length()));
        System.out.println(substring);
        System.out.println(pathName);
    }
}
