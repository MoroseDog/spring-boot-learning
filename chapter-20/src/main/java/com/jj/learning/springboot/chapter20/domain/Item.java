package com.jj.learning.springboot.chapter20.domain;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Item {

    @NotNull(message = "id不能為空")
    @Min(value = 1, message = "id必須為正整數")
    private Long id;

    @NotNull(message = "props不能為空")
    @Size(min = 1, message = "至少要有一個屬性")
    @Valid
    private List<Prop> props;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Prop> getProps() {
        return props;
    }

    public void setProps(List<Prop> props) {
        this.props = props;
    }

}
