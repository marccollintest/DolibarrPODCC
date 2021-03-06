Feature: Gestion des tiers

Background:
Given un navigateur est démaré
And Je suis sur la page de login
And Je connecte en "admin" et "admin"
And je cliclk sur Tiers

Scenario Outline:  Création d'un client
Given je recherche "<Nom>"
	And je lis le nbre de clients "<Nom>"
	When  Je cree un client "<Nom>" , Ville "<Ville>"
	Then  le Nombre de clients est augmenté de 1
	And je ferme le navigateur

Examples:
|Nom|Ville|
|Marc|Rennes|

#Scenario Outline:  Modification d'un client
#Given le client "<Nom>" est créé
#	When  Je selectionne le client "<Nom>"
#	And je modifie la ville par "<ville>"
#	And je valide la page client
#	And Je selectionne le client "<Nom>"
#	Then la ville est "<ville>"
#	And je ferme le navigateur
#
#Examples:
#|Nom|Ville|
#|Marc|Nantes|
