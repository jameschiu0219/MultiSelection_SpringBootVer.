package hw.multiselection.Controller;

import hw.multiselection.Model.Product;
import hw.multiselection.Repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*接收前端傳過來的 Http request，並且去驗證請求參數進行處理，並根據Model處理結果向用戶提供相應的回應*/

/*RestController把你回傳的字串當作「純文字」或 JSON 輸出，而不是當成 Thymeleaf 要找的 HTML 檔案名稱，所以會404*/
@Controller
public class ProductController {
    @Autowired    //依賴注入(多型)
    private ProductRepository repository;

    @GetMapping("/")
    public String index() {
        return "index";     // 對應到 templates/index.html
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        // Model 是模板資料的容器，用 (key, value) 形式儲存
        // 其內的值會被賦予到 Thymeleaf 執行環境
        List<Product> products = repository.searchByKeyword(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "result";        // 對應到 templates/result.html
    }
//    @GetMapping("/test")
//    public String test() {
//        return "測試成功";
//    }
}

