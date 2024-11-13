# Tache #3

**Samuel Argeris - Farley Jeannis**



## Configuration

Afin de pouvoir tester l'impact de chaque « flag » individuellement, nous avons utilisé la fonctionnalité de « matrix » pour construire les « builds » avec une version spécifique de java et les exécuter en parallèle.
```yaml
matrix:
    java-version: [ 22 ]
    jvm-flags: ["-XX:MaxInlineSize=128", "-Xms128m -Xmx512m", "-XX:+UseParallelGC", "-XX:CICompilerCount=4", "-XX:+UseCompressedOops"]
```

## Choix des Flags

1. **`-XX:MaxInlineSize=128`**
   - **Fonction**: Taille maximale de méthode pour l'inlining
   - **Justification du choix**: Nous avons défini cette taille maximale d'inlining à 128 octets pour permettre l'insertion de méthodes légèrement plus grandes directement dans le code. Ceci réduit les appels de méthode, ce qui améliore la vitesse de l'éxécution du code.

2. **`-Xms128m et -Xmx512m`**
   - **Fonction**: Taille initiale de la heap et Taille maximale de la heap
   - **Justification du choix**: Premièrement, nous définissons la taille initiale de la heap(128 Mo) afin d'améliorer les performances initiales en évitant que la JVM ait besoin à agrandir l'espace mémoire au démarrage. Deuxièmement nous définissons une taille maximale pour la heap(512 Mo) afin de limiter la consommation excessive de la mémoire.

3. **`-XX:+UseParallelGC`**
   - **Fonction*: Collecteur de mémoire parallèle
   - **Justification du choix**: Le Garbage Collector parallèle, permet d'améliorer le processus de collecte des objets non utilisés en utilisant plusieurs threads, ce qui est avantageux pour notre projet qui doit gérer plusieurs objets.

4. **`-XX:CICompilerCount=4`**
   - **Fonction**: Nombre de threads du compilateur
   - **Justification du choix**: Nous avons défini le nombre de threads du compilateur Just-In-Time (JIT) à 4 pour accélérer la compilation des méthodes. Ce paramètre optimise les performances de démarrage et le temps d'exécution pour notre projet qui comporte plusieurs méthodes

5. **`-XX:+UseCompressedOops`**
   - **Fonction**: Réduction de la taille des pointeurs d'objet
   - **Justification du choix**: En activant les OOPs compressés, nous réduisons la taille des pointeurs de référence en mémoire, ce qui utilise moins de mémoire. Ceci est très utilie pour notre projet qui gère une multitude d'objets différents.

### Aspect Humoristique

Lorsque le workflow termine sans erreur, il est possible d'aller à une page html avec une image gif en guise de célébration.
<img width="694" alt="image" src="https://github.com/user-attachments/assets/855a8196-e889-446b-ab3e-52a1517360d1">
<img width="638" alt="image" src="https://github.com/user-attachments/assets/6568656d-e25b-4888-8ead-54ea8c84a282">



