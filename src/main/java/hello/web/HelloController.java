package hello.web;

import hello.domain.Foo;
import hello.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private FooService fooService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        for (Foo foo : fooService.findAll()) {
            System.out.println("foo: " + foo.getName());
        }
        return "hello";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(@RequestParam String name) {
        fooService.create(name);
        return "complete";
    }
}
