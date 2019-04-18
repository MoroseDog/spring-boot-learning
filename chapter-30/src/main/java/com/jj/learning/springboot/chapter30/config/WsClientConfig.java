package com.jj.learning.springboot.chapter30.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.jj.learning.springboot.chapter30.client.WsAuthorClient;

@Configuration
public class WsClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // 會掃描此類下面的對應的 jaxb2實體類 因為是使用 Marshaller和 unmarshaller來進行xml和bean直接轉換的
        // 具體是判斷此路徑下是否包含 ObjectFactory.class 文件
        // 設置 JAXBContext 對象
        marshaller.setContextPath("com.jj.webservice");
        // 或者使用 以下方式設置
        // marshaller.setPackagesToScan(packagesToScan);
        // marshaller.setClassesToBeBound(classesToBeBound);
        return marshaller;
    }

    @Bean
    public WsAuthorClient wsClient(Jaxb2Marshaller marshaller) {
        WsAuthorClient client = new WsAuthorClient();
        // 默認對應的ws服務地址 client請求中還能動態修改的
        client.setDefaultUri("http://127.0.0.1:8080/ws");
        client.setMarshaller(marshaller);// 指定轉換類
        client.setUnmarshaller(marshaller);
        return client;
    }

}