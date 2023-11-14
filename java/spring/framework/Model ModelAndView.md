# Model/ModelAndView

## Model

> key, value로 이루어진 hashMap
> 

### 특징

Model의 `.addAttribute()` 를 통해 view에 전달할 데이터를 저장 

→  `request.setAttribute()` 와 비슷한 역할을 담당

Controller 메서드에서 Model이라는 타입의 객체를 파라미터로 받을 수 있다.

jsp Servlet에서 request, session 에 정보를 담아 jsp에게 넘겨줬는데 spring에서 model이 역할을 담당한다. 

jsp servlet

```java
request.setAttribute("time", new java.util.Date());
RequestDispatcher dispatcher = request.getRequestDispatcher("url");
dispatcher.forward(request, response);
```

spring model

```java
public String home (Model model) {
	model.addAttribute("time", new java.util.Date());
    return "home";
}
```

개발자는 직접 model을 생성할 필요는 없고 파라미터로 선언만 해주면 스프링이 알아서 만들어줌

### ✅ **parameter를 통해 전달**

@RequestMapping을 통해 매핑을 한 메서드의 파라미터로 Model 객체를 전달

```java
@RequestMapping("/modelTest")
public String modelFunc (@RequestParam username, Model model) {
  model.addAttribute("username", username); // username을 view에서 사용이 가능하다.
  return "modelResult"; 
}
```

### ✅ view 파일에서 model에 저장한 값 불러오기

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Test</h1>
	<h2>${username }</h2> controller에서 가져온 값
</body>
</html>
```

## ModelAndView

> 모델 데이터와 뷰 정보를 함께 캡슐화하는 객체
> 

```java
@Controller
@RequestMapping("/main")
public class BoardController {

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "홍길동");
        mav.setViewName("main/index");

        return mav;
    }

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();

        List<BoardDto> lists = boardService.getLists(start, end, searchKey, searchValue);
        mav.addObject("lists", list);
        mav.setViewName("main/index");

        return mav;
    }
}
```

@Controller를 사용하고 나서부터는 잘 사용하지않는 방식 

정확히는 @RequestMapping, @GetMapping, @PostMapping 등 메서드 레벨 어노테이션을 사용하는 방식이 표준이 되어서 이고 

@ResponseBody나 @RestController 어노테이션 사용이 보편화됨에 따라 구식이라 여겨짐

```java
@GetMapping("/modelTest")
public String modelFunc (Model model) {
  model.addAttribute("username", username); // username을 view에서 사용이 가능하다.
  return "modelResult"; // 뷰 이름을 직접 반환
}
```