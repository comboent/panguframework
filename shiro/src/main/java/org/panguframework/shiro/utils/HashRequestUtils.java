package org.panguframework.shiro.utils;

import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;

public class HashRequestUtils {

    public static HashRequest createHashRequest(String password, String salt) {
        return new HashRequest.Builder()
                .setSource(ByteSource.Util.bytes(password))
                .setSalt(ByteSource.Util.bytes(salt))
                .build();
    }
}
