package app;

import static spark.Spark.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import service.FilmesService;

public class Main {
    private static FilmesService filmeService = new FilmesService();
    public static void main(String[] args) {
        port(4567);
        get("/", (request, response) -> {
            response.type("text/html"); 
            return renderHTMLForm();
        });

        // Rota para criar um novo filme
        post("/filmes", (request, response) -> filmeService.add(request, response));

        // Rota para listar um único filme baseado no ID
        post("/filmes/get", (request, response) -> filmeService.get(request, response));

        // Rota para atualizar um filme existente
        post("/filmes/update", (request, response) -> filmeService.update(request, response));

        // Rota para remover um filme baseado no ID
        post("/filmes/delete", (request, response) -> filmeService.remove(request, response));

        // Rota para listar todos os filmes
        post("/filmes/all", (request, response) -> filmeService.getAll(request, response));
    }
    private static String renderHTMLForm() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/main/resources/formulario.html")));
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao carregar o formulário.";
        }
    }
}
