package com.example.mysecurity.auth.cache;

import cn.hutool.core.util.IdUtil;
import com.example.mysecurity.entity.SarlineToken;
import com.example.mysecurity.service.SarlineTokenService;
import com.example.mysecurity.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 先缓存本地，后期同步到数据库和redis
 */
@Service
public class TokenCache {


    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private SarlineTokenService sarlineTokenService;


//    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap();


    public void setToken(String key, String token) {

        redisUtil.set("token_"+key, token);
        SarlineToken sarlineToken = new SarlineToken();
        sarlineToken.setToken(token);
        sarlineToken.setName(key);
        sarlineToken.setId(IdUtil.simpleUUID());
        sarlineTokenService.insert(sarlineToken);
    }

    public String getToken(String key) {

        String token = (String) redisUtil.get("token_"+key);
        if (token == null) {
            SarlineToken sarlineToken = sarlineTokenService.queryByName(key);
            if(sarlineToken!=null){
                token = sarlineToken.getToken();
                redisUtil.set(key, token);
            }
        }
        return token;
    }

    public Boolean clearToken(String key, String token) {
        redisUtil.remove("token_"+key);
        SarlineToken sarlineToken = sarlineTokenService.queryByName(key);
        return sarlineTokenService.deleteById(sarlineToken.getId());
    }
}
