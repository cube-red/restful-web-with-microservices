package com.aditya.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersion(){
        return new PersonV1("Aditya Bondre");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersion(){
        return new PersonV2(new Name("aditya","bondre"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionWithParameter(){
        return new PersonV1("Aditya Bondre");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionWtihParameter(){
        return new PersonV2(new Name("aditya","bondre"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION = 1")
    public PersonV1 getFirstPersonWithHeader(){
        return new PersonV1("Aditya Bondre");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION = 2")
    public PersonV2 getSecondPersonWithHeader(){
        return new PersonV2(new Name("aditya","bondre"));
    }





 }
