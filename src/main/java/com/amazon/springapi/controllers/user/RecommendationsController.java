package com.amazon.springapi.controllers.user;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class RecommendationsController {

    @GetMapping("/api/private/user_recommendations")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", example = "Bearer access_token")
    )
    public List fetchRecommendations(){
        return new ArrayList(
                Arrays.asList(
                        Arrays.asList("Your Orders","https://images-na.ssl-images-amazon.com/images/G/01/amazonglobal/images/email/asins/DURM-2307572AF7CDC91G._V535755378_.jpg"),
                        Arrays.asList("Electronics","https://m.media-amazon.com/images/I/31i3tpuXxxL._AC_SY200_.jpg"),
                        Arrays.asList("Computer & Accessories", "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_PC_1x._SY304_CB431800965_.jpg"),
                        Arrays.asList("Home & Kitchen","https://cdn.pixabay.com/photo/2012/04/12/12/38/microwave-29850_960_720.png")
                )
        );
    }

}
