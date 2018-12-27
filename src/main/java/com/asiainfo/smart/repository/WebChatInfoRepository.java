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
    @Query(value = "select w.* from ST_SMART_WEBCHAT_UNBUNDL_HM w where not exists (select chg_sn from ST_SMART_WEBCHAT_UNBUNDL_SEND where stat_Hour = :hour) and stat_Hour = :hour and send_flag=0", nativeQuery = true)
    List<WebChatInfo> getTransList(@Param("hour") String hour);

    /**
     *  获取上一天未同步的数据
     * @param day
     * @return
     */
    @Query(value = "select w.* from ST_SMART_WEBCHAT_UNBUNDL_HM w where not exists (select chg_sn from ST_SMART_WEBCHAT_UNBUNDL_SEND where stat_day = :day) and stat_day = :day and send_flag=0", nativeQuery = true)
    List<WebChatInfo> getDayTransList(@Param("day") String day);

    /**
     *  获取上一天未同步的数据
     * @param day
     * @return
     */
    @Query(value = "select w.* from ST_SMART_WEBCHAT_UNBUNDL_HM w where not exists (select chg_sn from ST_SMART_WEBCHAT_UNBUNDL_SEND ) and send_flag=0", nativeQuery = true)
    List<WebChatInfo> getAllTransList();
}
