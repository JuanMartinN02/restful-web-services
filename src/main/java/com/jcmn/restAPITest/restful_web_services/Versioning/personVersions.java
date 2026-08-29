package com.jcmn.restAPITest.restful_web_services.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personVersions {

    // Spring Versioning (path)
    @GetMapping(value = "/{version}/personbi", version = "1.0.0")
    public Person1 getFirstVersion(){
        return (new Person1("Jose Alvarez"));
    }

    @GetMapping(value = "/{version}/personbi", version = "2.0.0")
    public Person2 getSecondVersion(){
        return (new Person2("Jose", "Alvarez"));
    }

    // Spring Versioning (parameter) USE THIS
    @GetMapping(value = "/personbi", version = "1.0.0")
    public Person1 getFirstVersionParam(){
        return (new Person1("Jose Alvarez"));
    }

    @GetMapping(value = "/personbi", version = "2.0.0")
    public Person2 getSecondVersionParam(){
        return (new Person2("Jose", "Alvarez"));
    }

    // URI Versioning (Twitter)

    @GetMapping("/v1/person")
    public Person1 getFirstVersionPerson(){
        return (new Person1("Jose Alvarez"));
    }

    @GetMapping("/v2/person")
    public Person2 getSecondVersionPerson(){
        return (new Person2("Jose", "Alvarez"));
    }

    // Param Versioning (Amazon)

    @GetMapping(value = "/person", params = "version=1")
    public Person1 getVersionPerson1Param(){
        return (new Person1("Jose Alvarez"));
    }

    @GetMapping(value = "/person", params = "version=2")
    public Person2 getVersionPerson2Param(){
        return (new Person2("Jose", "Alvarez"));
    }

    // Header Versioning (Microsoft)

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public Person1 getVersionPerson1Header(){
        return (new Person1("Jose Alvarez"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public Person2 getVersionPerson2Header(){
        return (new Person2("Jose", "Alvarez"));
    }

}
