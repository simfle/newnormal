package com.chyun.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AgentService {
    private static final Logger LOGGER = LogManager.getLogger(AgentService.class);
    private static final ExecutorService execService = Executors.newCachedThreadPool();
    private static boolean runProcessing = true;

    public static void execute() {
        for (int i = 0; i <= 3; i++) {
            //execService.execute(new MockAgent(i));
        }
    }

    public static void main(String[] args) {
        Runnable scheduleMonitor = new AgentService.SchedulerMonitor();
        Thread taskMonitor = new Thread(scheduleMonitor);
        taskMonitor.start();
    }

    //여기서는 해당 메소드 호출만 진행 하면 될것 같다.
    private static class SchedulerMonitor implements Runnable {
        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public void run() {
            LOGGER.info("## EppAgent::Monitoring Run : {}", Thread.currentThread().getId());
            while (runProcessing) {
                try {
                    Thread.sleep(1000);
                    LOGGER.info("## EppAgent::Monitoring Time Now : {}", simpleDateFormat.format(System.currentTimeMillis()));
                    if (LocalDateTime.now().getSecond() == 30) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
