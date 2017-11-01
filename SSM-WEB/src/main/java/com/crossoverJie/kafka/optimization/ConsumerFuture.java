package com.crossoverJie.kafka.optimization;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/10/30 13:21
 * @since JDK 1.8
 */
public class ConsumerFuture {
    private Integer totalCount ;
    private Long TotalTime ;

    public ConsumerFuture(Integer totalCount, Long totalTime) {
        this.totalCount = totalCount;
        TotalTime = totalTime;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(Long totalTime) {
        TotalTime = totalTime;
    }
}
