package com.asiainfo.smart.repository;

import com.asiainfo.smart.entity.WebChatInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/14
 * @Description ${DESCRIPTION}
 */
public interface WebChatInfoRepository extends JpaRepository<WebChatInfo, String> {

    /**
     * 获取所有未同步的微信用户状态信息
     *
     * @param hour yyyyMMddHH
     * @return
     */
    @Query(value = "select w.* from ST_SMART_WEBCHAT_UNBUNDL_HM w where exists (select chg_sn from ST_SMART_WEBCHAT_UNBUNDL_SEND where stat_Hour = :hour) and stat_Hour = :hour", nativeQuery = true)
    List<WebChatInfo> getTransList(@Param("hour") String hour);
}
