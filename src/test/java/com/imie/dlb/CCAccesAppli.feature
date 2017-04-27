Feature: Accès à l'application

Background:
Given un navigateur est démaré

Scenario Outline:  Connexion a l'application
Given Je suis sur la page de login
	When  Je connecte en "<user>" et "<password>"
	Then  La page affichée est la page d'acccueil
	And  L'utilisateur connecté est "<user>"
	And je ferme le navigateur

Examples:
|user|password|
|admin|admin|
|test|test|

Scenario Outline:  Connexion a l'application avec un utilisateur inconnu
Given Je suis sur la page de login
	When  Je connecte en "<user>" et "<password>"
	Then  La page affichée est la page de login
	And  un message d'erreur est affiché
	And je ferme le navigateur

Examples:
|user|password|
|admin|rien|
|rien|test|
|rien|rien|