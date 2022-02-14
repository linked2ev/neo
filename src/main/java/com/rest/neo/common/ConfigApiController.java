package com.rest.neo.common;

import com.rest.neo.board.model.Board;
import com.rest.neo.config.CloudConfigService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/v2/api/common")
public class ConfigApiController {

    @Autowired
    public CloudConfigService cloudConfigService;

    @GetMapping
    public void getConfig(HttpServletRequest request) throws Exception {
        cloudConfigService.getConfig();
    }
}
