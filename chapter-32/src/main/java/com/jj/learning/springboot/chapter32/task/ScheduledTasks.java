package com.jj.learning.springboot.chapter32.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 自動掃瞄，每五秒執行一次
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("當前時間：" + dateFormat.format(new Date()));
    }

}
