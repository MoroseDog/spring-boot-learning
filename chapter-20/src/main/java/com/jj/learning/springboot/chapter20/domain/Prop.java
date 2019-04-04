package com.jj.learning.springboot.chapter20.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Prop {

    @NotNull(message = "pid不能為空")
    @Min(value = 1, message = "pid必須為正整數")
    private Long pid;

    @NotNull(message = "vid不能為空")
    @Min(value = 1, message = "vid必須為正整數")
    private Long vid;

    @NotBlank(message = "pidName不能為空")
    private String pidName;

    @NotBlank(message = "vidName不能為空")
    private String vidName;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getPidName() {
        return pidName;
    }

    public void setPidName(String pidName) {
        this.pidName = pidName;
    }

    public String getVidName() {
        return vidName;
    }

    public void setVidName(String vidName) {
        this.vidName = vidName;
    }

}
