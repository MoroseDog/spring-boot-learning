package com.jj.learning.springboot.chapter20.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jj.learning.springboot.chapter20.domain.Item;
import com.jj.learning.springboot.chapter20.domain.Prop;

@RestController
public class ItemController {

    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    public void addItem(@RequestBody @Validated Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList) {
                System.out.println(error.getDefaultMessage());
            }
        }
    }

    /**
     * 產生Jons格式的參數 2019年4月4日
     * 
     * @param args {"id":1,"props":[{"pid":2,"vid":3,"pidName":"Test1","vidName":"Test2"}]}
     */
    public static void main(String[] args) {
        Item item = new Item();
        Prop prop = new Prop();
        List<Prop> props = new ArrayList<Prop>();
        item.setId(1L);

        prop.setPid(2L);
        prop.setPidName("Test1");

        prop.setVid(3L);
        prop.setVidName("Test2");
        props.add(prop);

        item.setProps(props);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(item);
            System.out.println(jsonInString);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
