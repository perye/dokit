package com.perye.dokit.utils.ip;

import com.alibaba.fastjson.JSONObject;
import com.perye.dokit.utils.StringUtils;
import com.perye.dokit.utils.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取地址类
 *
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/31
 */
public class AddressUtils {
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip) {
        String address = "未知";
        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
        if (StringUtils.isEmpty(rspStr)) {
            log.error("获取地理位置异常 {}" , ip);
            return address;
        }
        JSONObject obj = JSONObject.parseObject(rspStr);
        JSONObject data = obj.getObject("data" , JSONObject.class);
        String region = data.getString("region");
        String city = data.getString("city");
        String isp = data.getString("isp");
        address = region + " " + city + " " + isp;
        return address;
    }

}
