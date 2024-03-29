- Model View Controller 로 구분하여 더욱 더 효율적인 개발을 위한 디자인 패턴

 1. View에서 받은 사용자의 (입력) input을 Controller에게 넘긴다
 2. Controller에선 받은 input에 맞는 Model을 호출한다.
 3. Model에서 DB의 데이터를 호출하거나 데이터를 처리 후 Controller에게 다시 넘긴다.
 4. Controller는 받은 값을 View에게 다시 전달한다.
 5. View는 그 값을 사용자에게 보여준다.
-
 ## Model
- 데이터및 핵심 로직을 관리한다.
-
 ### 특징
- 1. DB와의 상호작용
- 2. 데이터 처리 및 가공
- 3. 비지니스 룰을 담당

-
- 데이터의 독립성을 유지, ,View, Controller와 상호작용
-
 ## View
- 클라이언트에게 보여지는 UI
- 정보, 입력을 받는 부분(HTML, CSS)
-
 ### 특징
- 사용자의 입력을 Controller에게 보낸다.
- Model과 직접적인 상호작용을 하지 않는다.
-
 ## Controller
- View와 Model사이에서 상호작용을 조정한다.
-
 ### 특징
- 사용자의 요청을 이해한다.
- Model의 데이터 처리 결과를 View에게 전달한다.
- 애플리케이션의 흐름을 제어하여 유지보수와 확장성을 높힌다.
-
