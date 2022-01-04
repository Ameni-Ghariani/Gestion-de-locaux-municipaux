# Gestion-de-locaux-municipaux
Projet conception et développement d'une application de gestion de locaux municipaux 

<h2>La gestion de locaux municipaux</h2>

Une commune importante informatise la gestion de ses salles de réunions et de spectacles. En
particulier, elle souhaite mettre un système de réservation par internet. Par ailleurs, celui-ci doit
permettre d’assurer la sécurité des données lors de leur transmission. En plus, il doit avoir une
ergonomie favorisant des présentations claires des différentes interfaces et des formulaires
simples et faciles à remplir. Le but de ce logiciel étant de faciliter le travail des utilisateurs lors
de la réservation des salles et de mettre à jour le système en temps réel.
Les salles font partie de bâtiments municipaux. Un bâtiment se trouve à une adresse donnée. Il
contient un certain nombre de salles. Dans un bâtiment, chaque salle est identifiée par un
numéro dont la longueur doit être comprise entre 3 et 6 chiffres.
Deux salles de deux bâtiments différents peuvent avoir le même numéro. Pour chaque salle on
connaît son équipement (sono, vidéoprojecteur, cuisine, etc.). Les tarifs de location varient en
fonction de :
  - a plage horaire demandée, parmi les 3 possibilités : demi-journée, journée, soirée. 
  - la superficie 
  - et l’équipement de la salle (une salle est toujours louée avec tout son équipement).
  
  Le système doit permettre d’enregistrer les demandeurs, d’effectuer les réservations, de les
annuler, de fournir des plannings d’occupation, d’émettre des factures qui seront envoyées aux
occupants et d’enregistrer leurs versements.
Seules les personnes enregistrées dans le système peuvent émettre ou annuler des réservations.
Un nouveau demandeur doit s’enregistrer en fournissant son nom et son adresse au système. Le
système lui fournit alors un code unique qui lui permettra d’effectuer les opérations relatives
aux réservations.
Une réservation est faite par un utilisateur enregistré au système. Au moment de la réservation,
le demandeur précise son code, l’adresse et le numéro de la salle souhaitée, une date et une
2
plage horaire comme ci-dessus. Il obtient en retour un numéro de réservation et un prix ou un
refus.
Une annulation est faite par le demandeur qui a fait la réservation. Il s’identifie et donne le
numéro de la réservation qu’il annule. Les réservations annulées ne sont pas conservées dans
les plannings ou dans le système. On ne peut bien sûr pas annuler une réservation déjà passée.
Le système fournit à la demande aux employés municipaux ou aux usagers le planning
d’occupation des salles pour un jour donné. Pour le jour en question, le planning indique les
réservations prévues (bâtiment et salle). Cela permet aux demandeurs de connaître les salles
disponibles et aux employés municipaux de savoir quelles salles il faut ouvrir et préparer ce
jour-là, pour quelles périodes.
Périodiquement, le système imprime les factures de toutes les réservations accomplies et non
encore facturées, de façon qu’elles puissent être envoyées aux occupants. Le système émet aussi
une lettre de relance pour les factures émises et non encore payées. Les réservations payées sont
conservées dans le système. A réception d’un paiement, un employé municipal enregistre dans
le système le fait que la facture correspondante a été réglée.
Le principal bénéfice que pourra en tirer l’utilisateur se situe au niveau de la rapidité
d’exécution des tâches répétitives et fastidieuses telles que la réservation de salles (faite de
façon manuelle) et la gestion des factures.

<h3>Questions :</h3>

1. Dégager de l’énoncé les besoins non fonctionnels relatifs au système considéré.
2. Dégager de l’énoncé les besoins fonctionnels relatifs au système considéré sous forme
d’un diagramme de cas d’utilisation. 
3. Proposer un diagramme de classes (en précisant toutes les propriétés et toutes les
relations) pour ce système.
4. Implémenter le modèle relationnel (BD) du module « réservation de salles » et
développer en Java quelques méthodes de ce module. 
5. Réaliser le test unitaire de quelques méthodes déjà développées du module
« réservation de salles » en utilisant JUnit
