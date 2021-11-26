package stefanini.booksmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stefanini.booksmanager.domain.Fantasy;
import stefanini.booksmanager.service.FantasyService;

import java.io.IOException;

@RestController
@RequestMapping("/fantas")
public class FantasyController {

    @Autowired
    private FantasyService fantasyService;

    @GetMapping
    public Fantasy findFantasy(
            @RequestParam String title
    ) throws IOException, InterruptedException {
        return fantasyService.findFantasyByTitle(title);
    }
}
