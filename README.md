TODO App - Hexagonal Architecture

Cette application est un gestionnaire de tâches en ligne de commande, écrit en Java avec une architecture hexagonale (ports & adaptateurs) et un stockage en fichier CSV. Il permet de :
- Ajouter une tâche
- Lister toutes les tâches
- Marquer une tâche comme faite
- Sauvegarde automatique en `todos.csv`

Voila la structure du code. 
├── domain
│   ├── model            # Entités métier (ex: Todo)
│   └── port             # Interfaces (ports) pour la persistance
├── application
│   └── service          # Cas d’usage (logique métier)
├── adapters
│   ├── inbound/console  # Interface utilisateur (console)
│   └── outbound         # Persistance (ex: CSV)
└── Main.java            # Point d’entrée


Pour lancer l’application, il  faut saisir ces codes. 

```bash
# Compiler
javac -d out $(find src -name "*.java")

# Lancer
java -cp out org.isep.cleancode.Main
```


Projet de Arthur Bonnard et Antoine Billot
