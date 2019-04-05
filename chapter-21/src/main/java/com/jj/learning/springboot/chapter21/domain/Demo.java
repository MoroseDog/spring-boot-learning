package com.jj.learning.springboot.chapter21.domain;

import com.jj.learning.springboot.chapter21.valid.TestValidation;

public class Demo {

    @TestValidation(message = "version只能為1.0", value = "1.0")
    String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
