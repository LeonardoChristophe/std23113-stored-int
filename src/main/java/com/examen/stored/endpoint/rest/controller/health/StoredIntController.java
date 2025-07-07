package com.examen.stored.endpoint.rest.controller.health;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@RestController
public class StoredIntController {
    private static final String FILE_PATH = "/tmp/stored-int.txt"; // Dossier temporaire AWS Lambda
  @GetMapping("/stored-int")
  public int getStoredInt() throws IOException {
      Path path = Paths.get(FILE_PATH);

      // a) Si le fichier existe, lire son contenu
      if (Files.exists(path)) {
          String content = Files.readString(path);
          return Integer.parseInt(content.trim());
      }
          // b) Sinon, créer le fichier avec un nombre aléatoire
        else {
              int randomNumber = new Random().nextInt(1000); // Nombre entre 0 et 999
              Files.writeString(path, String.valueOf(randomNumber));
              return randomNumber;
          }
      }
  }
