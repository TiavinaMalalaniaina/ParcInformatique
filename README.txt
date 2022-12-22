Nom: RAMIANDRISOA Tiavina Malalaniaina
Num: ETU002025

Fonctionalités:
	Server:
		Affichage du nombre d'appareil connecté au server
		Actualisation de la Frame via la touche CTRL
		Affichage: Nom de l'appareil, OS, Nom d'utilisateur, Ram max, Ram utilisée, AddressIP

	Client:
		Connection au server via le port et l'address IP
		Deconnection du server


Fonctionnement:
	Server:
		Lance un thread ConnectServer qui attend qu'un client se connecte, une fois connecté, un thread "Receiving" demarre qui ecoute et sauvegarde chaque message envoyé par chaque client
		Compte le nombre de socket connecté
		Si un client envoie un message "exit", le serveur l'enleve tout de suite du tableau de socket
	Client:
		une fois connecté au serveur, un thread "Sending" est lancé. Ce dernier envoie toutes les informations au server toutes les 2 secondes
		Envoie un message "exit" au server pour se deconnecté