# TeacherMeet

Pour une raison que j'ignore et pour laquelle je me suis arraché les cheveux, il est impossible de lier les classes entre elles.
Le code me semble correcte et lors du debug l'ensemble est bien construit (Les objets possèdent bien leur champs remplis) mais une fois sortie de la méthode BookAMeet,
il semble que la persistence des données ne se fasse pas.

J'ai remué le problème dans tous les sens et j'ai essayé de creuser du côté du mapping relationnel mais je n'ai trouvé aucune solution, donc malheuresement la fonctionnalité majeur n'est pas fonctionnelle...
J'ai utilisé une base MySql au lieu d'une base H2 (que j'utilise d'habitude) alors peut être que c'est des spécificités particulières de ce côté là qui bloquent.

Je suis pas vraiment satisfait de ne pas réussir à résoudre ça et livrer un projet qui n'a finalement pas sa fonctionnalité principale mais la deadline m'empâche de continuer
et j'ai peut être manqué d'organisation entre tous mes projets à côté (j'ai sous estimé la probabilité d'avoir une erreur de ce type qui me bloque pendant plusieurs jours.

Le reste du contrat est cependant remplie, j'utilise Postman pour faire mes requêtes et la doc Swagger est bien générée.
