package com.mustache.bbs.controller;


import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles") //@getmapping에 중복을 줄인다
@Slf4j
public class ArticleController {

    //@Autowired = private final을 붙여 생성자를 들어오게 하는 방식을 많이 쓴다
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }
    @PostMapping(value = "/posts")
    public String createArticle(ArticleDto form) {
        // 실무에서 println 안씀 로그를 쓴다(서버에서 일어나는 일을 기록하는것)
        log.info(form.toString());
        Article article = form.toEntity();
        articleRepository.save(article);
        return "";
    }
}
