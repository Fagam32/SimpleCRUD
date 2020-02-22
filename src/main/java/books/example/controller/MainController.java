package books.example.controller;

import books.example.model.Book;
import books.example.repos.BooksRepo;
import books.example.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    BooksRepo booksRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Book> books = booksRepo.findAll();
        model.put("books", books);
        return "main";
    }

    @PostMapping("add")
    @Transactional
    public String add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "author") String author,
                      Map<String, Object> model) {
        Book book = new Book(name, author);
        booksRepo.save(book);
        Iterable<Book> books = booksRepo.findAll();
        model.put("books", books);
        return "main";
    }

    @PostMapping("delete")
    @Transactional
    public String delete(@RequestParam(name = "name") String name,
                         Map<String, Object> model) {
        booksRepo.deleteBookByNameStartingWith(name);
        Iterable<Book> books = booksRepo.findAll();
        model.put("books", books);
        return "main";
    }
}