package com.hit.cost.controller;

import com.hit.cost.bean.TokenInfoEntity;
import com.hit.cost.bean.TokenResult;
import com.hit.cost.bean.UserInfoEntity;
import com.hit.cost.jpa.TokenJPA;
import com.hit.cost.jpa.UserInfoJPA;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/10/24 19:23
 * <p>
 * Created By IDEA
 * ==========================
 */
@RestController
@RequestMapping(value="jwt")
@Api(value="JWT加密API")
public class TokenController {
    @Autowired
    private UserInfoJPA userInfoJPA;
    @Autowired
    private TokenJPA tokenJPA;
    @RequestMapping(value="/token",method = {RequestMethod.POST,RequestMethod.GET})
    @ApiOperation(value ="token校验",notes = "校验APPID的token是否过期，密码是否正确")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name = "appID",value = "appID",required = true),
            @ApiImplicitParam(name = "appSecret",value = "密码",required = true)})

    public TokenResult token(@RequestParam String appID,@RequestParam String appSecret){
        TokenResult tokenResult  = new TokenResult();
        if (appID==null||appID.isEmpty()){
            tokenResult.setFlag(false);
            tokenResult.setMsg("appID is not found");
        }
       else if (appSecret==null||appSecret.isEmpty()){
            tokenResult.setFlag(false);
            tokenResult.setMsg("appSecret is not found");
        }
        else {
            Optional<UserInfoEntity> userinfoEntity = userInfoJPA.findOne(new Specification<UserInfoEntity>() {
                @Override
                public Predicate toPredicate(Root<UserInfoEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    query.where(criteriaBuilder.equal(root.get("appID"),appID));
                    return null;
                }
            });
            if (!userinfoEntity.isPresent()){
                tokenResult.setFlag(false);
                tokenResult.setMsg("appID:"+appID+" is not found");
            }
            else if (!createDecodePassword(new String(userinfoEntity.get().getAppSecret())).equals(appSecret.replace(" ","+"))){
                tokenResult.setFlag(false);
                tokenResult.setMsg("appSecret is not effective!");
            }
            else{
                Optional<TokenInfoEntity> tokenInfoEntity = tokenJPA.findOne(new Specification<TokenInfoEntity>() {
                    @Override
                    public Predicate toPredicate(Root<TokenInfoEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        query.where(criteriaBuilder.equal(root.get("appId"),appID));
                        return null;
                    }
                });
                String tokenStr  = null;
                if (!tokenInfoEntity.isPresent()){
                    tokenStr  = createNewToken(appID);
                    TokenInfoEntity tokenInfo = new TokenInfoEntity();
                    tokenInfo.setAppId(appID);
                    tokenInfo.setBuildTime(String.valueOf(System.currentTimeMillis()));
                    tokenInfo.setToken(tokenStr.getBytes());
                    tokenJPA.save(tokenInfo);
                }
                else {
                    //判断数据库中token是否过期，如果没有过期不需要更新直接返回数据库中的token即可
                    //数据库中生成时间
                    long dbBuildTime = Long.valueOf(tokenInfoEntity.get().getBuildTime());
                    //当前时间
                    long currentTime = System.currentTimeMillis();
                    //如果当前时间 - 数据库中生成时间 < 7200 证明可以正常使用
                    long second = TimeUnit.MILLISECONDS.toSeconds(currentTime - dbBuildTime);
                    if (second > 0 && second < 7200) {
                        tokenStr = new String(tokenInfoEntity.get().getToken());
                    }
                    //超时
                    else{
                        //生成newToken
                        tokenStr = createNewToken(appID);
                        //更新token
                        tokenInfoEntity.get().setToken(tokenStr.getBytes());
                        //更新生成时间
                        tokenInfoEntity.get().setBuildTime(String.valueOf(System.currentTimeMillis()));
                        //执行更新
                        tokenJPA.save(tokenInfoEntity.get());
                    }
                }
                //设置返回token
                tokenResult.setToken(tokenStr);


            }
        }
        return  tokenResult;
    }

    private String createNewToken(String appID) {
        //获取当前时间
        Date now = new Date(System.currentTimeMillis());
        Date expireDate = new Date(now.getTime()+7200000);
        return Jwts.builder().
                setSubject(appID).
                setIssuedAt(now).
                setIssuer("Online YAuth Builder").
                setExpiration(expireDate).
                signWith(SignatureAlgorithm.HS256,"ZEUSILOVEZEUSZEUSHASMANSONSAUTHORZEUSILOVEZEUSZEUSHASMANSONSAUTHORv1").
                compact();
    }
    private String createEncodePassword(String appSecret) {
        ////获取当前时间
        //Date now = new Date(System.currentTimeMillis());
        //Date expireDate = new Date(now.getTime()+7200000);
        return Jwts.builder().
                setSubject(appSecret).
                signWith(SignatureAlgorithm.HS256,"ZEUSILOVEZEUSZEUSHASMANSONSAUTHORZEUSILOVEZEUSZEUSHASMANSONSAUTHORv1").
                compact();
    }
    private String createDecodePassword(String appSecret) {
        ////获取当前时间
        //Date now = new Date(System.currentTimeMillis());
        //Date expireDate = new Date(now.getTime()+7200000);
        return Jwts.parser().parse(appSecret).toString();
                //setSubject(appSecret).
                //signWith(SignatureAlgorithm.HS256,"ZEUSILOVEZEUSZEUSHASMANSONSAUTHORZEUSILOVEZEUSZEUSHASMANSONSAUTHORv1").
                //compact();
    }
    @RequestMapping(value="/savetoken",method = RequestMethod.POST)
    public TokenResult tokenSave(@RequestParam String appID){
        TokenResult tokenResult  = new TokenResult();
        if (appID==null||appID.isEmpty()){
            tokenResult.setFlag(false);
            tokenResult.setMsg("appID is not found");
        }else {
            String tokenStr = createNewToken(appID);
            TokenInfoEntity tokenInfo = new TokenInfoEntity();
            tokenInfo.setAppId(appID);
            tokenInfo.setBuildTime(String.valueOf(System.currentTimeMillis()));
            tokenInfo.setToken(tokenStr.getBytes());
            tokenJPA.save(tokenInfo);
            tokenResult.setFlag(true);
            tokenResult.setToken(String.valueOf(tokenInfo.getToken()));
        }

        return tokenResult;
    }
    @RequestMapping(value="/userSave",method = RequestMethod.POST)
    public TokenResult userSave(@RequestParam String appID,@RequestParam String appSecret){
        TokenResult tokenResult  = new TokenResult();
        if (appID==null||appID.isEmpty()){
            tokenResult.setFlag(false);
            tokenResult.setMsg("appID is not found");
        }else {
            String tokenStr = createEncodePassword(appSecret);
            UserInfoEntity userInfo = new UserInfoEntity();
            userInfo.setAppID(appID);
            userInfo.setAppSecret(tokenStr.getBytes());
            userInfoJPA.save(userInfo);
            tokenResult.setFlag(true);
            tokenResult.setToken(String.valueOf(userInfo.getAppSecret()));
        }

        return tokenResult;
    }
}
