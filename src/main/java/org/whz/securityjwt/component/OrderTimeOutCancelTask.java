package org.whz.securityjwt.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 订单超时取消并解锁库存的定时器
 */
@Slf4j
@Component
public class OrderTimeOutCancelTask {
    /**
     * cron表达式 Second Minutes Hours DayofMonth month
     * 每10分钟扫描一次 扫描设定超时时间之前下的订单 如果没有支付取消该订单
     */
    @Scheduled(cron = "0 0/1 * ? * ?")
    private void cancelTimeOutOrder() {
        log.info("取消订单, 并根据SKU编号释放锁定库存");
    }
}