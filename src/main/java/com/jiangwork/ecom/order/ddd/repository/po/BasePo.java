package com.jiangwork.ecom.order.ddd.repository.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jiangwork.ecom.order.utils.JsonUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jiangzhao on 2020-10-25 15:13.
 */
@MappedSuperclass
public class BasePo {

    @Column(name = "mod_time", nullable = false)
    protected LocalDateTime modTime;
    @Column(name = "add_time", nullable = false)
    protected LocalDateTime addTime;

    @Version
    private Integer version = 0;

    /**
     * deleted 是否删除 删除1  未删除0
     */
    @Column(name = "deleted", nullable = false, columnDefinition = "TINYINT")
    private Integer deleted;


    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        modTime = LocalDateTime.now();
        if (addTime == null) {
            addTime = LocalDateTime.now();
        }
        if (deleted == null) {
            deleted = 0;
        }
    }

    @Override
    public String toString() {
        return JsonUtils.to(this);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getModTime() {
        return modTime;
    }

    public void setModTime(LocalDateTime modTime) {
        this.modTime = modTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
