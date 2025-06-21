import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CompteurDeMots {

    public static void main(String[] args) {
        // Définir le chemin du fichier à lire
        // J'ai défini le chemin d'accès du fichier txt
        String cheminFichier = "src/sample.txt"; // Par exemple, un fichier nommé sample.txt dans le même répertoire que le .jar exécutable ou le dossier du projet

        File file = new File(cheminFichier);
        int totalWordCount = 0;

        try {
            // Utiliser le lecteur de fichiers (File Scanner) pour lire le contenu
            Scanner fileScanner = new Scanner(file);

            System.out.println("Lecture du fichier : " + cheminFichier);

            // Créer une boucle qui lit chaque ligne
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Séparer la chaîne en utilisant le caractère espace comme délimiteur
                // "\\s+" correspond à un ou plusieurs espaces (incluant tabulations, etc.)
                // .trim() pour supprimer les espaces en début/fin de ligne
                String[] words = line.trim().split("\\s+");

                // Compter le nombre de mots dans cette ligne
                // Gérer le cas des lignes vides pour ne pas compter un tableau vide comme un mot
                if (words.length == 1 && words[0].isEmpty()) {
                    // C'était une ligne vide, ne pas ajouter de mots
                } else {
                    totalWordCount += words.length;
                }
            }

            // Afficher le nombre total de mots
            System.out.println("------------------------------------");
            System.out.println("Nombre total de mots dans le fichier : " + totalWordCount);

            fileScanner.close(); // Fermer le scanner du fichier
        } catch (FileNotFoundException e) {
            System.err.println("Erreur : Le fichier '" + cheminFichier + "' n'a pas été trouvé.");
            System.err.println("Veuillez vous assurer que le fichier existe et que le chemin est correct.");
        } catch (Exception e) {
            System.err.println("Une erreur inattendue est survenue : " + e.getMessage());
            e.printStackTrace();
        }
    }
}