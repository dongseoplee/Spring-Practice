package hello.hellospring.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") //http://localhost:8080/hello 여기로 Mapping
    // index.html에 <a href="/hello">hello</a> 이 앵커 태그가 있음
    //MVC -> Model, View, Controller
    public String hello(Model model) {

        model.addAttribute("data", "hello 9자Dragon!! (attributeValue 값!)");
        return "hello"; //return hello의 의미는 resources/templates의 hello.html로 가서 렌더링해라 윗줄의 model을 같이 hello.html로 넘겨줌
    }

    @GetMapping("hello-mvc") //http://localhost:8080/hello-mvc 여기로 Mapping
    public String helloMvc(@RequestParam("name") String name, Model model) { //http://localhost:8080/hello-mvc?name=spring!
        model.addAttribute("name", name);
        return "hello-template"; //return hello-template의 의미는 resources/templates의 hello-template.html로 가서 렌더링해라 윗줄의 model을 같이 hello.html로 넘겨줌
    }
}
