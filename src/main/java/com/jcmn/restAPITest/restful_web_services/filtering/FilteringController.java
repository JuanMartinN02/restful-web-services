package com.jcmn.restAPITest.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"), new SomeBean("value7", "value8", "value9"));
    }

    // For dynamic filtering (with views)

    @GetMapping("/filtering-with-views")
    @JsonView(View.view1.class)//field1 and field3
    public SomeBean filteringViews(){
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list-with-views") //field2 and field3
    @JsonView(View.view2.class)
    public List<SomeBean> filteringListViews(){
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"), new SomeBean("value7", "value8", "value9"));
    }


}
