package com.dhcc.car.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * description:
 * ===>获取配置文件工具类
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-02-07 17:50
 */
public class PropertiesUtil {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);
    private static Properties prop = new Properties();

    public static void readProperties(String filePathName) {
        BufferedReader bf = null;
        InputStream in = null;
        StringBuilder sb = new StringBuilder("/");
        sb.append(filePathName);
        try {
            in = PropertiesUtil.class.getResourceAsStream(sb.toString());
            bf = new BufferedReader(new InputStreamReader(in));
            prop.load(bf);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage());
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage());
                }
            }

        }
    }

    /**
     * 根据key读取对应的value
     *
     * @param key 字段
     * @return 字段值
     */
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
