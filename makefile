all:
	ant run
	zip -d logisim-evolution.jar 'META-INF/*.SF' 'META-INF/*.RSA' 'META-INF/*SF'
	
