package com.zwd.area.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class TaskPoolConfig {
    //    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();   // CPU密集型
    private static final int CORE_POOL_SIZE = 8;  // IO密集型
    private static final int MAX_POOL_SIZE = 20;
    private static final int KEEP_ALIVE_TIME = 10; //允许线程空闲时间（单位为秒）
    private static final int QUEUE_CAPACITY = 200; // 缓冲队列数
    private static final int AWAIT_TERMINATION = 60;//线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁
    private static final Boolean WAIT_FOR_TASKS_TO_COMPLETE_ON_SHUTDOWN = true;//用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
    private static final String THREAD_NAME_PREFIX = "PiceaAsync-Service-"; // 线程池名前缀

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor piceaTaskExecutor () {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        taskExecutor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(WAIT_FOR_TASKS_TO_COMPLETE_ON_SHUTDOWN);
        taskExecutor.setAwaitTerminationSeconds(AWAIT_TERMINATION);
        // 线程池对拒绝任务的处理策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        taskExecutor.initialize();
        return taskExecutor;
    }
}
