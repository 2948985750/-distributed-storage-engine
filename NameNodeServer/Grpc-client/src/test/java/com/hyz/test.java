package com.hyz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HGD
 * @date 2022/9/1 22:25
 */
public class test {
    @Test
    public void test() {
        String path = "a/b/c/d/e";
        StringBuilder varPath = new StringBuilder(path);
        String pathName = String.valueOf(varPath.delete(varPath.lastIndexOf("/"), varPath.length() - 1));
        System.out.println(pathName);
        System.out.println(path);
    }
}
