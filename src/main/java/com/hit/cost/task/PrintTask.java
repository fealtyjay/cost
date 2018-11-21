package com.hit.cost.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/11/20 15:37
 * <p>
 * Created By IDEA
 * ==========================
 */
@Component
public class PrintTask {
    /**
     * 该属性的含义是上一个调用开始后再次调用的延时（不用等待上一次调用完成），
     * 这样就会存在重复执行的问题，所以不是建议使用，
     * 但数据量如果不大时在配置的间隔时间内可以执行完也是可以使用的
     * @throws Exception
     */
    //@Scheduled(fixedRate = 1000*1)

    /**
     * 该属性的功效与上面的fixedRate则是相反的，
     * 配置了该属性后会等到方法执行完成后延迟配置的时间再次执行该方法
     * @throws Exception
     */
    @Scheduled(fixedDelay = 2000*1)
    public  void cron() throws Exception{
        Thread.sleep(5000);
     System.out.println("执行测试cron时间:"+new Date(System.currentTimeMillis()));
    }
}
