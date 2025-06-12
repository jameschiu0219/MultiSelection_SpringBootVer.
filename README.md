商品查詢系統 - JSP + Servlet + JDBC
這是一個簡單的商品查詢系統，使用 MVC 架構 透過 JSP + Servlet + JDBC 建立，可以查詢商品名稱並顯示所有符合條件的商品。

專案結構

MultiSelection/
├── src/
│   └── main/
│       ├── java/
│       │   └── HW/multiSelection/
│       │       ├── Controller/
│       │       │   └── ProductController.java
│       │       ├── Model/
│       │       │   └── Product.java
│       │       ├── Repository/
│       │       │   └── ProductRepository.java
│       │       └── MultiSelectionApplication.java
│       └── resources/
│           ├── templates/
│           │   ├── index.html
│           │   └── result.html
│           └── application.properties
├── pom.xml
