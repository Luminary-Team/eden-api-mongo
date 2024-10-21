package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.Database.Forum;
import com.luminary.apiedenmongo.Services.ForumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
@Tag(name = "Forum", description = "Operações relacionadas aos fóruns.")
public class ForumController {

    private final ForumService forumService;

    @Operation(summary = "Obter todos os fóruns", description = "Retorna uma lista de todos os fóruns.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de fóruns retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public List<Forum> getAllForums() {
        return forumService.getAllForums();
    }

    @Operation(summary = "Obter fórum por ID", description = "Retorna um fórum específico pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fórum retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Fórum não encontrado")
    })
    @GetMapping("/{id}")
    public Forum getForumById(@PathVariable String id) {
        return forumService.getForumById(id)
                .orElseThrow(() -> new RuntimeException("Fórum não encontrado"));
    }

    @PostMapping
    public Forum createForum(@RequestBody Forum forum) {
        return forumService.createForum(forum);
    }
}
