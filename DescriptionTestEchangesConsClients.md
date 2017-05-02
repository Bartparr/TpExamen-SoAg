## Auteur : PARROT Barthelemy, SAMAKE Fatou, LAANGRY Hayat.

## **Titre : Description des tests d'échange de messages entre client et conseiller**

## Fonctionnalité 1 : la création d'un message vide.

### Etape rouge : Définir la fonctionnalité

1 : Création de la Classe `EchangeMessage`.

3 : Nous commençons par écrire un test pour définir la fonctionnalité sans écrire de code d'implémentation.

4 : Execution du test et on constate qu'il échoue (le test ne compile pas).

### Etape verte : Définir l'implémentation

5 : Implémentation pour faire valider le test (Création des classes, interfaces et méthodes manquantes).

6 : On contrôle que les tests passent désormais.

### Refactor : Simplifier le code

7 : Ajout d'une méthode de test et du minimum d'implémentation.

8 : Optimisation du code (Ceci peut être par exemple de factoriser du code dupliqué, de simplifier des boucles de traitement ou les conditions des tests. Par contre il ne s'agit pas de réécrire toute l'implémentation existante.)


## Fonctionnalité 2 : l'ajout d'un message avec l'expéditeur et le destinataire'.

### Etape rouge : Définir la fonctionnalité

1 : Création de la Classe `Message` avec l'expéditeur et le destinataire.

3 : Nous commençons par écrire un test pour définir la fonctionnalité sans écrire de code d'implémentation.

4 : Execution du test avec un person_Advisor_Id qui n'existe pas et on constate qu'il échoue (le test ne compile pas).

### Etape verte : Définir l'implémentation

5 : Implémentation pour faire valider le test (Création des classes, interfaces et méthodes manquantes).

6 : On contrôle que les tests passent désormais avec des person_Advisor_Id qui existent ou des person_Id qui existent.

### Refactor : Simplifier le code

7 : Ajout d'une méthode de test et du minimum d'implémentation

8 : Optimisation du code (Ceci peut être par exemple de factoriser du code dupliqué, de simplifier des boucles de traitement ou les conditions des tests. Par contre il ne s'agit pas de réécrire toute l'implémentation existante.)
