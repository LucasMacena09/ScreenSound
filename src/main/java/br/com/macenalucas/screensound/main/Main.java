package br.com.macenalucas.screensound.main;

import br.com.macenalucas.screensound.model.Artist;
import br.com.macenalucas.screensound.model.ArtistType;
import br.com.macenalucas.screensound.model.Music;
import br.com.macenalucas.screensound.repository.ArtistRepository;
import br.com.macenalucas.screensound.service.OpenAIService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private final ArtistRepository repository;
    Scanner scanner = new Scanner(System.in);

    public Main(ArtistRepository repository) {
        this.repository = repository;
    }

    public void displayMenu() {
        var option = -1;

        while (option != 9) {
            var menu = """
                    *** Screen Sound Músicas ***
                    
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    
                    9 - Sair
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Digite o nome do artista: ");
        var name = scanner.nextLine();
        List<Music> musics = repository.findMusicsByArtist(name);
        musics.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Artist> artists = repository.findAll();
        artists.forEach(a -> a.getMusics().forEach(System.out::println));
    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de que artista? ");
        var name = scanner.nextLine();
        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(name);
        if(artist.isPresent()) {
            System.out.println("Informe o título da musica: ");
            var musicName = scanner.nextLine();
            Music music = new Music(musicName);
            music.setArtist(artist.get());
            artist.get().getMusics().add(music);
            repository.save(artist.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void cadastrarArtistas() {
        var newArtist = "S";

        while(newArtist.equalsIgnoreCase("S")) {
            System.out.println("Informe o nome desse artista: ");
            var name = scanner.nextLine();
            System.out.println("Informe o tipo do artista: (solo, dupla ou banda)");
            var type = scanner.nextLine();
            ArtistType artistType = ArtistType.valueOf(type.toUpperCase());
            Artist artist = new Artist(name, artistType);
            repository.save(artist);
            System.out.println("Cadastrar novo artista? (S/N)");
            newArtist = scanner.nextLine();
        }
    }
}
