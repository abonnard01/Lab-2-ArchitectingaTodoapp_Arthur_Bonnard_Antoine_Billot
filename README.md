# 📝 TODO App - Hexagonal Architecture

Cette application est un gestionnaire de tâches en ligne de commande, écrit en Java avec une architecture hexagonale (ports & adaptateurs) et un stockage en fichier CSV.

---

## 📂 Structure

```
├── domain
│   ├── model            # Entités métier (ex: Todo)
│   └── port             # Interfaces (ports) pour la persistance
├── application
│   └── service          # Cas d’usage (logique métier)
├── adapters
│   ├── inbound/console  # Interface utilisateur (console)
│   └── outbound         # Persistance (ex: CSV)
└── Main.java            # Point d’entrée
```

---

## ▶️ Lancer l’application

```bash
# Compiler
javac -d out $(find src -name "*.java")

# Lancer
java -cp out org.isep.cleancode.Main
```

---

## 🧪 Fonctionnalités

- Ajouter une tâche
- Lister toutes les tâches
- Marquer une tâche comme faite
- Sauvegarde automatique en `todos.csv`

---

## 🧼 Principes respectés

- Clean Code (SOLID, SRP, DRY)
- Architecture Hexagonale
- Dépendance inversée (via ports)
- Faible couplage entre UI, logique et persistance

---

## 👨‍💻 Auteur

> Projet ISEP Clean Code - 2025  
> Par [Votre nom]