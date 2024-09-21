package com.acting.actapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author acting
 */
public class SignUtils {

    /**
     * 生成签名
     *
     * @param body 请求体内容
     * @param sk   秘钥
     * @return 生成的签名的字符串
     */
    public static String genSign(String body, String sk) {
        //使用SHA256
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + sk;
        return md5.digestHex(content);

    }

}
