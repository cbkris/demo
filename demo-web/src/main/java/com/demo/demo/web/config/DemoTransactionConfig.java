package com.demo.demo.web.config;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by cb on 2017/3/31.
 */
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class DemoTransactionConfig {
}
