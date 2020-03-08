package cn.spectrumrpc.springcloud;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/08
 */
public class SnowFlakeIdWorker {
    /**
     * 工作机器id（0-31）
     */
    private long workerId;
    /**
     * 数据中心id（0-31）
     */
    private long datacenterId;
    /**
     * 毫秒内序列（0-4095）
     */
    private long sequence = 0L;
    /**
     * 上次生成Id的时间戳
     */
    private long lastTimestamp = -1L;
    /**
     * 开始时间戳（2019-01-01）
     */
    private final long twepoch = 1420041600000L;
    /**
     * 机器id所占位数
     */
    private final long workerIdBits = 5L;
    /**
     * 数据标识id所占位数
     */
    private final long datacenterIdBits = 5L;




}
